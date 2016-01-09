package domain;

public class StatusUitleenbaar implements Status{
	Item item;
	
	public StatusUitleenbaar(Item item){
		this.item = item;
	}
	
	public void uitlenen(){
		System.out.println("Het product kan worden uitgeleend.");
		item.setStatus(item.getUitleenbaar());
	}
	
	public void terugbrengen(){
		System.out.println("Het product moet niet teruggebacht worden.");
	}
	
	public void herstellen(){
		System.out.println("Het product werkt naar behoren.");
	}
	
	public void verwijderen(){
		System.out.println("Het product moet verwijderd worden.");
		item.setStatus(item.getVerwijderd());
	}
}
