package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import io.IOReader;

public class Reservatie {

	private Double prijs;
	private Datum startDatum;
	private Item item;
	private int aantalDagen;
	private Double boete;
	private Boolean betaald;
	private int klantID;
	
	public Double getPrijs() {
		return prijs;
	}
	public void setPrijs(Double prijs) {
		this.prijs = prijs;
	}
	public Datum getStartDatum() {
		return startDatum;
	}
	public void setStartDatum(Datum startDatum) {
		this.startDatum = startDatum;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public int getAatalDagen() {
		return aantalDagen;
	}
	public void setAatalDagen(int aatalDagen) {
		this.aantalDagen = aatalDagen;
	}
	public Double getBoete() {
		return boete;
	}
	public void setBoete(Double boete) {
		this.boete = boete;
	}
	public Boolean getBetaald() {
		return betaald;
	}
	public void setBetaald(Boolean betaald) {
		this.betaald = betaald;
	}
	
	public int klantID() {
		return klantID;
	}
	
	public void setKlantID (int klantID) {
		this.klantID = klantID;
	}
	
	public Reservatie (Double prijs, Datum startDatum, Item item, int aantalDagen, Double boete, Boolean betaald, int klantID) {
		this.prijs = prijs;
		this.startDatum = startDatum;
		this.item = item;
		this.aantalDagen = aantalDagen;
		this.boete = boete;
		this.betaald = false;
		this.klantID = klantID;
	}
	
	public Reservatie (Double prijs, Datum startDatum, Item item, int aantalDagen, Double boete, Boolean betaald) {
		this.prijs = prijs;
		this.startDatum = startDatum;
		this.item = item;
		this.aantalDagen = aantalDagen;
		this.boete = boete;
		this.betaald = false;
	}
	
	public Reservatie (Double prijs, Datum startDatum, Item item, int aantalDagen, int klantID) {
		this.prijs = prijs;
		this.startDatum = startDatum;
		this.item = item;
		this.aantalDagen = aantalDagen;
		this.klantID = klantID;
	}
	
	public Reservatie (Double prijs, Datum startDatum, Item item, int aantalDagen, Double boete, int klantID) {
		this.prijs = prijs;
		this.startDatum = startDatum;
		this.item = item;
		this.aantalDagen = aantalDagen;
		this.boete = boete;
		this.betaald = false;
		this.klantID = klantID;
	}
	
	public Reservatie (Item item, int aantalDagen, int klantID) {
		this.item = item;
		this.aantalDagen = aantalDagen;
		this.klantID = klantID;
		this.prijs = 0D;
		this.boete = 0D;
		this.betaald = false;
		this.startDatum = new Datum();
	}
	
	public String toString() {
		return prijs + " " + startDatum + " " + item + " " + aantalDagen + " " + boete + " " + betaald + " " + klantID;
	}
	
	public static Boolean isAvailable (String value, char type) {
		Boolean teruggeven = false;
		if (type == 'M') {
			for (Map.Entry<String, String> entry: IOReader.getMovies().entrySet()) {
				String film = entry.getValue().replaceAll(Pattern.quote("+")," ");
				if (value.equals(film)) {
					teruggeven = true;
				}
			}
		}
		else if (type == 'G') {
			for (Map.Entry<String, String> entry: IOReader.getGames().entrySet()) {
				String film = entry.getValue().replaceAll(Pattern.quote("+"), " ");
				if (value.equals(film)) {
					teruggeven = true;
				}
			}
		}
		else {
			for (Map.Entry<String, String> entry: IOReader.getCDs().entrySet()) {
				String film = entry.getValue().replaceAll(Pattern.quote("+"), " ");
				if (value.equals(film)) {
					teruggeven = true;
				}
			}
		}
		return teruggeven;
	}
	
	public static List<Reservatie> haalReservatiesOp (String naam, String voornaam) {
		List<Reservatie> object = new ArrayList<Reservatie>();
		int id = Klant.vindKlantId(naam, voornaam);
		for (Map.Entry<String, String> entry: IOReader.getReservaties().entrySet()) {
			int begin = 6;
			int tijdelijk = entry.getValue().indexOf(";");
			int einde = tijdelijk - 6;
			int gevonden = Integer.parseInt(entry.getValue().substring(begin, einde));
			if (gevonden == id) {
				Reservatie res = new Reservatie();
				System.out.println("Gevonden");
			}
		}
		return object;
	}
}
