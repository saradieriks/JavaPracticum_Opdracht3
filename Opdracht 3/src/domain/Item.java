package domain;

public abstract class Item {
	
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
	public char getID() {
		return (char) id;
	}
	public void setID(int id) {
		this.id = id;
	}
	
	public Item (String titel, char type, int id) {
		this.titel = titel;
		this.type = type;
		this.id = id;
	}
	
	public String toString() {
		return "Titel: " + titel + "\nType: " + type + "\nID: " + id;
	}
	
}
