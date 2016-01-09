package domain;

import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import io.IOReader;

public class Item implements IItem{
	
	private String titel;
	private char type;
	private int id;
	private double aankoopPrijs;
	private boolean beschadigd;
	private boolean herstelbaar = true;
	
	private StatusUitleenbaar uitleenbaar;
	private StatusUitgeleend uitgeleend;
	private StatusBeschadigd Statusbeschadigd;
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

	public double getAankoopPrijs(){
		return this.aankoopPrijs;
	}
	
	public void setAankoopPrijs(double prijs){
		this.aankoopPrijs = prijs;
	}
	
	public boolean getBeschadigd()
	{
		return this.beschadigd;
	}
	
	public void setBeschadigd(boolean beschadigd){
		this.beschadigd = beschadigd;
	}
	
	public boolean getHerstelbaar(){
		return this.herstelbaar;
	}
	
	public void setHersteld(boolean herstelbaar){
		this.herstelbaar = herstelbaar;
	}
	
	public Status getUitleenbaar(){
		return this.uitleenbaar;
	}
		
	public Status getVerwijderd(){
		return this.verwijderd;
	}
	
	public Status getStatusBeschadigd(){
		return this.Statusbeschadigd;
	}
	
	public void uitleenbaar(){
		status.uitlenen();
	}
	
	public void terugbrengen(){
		status.terugbrengen();;
	}
	
	public void herstellen(){
		status.herstellen();
	}
	
	public void verwijderen(){
		status.verwijderen();
	}
	
	public Status getStatus(){
		return this.status;
	}
	
	public void setStatus(Status status){
		this.status = status;
	}
		
	public Item (String titel, char type, int id) {
		this.titel = titel;
		this.type = type;
		this.id = id;
		this.beschadigd = false;
		uitleenbaar = new StatusUitleenbaar(this);
		uitgeleend = new StatusUitgeleend(this);
		Statusbeschadigd = new StatusBeschadigd(this);
		verwijderd = new StatusVerwijderd(this);
	}
	
	public Item (String titel, char type) {
		this.titel = titel;
		this.type = type;
		this.beschadigd = false;
		uitleenbaar = new StatusUitleenbaar(this);
		uitgeleend = new StatusUitgeleend(this);
		Statusbeschadigd = new StatusBeschadigd(this);
		verwijderd = new StatusVerwijderd(this);
	}
	
	public Item () {
		
	}
	
	public String toString() {
		return "Titel: " + titel + "\nType: " + type + "\nID: " + id;
	}
	
	public static Item vindItemUitId(String id) {
		Matcher matcher = Pattern.compile("\\d+").matcher(id);
		matcher.find();
		int gevonden = Integer.valueOf(matcher.group());
		char type = Character.valueOf(id.charAt(0));
		Item teVinden = new Item();
		if (type == 'M') {
			for (Map.Entry<String, String> entry: IOReader.getMovies().entrySet()) {
				if (id.equals(entry.getKey())) {
					String titel = entry.getValue().replaceAll(Pattern.quote("+"), " ");
					teVinden.setTitel(titel);
					teVinden.setType('M');
					teVinden.setID(gevonden);
					return teVinden;
				}
			}
		}
		else if (type == 'G') {
			for (Map.Entry<String, String> entry: IOReader.getGames().entrySet()) {
				if (id.equals(entry.getKey())) {
					String titel = entry.getValue().replaceAll(Pattern.quote("+"), " ");
					teVinden.setTitel(titel);
					teVinden.setType('G');
					teVinden.setID(gevonden);
					return teVinden;
				}
			}
		}
		else {
			for (Map.Entry<String, String> entry: IOReader.getCDs().entrySet()) {
				if (id.equals(entry.getKey())) {
					String titel = entry.getValue().replaceAll(Pattern.quote("+"), " ");
					teVinden.setTitel(titel);
					teVinden.setType('C');
					teVinden.setID(gevonden);
					return teVinden;
				}
			}
		}
		return null;
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
	
	public Status getUigeleend() {
		return this.uitgeleend;
	}
	
}
