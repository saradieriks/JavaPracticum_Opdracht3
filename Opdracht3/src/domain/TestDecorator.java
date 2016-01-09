package domain;

public class TestDecorator {

	public static void main(String[] args) {
		KassaBonMain kassabon = new KassaBon();
		kassabon.getDescription();
		
		kassabon = new HeaderDatumUitlening(kassabon);
		kassabon.getDescription();
		
		kassabon = new HeaderKassabonNummer(kassabon);
		kassabon.getDescription();
		
		kassabon = new HeaderOpeningsUren(kassabon);
		kassabon.getDescription();
		
		kassabon = new HeaderTijdstip(kassabon);
		kassabon.getDescription();
		
		kassabon = new FooterBoodschap(kassabon);
		kassabon.getDescription();
		
		kassabon = new FooterTotaal(kassabon);
		kassabon.getDescription();
		
		kassabon = new FooterVasteBoodschap(kassabon);
		kassabon.getDescription();
		
		}

}
