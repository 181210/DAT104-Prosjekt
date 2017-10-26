package no.hvl.dat104.util;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DatoUtil {
	/**
	 * Foraterer og konkatinerer to strenger til en timestamp
	 * @param dato
	 * @param klokkeslett
	 * @return sql.Timestamp
	 * @throws ParseException
	 */
	public static Timestamp formaterDatoTilStamp(String dato, String klokkeslett) throws ParseException {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        java.util.Date startDato= df.parse(dato + " " + klokkeslett);
        java.sql.Timestamp sq = new java.sql.Timestamp(startDato.getTime());
        return sq;
    }
	/**
	 * Formaterer en timestamp til en dato.
	 * @param timestamp
	 * @return Date Object
	 */
    public static Date formaterStampTilDato(Timestamp timestamp) {
        Date date = new Date(timestamp.getTime());
        return date;
    }
    /**
     * Konkatinerer en dato og et klokkeslett til en streng.
     * @param dato
     * @param klokkeslett
     * @return formatert
     * @throws ParseException
     */
    public static String fintFormatertDato(String dato, String klokkeslett) throws ParseException {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        java.util.Date startDato = df.parse(dato + " " + klokkeslett);
        String newStartDateString = df.format(startDato);
        return newStartDateString;
    }

}