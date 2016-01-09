package domain;

public class HeaderKassabonNummer extends HeaderDecorator{
	KassaBonMain kassabon;
	
	public HeaderKassabonNummer(KassaBonMain kassabon){
		this.kassabon = kassabon;
	}
	
	public void getDescription(){
		System.out.println("kassabonnummer: " + this.getNummer());
	}
}
