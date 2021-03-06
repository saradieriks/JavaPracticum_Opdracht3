package domain;

public class Spel extends Item implements IItem{

	public Spel(String titel, char type, int id) {
		super(titel, type, id);
		this.setAankoopPrijs(20);
		// TODO Auto-generated constructor stub
	}
	
	public Spel(String titel, char type) {
		super(titel, type);
		this.setAankoopPrijs(20);
	}

	/**
	 * Geeft de prijs terug van het artikel. 
	 * De integer aantalDagen moet het aantal dagen 
	 * teruggeven dat het artikel is gehuurd.
	 * <p>
	 * In dit geval zal de prijs worden berekent op het aantal dagen * huurprijs/dag
	 * @param	aantalDagen	Het aantal dagen dat het artikel is gehuurd
	 * @return				De prijs uitgedrukt in een double
	 * @see					Item
	 */
	@Override
	public double getPrijs(int aantalDagen){
		double prijs = 0;
		
		prijs += (aantalDagen * 3);
		
		return prijs;
	}
	
	
}

