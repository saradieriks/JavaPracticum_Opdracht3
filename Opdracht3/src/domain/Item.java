package domain;

import java.util.Iterator;
import java.util.Map;

import io.IOReader;

public class Item {
	
	private String titel;
	private char type;
	private int id;
	
	public String getTitel() {
		return titel;
	}
	public void setTitel(String titel) {
		this.titel = titel;
	}
	public char getType() {
		return type;
	}
	public void setType(char type) {
		this.type = type;
	}
	public int getID() {
		return id;
	}
	public void setID(int id) {
		this.id = id;
	}
		
	public Item (String titel, char type, int id) {
		this.titel = titel;
		this.type = type;
		this.id = id;
	}
	
	public Item (String titel, char type) {
		this.titel = titel;
		this.type = type;
	}
	
	public String toString() {
		return "Titel: " + titel + "\nType: " + type + "\nID: " + id;
	}
	
	public static Item vindItem(String titel, char type) {
		Item teVinden = new Item(titel, type);
		if (type == 'M') {
			for (Map.Entry<String, String> entry: IOReader.getMovies().entrySet()) {
				if (titel == entry.getValue()) {
					teVinden.setTitel(titel);
					teVinden.setType(type);
					teVinden.setID(Integer.parseInt(entry.getKey()));
					return teVinden;
				}
			}
		}
		else if (type == 'G') {
			for (Map.Entry<String, String> entry: IOReader.getGames().entrySet()) {
				if (titel == entry.getValue()) {
					teVinden.setTitel(titel);
					teVinden.setType(type);
					teVinden.setID(Integer.parseInt(entry.getKey()));
					return teVinden;
				}
			}
		}
		else {
			for (Map.Entry<String, String> entry: IOReader.getCDs().entrySet()) {
				if (titel == entry.getValue()) {
					teVinden.setTitel(titel);
					teVinden.setType(type);
					teVinden.setID(Integer.parseInt(entry.getKey()));
					return teVinden;
				}
			}
		}
		
		return null;
	}
	
}
