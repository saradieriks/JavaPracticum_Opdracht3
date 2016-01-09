package domain;

public class FooterTotaal extends FooterDecorator{
	KassaBonMain kassabon;
	
	public FooterTotaal(KassaBonMain kassabon){
		this.kassabon = kassabon;
	}
	
	public void getDescription(){
		System.out.println("Totaal: ");
	}
}
