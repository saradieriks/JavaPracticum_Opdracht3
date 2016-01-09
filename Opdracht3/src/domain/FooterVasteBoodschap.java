package domain;

public class FooterVasteBoodschap extends FooterDecorator{
	KassaBonMain kassabon;
	
	public FooterVasteBoodschap(KassaBonMain kassabon){
		this.kassabon = kassabon;
	}
	
	public void getDescription(){
		System.out.println("Dank u voor uw aankoop. Tot binnenkort.");
	}
}
