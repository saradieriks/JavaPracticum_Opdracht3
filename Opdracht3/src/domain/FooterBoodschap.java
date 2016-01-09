package domain;

public class FooterBoodschap extends FooterDecorator{
	KassaBonMain kassabon;
	
	public FooterBoodschap(KassaBonMain kassabon){
		this.kassabon = kassabon;
	}
	
	@Override
	public void getDescription(){
		System.out.println("Boodschap: Tijdens de verbouwingen zijn we alle dagen open tot 16u");
	}
}
