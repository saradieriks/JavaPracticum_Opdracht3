package domain;

public class StatusVerwijderd implements Status{
	Item item;
	
	public StatusVerwijderd(Item item){
		this.item = item;
	}
	
	public void uitlenen(){
		System.out.println("Het product is verwijderd en kan niet meer worden uitgeleend.");
	}
	
	public void terugbrengen(){
		System.out.println("Het product is verwijderd en is niet uitgeleend.");
	}
	
	public void herstellen(){
		System.out.println("Het product kan niet meer hersteld worden.");
	}
	
	public void verwijderen(){
	}
}
