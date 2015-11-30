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
		this.boodschap = "Wij willen u graag verwittigen over het nieuwe beschikbare item" + item.getTitel();
		stuurMail(eMail, boodschap);
	}
	
	

}
