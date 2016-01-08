package domain;

import java.util.Map;

import controller.WinkelController;
import io.IOReader;

public class Klant implements Observer {

	private int klantID;
	private String naam;
	private String voornaam;
	private Adres adres;
	private String email;
	private Boolean isObserver;
	private WinkelController winkelController;
	
	public int getKlantID() {
		return klantID;
	}
	public void setKlantID(int klantID) {
		this.klantID = klantID;
	}
	public String getNaam() {
		return naam;
	}
	public void setNaam(String naam) {
		this.naam = naam;
	}
	public String getVoornaam() {
		return voornaam;
	}
	public void setVoornaam(String voornaam) {
		this.voornaam = voornaam;
	}
	public Adres getAdres() {
		return adres;
	}
	public void setAdres(Adres adres) {
		this.adres = adres;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Klant (int klantID, String naam, String voornaam, Adres adres,
				  String email) {
		this.klantID = klantID;
		this.naam = naam;
		this.voornaam = voornaam;
		this.adres = adres;
		this.email = email;
	}
	
	public Klant (String naam, String voornaam, Adres adres, String email) {
		this.naam = naam;
		this.voornaam = voornaam;
		this.adres = adres;
		this.email = email;
	}
	
	public Klant (int klantID, String naam, String voornaam, Adres adres) {
		this.klantID = klantID;
		this.naam = naam;
		this.voornaam = voornaam;
		this.adres = adres;
	}
	
	public Klant (String naam, String voornaam, Adres adres) {
		this.naam = naam;
		this.voornaam = voornaam;
		this.adres = adres;
	}
	
	public Klant (String naam, String voornaam) {
		this.naam = naam;
		this.voornaam = voornaam;
	}
	
	public String toString() {
		return voornaam + " " + naam  + "\n" + adres.toString() + "\n" + 
			   email;
	}
	
	//observer pattern
	
	public void maakKlantObserver(Boolean isObserver, WinkelController winkelController)
	{
		this.isObserver = isObserver;
		if (isObserver == true)
		{
			winkelController.addObserver(this);
		}
		else
		{
			winkelController.removeObserver(this);
		}
	}
	
	public void update(Subject o, Item item) {
		if (this.isObserver == true && o == winkelController ) {
			Mail mailClient = new Mail();
			mailClient.stuurMailnaarKlant(this,item);
					}
	}
	
	// Klant id zoeken op basis van naam en voornaam
	public static int vindKlantId(String naam, String voornaam) {
		Klant teVinden = new Klant(naam, voornaam);
		int idGevonden = 0;
		for (Map.Entry<Integer, String> entry: IOReader.getKlanten().entrySet()) {
			if(entry.getValue().toLowerCase().contains(teVinden.getNaam().toLowerCase()) && 
					entry.getValue().toLowerCase().contains(teVinden.getVoornaam().toLowerCase())) {
				idGevonden = entry.getKey();
			}
		}
		return idGevonden;
	}
	
}
