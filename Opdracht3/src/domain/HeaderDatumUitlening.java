package domain;

public class HeaderDatumUitlening extends KassaBonDecorator{
	KassaBonMain kassabon;
	
	public HeaderDatumUitlening(KassaBonMain kassabon){
		this.kassabon = kassabon;
	}
	
	public void getDescription(){
		System.out.println("Datum uitlening: " + ((KassaBon)this.kassabon).getDatum());
	}
}
