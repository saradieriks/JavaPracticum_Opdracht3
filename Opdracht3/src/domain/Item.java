package domain;

public class Item {
	
	private String titel;
	private char type;
	
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
	
	public Item (String titel, char type) {
		this.titel = titel;
		this.type = type;
	}
	
	public String toString() {
		return "Titel: " + titel + "\nType: " + type;
	}
	
}
