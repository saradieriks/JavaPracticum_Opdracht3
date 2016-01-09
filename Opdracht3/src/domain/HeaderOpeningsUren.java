package domain;

public class HeaderOpeningsUren extends HeaderDecorator{
	KassaBonMain kassabon;
	
	public HeaderOpeningsUren(KassaBonMain kassabon){
		this.kassabon = kassabon;
	}
	
	public void getDescription(){
		System.out.println("Openingsuren: \nmaandag: 13u - 19u\ndinsdag: 09u - 19u\nwoensdag: gesloten"
				+ "\ndonderdag: 09u - 19u\nvrijdag: 09u - 19u\nzaterdag: 09 - 23u\nzondag: 10u - 15u");
	}
}
