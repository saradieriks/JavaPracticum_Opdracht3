package domain;

public class HeaderKassabonNummer extends KassaBonDecorator{
	KassaBonMain kassabon;
	
	public HeaderKassabonNummer(KassaBonMain kassabon){
		this.kassabon = kassabon;
	}
	//test
	public void getDescription(){
		System.out.println("kassabonnummer: " + ((KassaBon)this.kassabon).getNummer());
	}
}
