package domain;

import java.util.Map;

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
	}
	
	public static Boolean isAvailable (Item item) {
		Boolean teruggeven = false;
		if (item.getType() == 'M') {
			for (Map.Entry<String, String> entry: IOReader.getMovies().entrySet()) {
				if (item.getTitel() == entry.getValue()) {
					teruggeven = true;
				}
			}
		}
		else if (item.getType() == 'G') {
			for (Map.Entry<String, String> entry: IOReader.getGames().entrySet()) {
				if (item.getTitel() == entry.getValue()) {
					teruggeven = true;
				}
			}
		}
		else {
			for (Map.Entry<String, String> entry: IOReader.getCDs().entrySet()) {
				if (item.getTitel() == entry.getValue()) {
					teruggeven = true;
				}
			}
		}
		return teruggeven;
	}
}
