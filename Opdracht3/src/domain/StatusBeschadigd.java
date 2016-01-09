package domain;

public class StatusBeschadigd implements Status{
	Item item;
	
	public StatusBeschadigd(Item item){
		this.item = item;
	}
	
	public void uitlenen(){
		System.out.println("Het product kan niet worden uigeleend.");
	}
	
	public void terugbrengen(){
		System.out.println("Het is niet uigeleend.");
	}
	
	public void herstellen(){
		if(item.getHerstelbaar()){
			System.out.println("Het product is hersteld");
			item.setStatus(item.getUitleenbaar());
		}
	}
	
	public void verwijderen(){
		if(!item.getHerstelbaar()){
			System.out.println("Het product kan niet meer hersteld worden");
			item.setStatus(item.getVerwijderd());
		}
	}
	
}
