package no.hvl.dat104.controller.admin;

import static no.hvl.dat104.controller.JspMappings.ADMINISTRER_JSP;
import static no.hvl.dat104.controller.JspMappings.LANDING_JSP;
import static no.hvl.dat104.controller.JspMappings.LANDING_STYRER_JSP;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import no.hvl.dat104.controller.UrlMappings;
import no.hvl.dat104.dataaccess.IBrukerEAO;
import no.hvl.dat104.dataaccess.IRolleEAO;
import no.hvl.dat104.model.Bruker;
import no.hvl.dat104.model.Rolle;
import no.hvl.dat104.util.FlashUtil;
import no.hvl.dat104.util.InnloggingUtil;

/**
 * Servlet implementation class AdministrerController
 */
public class AdministrerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private IBrukerEAO brukerEAO;
	@EJB
	private IRolleEAO rolleEAO;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Skriv ut en liste med brukere som ikke er godkjent
		if (!InnloggingUtil.erInnLoggetSomAdmin(request)) {
			if (!InnloggingUtil.erInnloggetSomBruker(request)) {
				// Bruker har ingen sesjon og blir derfor redirectet til index
				FlashUtil.Flash(request, "error", "Ingen tilgang.");
				request.getRequestDispatcher(LANDING_JSP).forward(request, response);
			} else {
				// Bruker er innlogget som aktivitetsstyrer og ikke admin
				FlashUtil.Flash(request, "error", "Ulovlig handling: Du er ikke administrator!");
				request.getRequestDispatcher(LANDING_STYRER_JSP).forward(request, response);
			}
		} else {
			// Bruker er innlogget som admin, list brukere
			List<Bruker> liste = brukerEAO.alleBrukerne();
			ArrayList<Bruker> brukere = new ArrayList<Bruker>(liste);
			brukere.remove(InnloggingUtil.innloggetSomAdmin(request));

			request.getSession().setAttribute("brukere", brukere);
			request.getRequestDispatcher(ADMINISTRER_JSP).forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//Sjekker f�rst om bruker er admin
		if (InnloggingUtil.erInnLoggetSomAdmin(request)) {
			Integer idUserToChange = Integer.valueOf(request.getParameter("id"));
			Bruker sessionAdmin = InnloggingUtil.innloggetSomAdmin(request);
			Integer idAdmin = sessionAdmin.getId();
			//Sjekker om brukeren pr�ver � endre sin egen rolle
			if (idUserToChange.equals(idAdmin)) {
				if(request.getSession().getAttribute("success") != null)
					request.getSession().removeAttribute("success");
				request.getSession().setAttribute("error", "Du kan ikke endre din egen bruker");
				response.sendRedirect(UrlMappings.ADMINISTRER_URL);
			} else {
				//Hvis brukeren som skal endres ikke er admin, gj�res endringen
				Bruker b = byttRolle(request);
				if(request.getSession().getAttribute("error") != null)
					request.getSession().removeAttribute("error");
				request.getSession().setAttribute("success",
						"Suksess! Rollen til " + b.getFornavn() + " " + b.getEtternavn() + " ble endret.");
				response.sendRedirect(UrlMappings.ADMINISTRER_URL);
			}
		} else {
			FlashUtil.Flash(request, "error", "Ingen tilgang");
			response.sendRedirect(UrlMappings.LANDING_URL);
		}
	}

	//Metode for � bytte rolle p� en bruker...
	private Bruker byttRolle(HttpServletRequest request) {
		Integer id = Integer.valueOf(request.getParameter("id"));
		Integer idrolle = Integer.valueOf(request.getParameter("rolle"));
		Bruker b = brukerEAO.finnBruker(id);
		Rolle r = rolleEAO.finnRolle(idrolle);
		b.setIdRolle(r);
		brukerEAO.endreRollePaaBruker(id, r);
		return b;
	}

}
