package domain;

public class Klant {

	private int klantID;
	private String naam;
	private String voornaam;
	private Adres adres;
	private String email;
	private boolean ingeschreven;
	
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
	public boolean getIngeschreven(){
		return ingeschreven;
	}
	public void setIngeschreven(boolean ingeschreven){
		this.ingeschreven = ingeschreven;
	}
	
	public Klant (int klantID, String naam, String voornaam, Adres adres,
			  String email, boolean ingeschreven) {
		this.klantID = klantID;
		this.naam = naam;
		this.voornaam = voornaam;
		this.adres = adres;
		this.email = email;
		this.ingeschreven = ingeschreven;
	}
	
	public Klant (int klantID, String naam, String voornaam, Adres adres,
				  String email) {
		this.klantID = klantID;
		this.naam = naam;
		this.voornaam = voornaam;
		this.adres = adres;
		this.email = email;
		this.ingeschreven = false;
	}
	
	public Klant (String naam, String voornaam, Adres adres, String email) {
		this.naam = naam;
		this.voornaam = voornaam;
		this.adres = adres;
		this.email = email;
		this.ingeschreven = false;
	}
	
	public Klant (int klantID, String naam, String voornaam, Adres adres) {
		this.klantID = klantID;
		this.naam = naam;
		this.voornaam = voornaam;
		this.adres = adres;
		this.ingeschreven = false;
	}
	
	public Klant (String naam, String voornaam, Adres adres) {
		this.naam = naam;
		this.voornaam = voornaam;
		this.adres = adres;
		this.ingeschreven = false;
	}
	
	public String toString() {
		return voornaam + " " + naam  + "\n" + adres.toString() + "\n" + 
			   email;
	}
	
}
