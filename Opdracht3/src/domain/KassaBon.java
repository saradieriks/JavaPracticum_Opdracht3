package domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ui.WinkelPanel;

public class KassaBon extends KassaBonMain{
	WinkelPanel winkelPanel = new WinkelPanel();
	List<Item> lijnBestelling = new ArrayList<Item>();
	private int nummer = 0;
	private Datum datum;
	private Date tijdstip;
	
	public KassaBon(){
		this.nummer = this.nummer + 1;
		this.datum = new Datum();
		tijdstip = new Date(System.currentTimeMillis());
	}
	
	public int getNummer(){
		return this.nummer;
	}
	
	public void setNummer(int nummer){
		this.nummer = nummer;
	}
	
	public Datum getDatum(){
		return this.datum;
	}
	
	public Date getTijdstip(){
		return this.tijdstip;
	}
	
	public void Body(){
		for(int row = 1; row < winkelPanel.tblUitleningen.getRowCount(); row++){
			String type = (String)winkelPanel.tblUitleningen.getValueAt(row, 0);
			String titel = (String)winkelPanel.tblUitleningen.getValueAt(row, 1);
			Character charType = type.charAt(0);
		    Item item = new Item(titel, charType);
		    lijnBestelling.add(item);
		}
		
		for(Item item : lijnBestelling)
			System.out.println("Type: " + item.getType() + "\tOmschrijving: " + item.getTitel() + "\n");
		
	}
	
	public void getDescription(){
		this.Body();
	}
		
}
