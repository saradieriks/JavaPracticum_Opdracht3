package domain;

public class Mail {
	
	private String eMail;
	private String boodschap;
	
	//generieke mail
	public void stuurMail(String eMail, String boodschap ) {
		
		System.out.println ("MAIL IS VERSTUURD!  <TO:" +eMail+ "> " + "\n[Boodschap: "+ boodschap + "]");
		
	}
	
	//mail met klant & informeren klant er is een nieuw item
	public void stuurMailnaarKlant(Klant klant, Item item)
	{
		this.eMail = klant.getEmail();
		String type ="";
		if (item.getType() == 'M') {type = "de net binnen gekomen film: ";}
		if (item.getType() == 'C') {type = "de net binnen gekomen CD: ";}
		if (item.getType() == 'G') {type = "de net binnen gekomen game: ";}
		this.boodschap = "\nBeste, " + klant.getVoornaam() + " " +
		klant.getNaam() + "\nWij willen u graag verwittigen over " + type + item.getTitel();
		stuurMail(eMail, boodschap);
	}
	
	

}
