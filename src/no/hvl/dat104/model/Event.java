package no.hvl.dat104.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Modellrepresentasjon av Event
 * 
 * @author Kristoffer-Andre Kalliainen
 *
 */
@Entity(name = "Event")
@Table(name = "event", schema = "db")
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String navn;
	private String beskrivelse;
	@Column(name = "tid_fra")
	private Timestamp tidFra;
	@Column(name = "tid_til")
	private Timestamp tidTil;
	@Column(name = "faktisk_start")
	private Timestamp faktiskStart;
	@Column(name = "faktisk_slutt")
	private Timestamp faktiskSlutt;
	private String status;
	private String sted;
	
	//Ny
	@ManyToOne
	@JoinColumn(name = "id_aktivitet", referencedColumnName = "id")
	private Aktivitet idAktivitet;
	
	//Gammel (i tilfelle noe g�r galt)
	/*	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_aktivitet", referencedColumnName = "id")
	private Aktivitet idAktivitet;*/
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idEvent", fetch = FetchType.LAZY)
	private List<Tilbakemelding> tilbakemeldinger;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idEvent", fetch = FetchType.LAZY)
	private List<LiveTilbakemelding> liveTilbakemeldinger;

	/**
	 * Tom konstruktor til Event
	 */
	public Event() {

	}
	

	public String getNavn() {
		return navn;
	}

	/**
	 * @param navn
	 *            the navn to set
	 */
	public void setNavn(String navn) {
		this.navn = navn;
	}

	/**
	 * @return the tidFra
	 */
	public Timestamp getTidFra() {
		return tidFra;
	}

	/**
	 * @param tidFra
	 *            the tidFra to set
	 */
	public void setTidFra(Timestamp tidFra) {
		this.tidFra = tidFra;
	}

	/**
	 * @return the tidTil
	 */
	public Timestamp getTidTil() {
		return tidTil;
	}

	/**
	 * @param tidTil
	 *            the tidTil to set
	 */
	public void setTidTil(Timestamp tidTil) {
		this.tidTil = tidTil;
	}

	/**
	 * @return the faktiskStart
	 */
	public Timestamp getFaktiskStart() {
		return faktiskStart;
	}

	/**
	 * @param faktiskStart
	 *            the faktiskStart to set
	 */
	public void setFaktiskStart(Timestamp faktiskStart) {
		this.faktiskStart = faktiskStart;
	}

	/**
	 * @return the faktiskSlutt
	 */
	public Timestamp getFaktiskSlutt() {
		return faktiskSlutt;
	}

	/**
	 * @param faktiskSlutt
	 *            the faktiskSlutt to set
	 */
	public void setFaktiskSlutt(Timestamp faktiskSlutt) {
		this.faktiskSlutt = faktiskSlutt;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the sted
	 */
	public String getSted() {
		return sted;
	}

	/**
	 * @param sted
	 *            the sted to set
	 */
	public void setSted(String sted) {
		this.sted = sted;
	}

	/**
	 * @return the idAktivitet
	 */
	public Aktivitet getIdAktivitet() {
		return idAktivitet;
	}

	/**
	 * @param idAktivitet
	 *            the idAktivitet to set
	 */
	public void setIdAktivitet(Aktivitet idAktivitet) {
		this.idAktivitet = idAktivitet;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @return the beskrivelse
	 */
	public String getBeskrivelse() {
		return beskrivelse;
	}

	/**
	 * @param beskrivelse
	 *            the beskrivelse to set
	 */
	public void setBeskrivelse(String beskrivelse) {
		this.beskrivelse = beskrivelse;
	}

	/**
	 * @return the tilbakemeldinger
	 */
	public List<Tilbakemelding> getTilbakemeldinger() {
		return tilbakemeldinger;
	}

	/**
	 * @param tilbakemeldinger
	 *            the tilbakemeldinger to set
	 */
	public void setTilbakemeldinger(List<Tilbakemelding> tilbakemeldinger) {
		this.tilbakemeldinger = tilbakemeldinger;
	}

	/**
	 * @return the liveTilbakemeldinger
	 */
	public List<LiveTilbakemelding> getLiveTilbakemeldinger() {
		return liveTilbakemeldinger;
	}

	/**
	 * @param liveTilbakemeldinger
	 *            the liveTilbakemeldinger to set
	 */
	public void setLiveTilbakemeldinger(List<LiveTilbakemelding> liveTilbakemeldinger) {
		this.liveTilbakemeldinger = liveTilbakemeldinger;
	}
	
	/**
	 * Custom toString metode, for � skrive ut innholdet av objektet (N.B. Sjekker ikke om verdier er null!)
	 */
	public String tilStreng() {
		return "Event [id=" + id + ", \nnavn=" + navn + ", \ntidFra=" + tidFra + ", \ntidTil=" + tidTil
				+ ", \nfaktiskStart=" + faktiskStart + ", \nfaktiskSlutt=" + faktiskSlutt + ", \nstatus=" + status
				+ ", \nsted=" + sted + ", \nidAktivitet=" + idAktivitet + ", \ntilbakemeldinger=" + tilbakemeldinger
				+ ", \nliveTilbakemeldinger=" + liveTilbakemeldinger + "]";
	}

}
