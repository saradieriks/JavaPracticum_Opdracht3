package domain;

public class Adres {

	private String straat;
	private String nummer;
	private String box;
	private String postcode;
	private String gemeente;
	private String land;
	public String getStraat() {
		return straat;
	}
	public void setStraat(String straat) {
		this.straat = straat;
	}
	public String getNummer() {
		return nummer;
	}
	public void setNummer(String nummer) {
		this.nummer = nummer;
	}
	public String getBox() {
		return box;
	}
	public void setBox(String box) {
		this.box = box;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getGemeente() {
		return gemeente;
	}
	public void setGemeente(String gemeente) {
		this.gemeente = gemeente;
	}
	public String getLand() {
		return land;
	}
	public void setLand(String land) {
		this.land = land;
	}
	
	public Adres (String straat, String nummer, String box, String postcode,
				  String gemeente, String land) {
		this.straat = straat;
		this.nummer = nummer;
		this.box = box;
		this.postcode = postcode;
		this.gemeente = gemeente;
		this.land = land;
	}
	
	public Adres (String straat, String nummer, String postcode,
			  String gemeente, String land) {
		this.straat = straat;
		this.nummer = nummer;
		this.postcode = postcode;
		this.gemeente = gemeente;
		this.land = land;
	}
	
	public Adres (String straat, String nummer, String postcode,
			  String gemeente) {
		this.straat = straat;
		this.nummer = nummer;
		this.postcode = postcode;
		this.gemeente = gemeente;
	}
	
	public String toString() {
		return straat + " " + nummer + "\n" + postcode + " " + gemeente;
	}
}
