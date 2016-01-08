package domain;

import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;

import io.IOReader;

public class Item implements IItem{
	
	private String titel;
	private char type;
	private int id;
	
	private StatusUitleenbaar uitleenbaar;
	private StatusUitgeleend uitgeleend;
	private StatusBeschadigd beschadigd;
	private StatusVerwijderd verwijderd;
	
	private Status status = uitleenbaar;
	
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
	
	public StatusUitleenbaar getUitleenbaar(){
		return this.uitleenbaar;
	}
	
	public StatusUitgeleend getUitgeleend(){
		return this.uitgeleend;
	}
	
	public StatusBeschadigd getBeschadigd(){
		return this.beschadigd;
	}
	
	public StatusVerwijderd getVerwijderd(){
		return this.verwijderd;
	}
		
	public Item (String titel, char type, int id) {
		this.titel = titel;
		this.type = type;
		this.id = id;
		uitleenbaar = new StatusUitleenbaar(this);
		uitgeleend = new StatusUitgeleend(this);
		beschadigd = new StatusBeschadigd(this);
		verwijderd = new StatusVerwijderd(this);
	}
	
	public Item (String titel, char type) {
		this.titel = titel;
		this.type = type;
		uitleenbaar = new StatusUitleenbaar(this);
		uitgeleend = new StatusUitgeleend(this);
		beschadigd = new StatusBeschadigd(this);
		verwijderd = new StatusVerwijderd(this);
	}
	
	public Item () {
		
	}
	
	public String toString() {
		return "Titel: " + titel + "\nType: " + type + "\nID: " + id;
	}
	
	public static Item vindItem(String titel, char type) {
		Item teVinden = new Item();
		String vervang = titel.replaceAll(Pattern.quote(" "), "+");
		if (type == 'M') {
			for (Map.Entry<String, String> entry: IOReader.getMovies().entrySet()) {
				if (vervang.equals(entry.getValue())) {
					teVinden.setTitel(titel);
					teVinden.setType(type);
					teVinden.setID(Integer.parseInt(entry.getKey().replaceAll("M", "")));
					System.out.println("Item: " + teVinden.toString());
					return teVinden;
				}
			}
		}
		else if (type == 'G') {
			for (Map.Entry<String, String> entry: IOReader.getGames().entrySet()) {
				if (titel == entry.getValue()) {
					teVinden.setTitel(titel);
					teVinden.setType(type);
					teVinden.setID(Integer.parseInt(entry.getKey().replaceAll("G", "")));
					return teVinden;
				}
			}
		}
		else {
			for (Map.Entry<String, String> entry: IOReader.getCDs().entrySet()) {
				if (titel == entry.getValue()) {
					teVinden.setTitel(titel);
					teVinden.setType(type);
					teVinden.setID(Integer.parseInt(entry.getKey().replaceAll("C", "")));
					return teVinden;
				}
			}
		}
		
		return null;
	}
	@Override
	public double getPrijs(int aantalDagen) {
		return 0;
	}
	
}
