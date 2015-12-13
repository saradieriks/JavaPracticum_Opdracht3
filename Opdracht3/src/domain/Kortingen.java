package domain;

public enum Kortingen {
	VIJF_ITEMS ("5 items", "domain.VijfItems"),
	EEN_DAG ("1 dag", "domain.EenDag"),
	LEUVENAAR ("In Leuven wonen", "domain.Adres");		

	private final String omschrijving;   
	private final String klasseNaam; 
		
	Kortingen(String omschrijving, String klasseNaam) {
	    this.omschrijving = omschrijving;
	    this.klasseNaam = klasseNaam;
	}
		
	public String getOmschrijving() { return omschrijving; }
	public String getKlasseNaam() { return klasseNaam; }
}
