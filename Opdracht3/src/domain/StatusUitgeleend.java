package domain;

public class StatusUitgeleend implements Status{
	Item item;
	
	public StatusUitgeleend(Item item){
		this.item = item;
	}
	
	public void uitlenen(){
		System.out.println("Het product is uigeleend.");
	}
	
	public void terugbrengen(){
		if(!item.getBeschadigd()){
			item.setStatus(item.getStatusBeschadigd());
			double prijs = item.getPrijs(aantalDagen) / 3;
		}
		else{}{
			item.setStatus(item.getUitleenbaar());
		}	
	}
	
	public void herstellen(){
		
	}
	
	public void verwijderen(){
		
	}

}
