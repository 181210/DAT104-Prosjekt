package no.hvl.dat104.controller;

public final class JspMappings {
	
	// ----------------- BRUKER -----------------
	public static final String LOGGINN_JSP = "WEB-INF/views/logginn.jsp";
	public static final String LANDING_JSP = "WEB-INF/views/index.jsp";
	public static final String OPPRETTBRUKER_JSP = "WEB-INF/views/styrer/opprettbruker.jsp";
	public static final String REDIGERBRUKER_JSP = "WEB-INF/views/styrer/redigerbruker.jsp";

	// ----------------- ADMIN -----------------
	public static final String ADMINISTRER_JSP = "WEB-INF/views/admin/administrer.jsp";

	// ----------------- DELTAGER -----------------
	public static final String DELTAEVENT_JSP = LANDING_JSP;
	public static final String EVENTFERDIG_JSP = "WEB-INF/views/deltager/eventferdig.jsp";
	public static final String GITILBAKEMELDING_JSP = "WEB-INF/views/deltager/gitilbakemelding.jsp";

	// ----------------- STYRER -----------------
	public static final String LANDING_STYRER_JSP = "WEB-INF/views/styrer/index.jsp";

	// ----------------- EVENTER -----------------
	public static final String EVENTRESULTATER_JSP = "WEB-INF/views/styrer/event/eventresultater.jsp";
	public static final String LAGEVENT_JSP = "WEB-INF/views/styrer/event/lagevent.jsp";
	public static final String LIVE_EVENT_JSP = "WEB-INF/views/styrer/event/liveevent.jsp";
	public static final String PRE_EVENT_JSP = "WEB-INF/views/styrer/event/preEvent.jsp";
	public static final String POST_LIVE_EVENT_JSP = "WEB-INF/views/styrer/event/postLiveEvent.jsp";
	public static final String REDIGEREVENT_JSP = "WEB-INF/views/styrer/event/redigerevent.jsp";
	public static final String VIS_EVENT_JSP = "WEB-INF/views/styrer/event/visevent.jsp";
	public static final String MINEEVENTER_JSP = "WEB-INF/views/styrer/event/mineeventer.jsp";

	// ----------------- AKTIVITER -----------------
	public static final String LAGAKTIVITET_JSP = "WEB-INF/views/styrer/aktivitet/lagaktivitet.jsp";
	public static final String VISAKTIVITET_JSP = "WEB-INF/views/styrer/aktivitet/visaktivitet.jsp";
	public static final String REDIGERAKTIVITET_JSP = "WEB-INF/views/styrer/aktivitet/redigeraktivitet.jsp";
	public static final String MINEAKTIVITETER_JSP = "WEB-INF/views/styrer/aktivitet/mineaktiviteter.jsp";

}
