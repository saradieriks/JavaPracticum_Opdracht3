package domain;

public class HeaderTijdstip extends HeaderDecorator{
	KassaBonMain kassabon;
	
	public HeaderTijdstip(KassaBonMain kassabon){
		this.kassabon = kassabon;
	}
	
	public void getDescription(){
		System.out.println("Tijdstip uitlening: " + ((KassaBon)this.kassabon).getTijdstip());
	}
}
