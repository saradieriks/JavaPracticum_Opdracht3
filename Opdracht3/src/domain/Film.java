package domain;

public class Film extends Item implements IItem{

	public Film(String titel, char type, int id) {
		super(titel, type, id);
		// TODO Auto-generated constructor stub
	}
	
	public Film(String titel, char type) {
		super(titel, type);
	}

	/**
	 * Geeft de prijs terug van het artikel. 
	 * De integer aantalDagen moet het aantal dagen 
	 * teruggeven dat het artikel is gehuurd.
	 * <p>
	 * In dit geval zal de prijs worden berekent op het aantal dagen * huurprijs/dag.
	 * De eerste 3 dagen zijn gratis.
	 * @param	aantalDagen	Het aantal dagen dat het artikel is gehuurd
	 * @return				De prijs uitgedrukt in een double
	 * @see					Item
	 */
	
	public double getPrijs(int aantalDagen){
		double prijs = 5;
		
		int dagenOver = aantalDagen - 3;
		if (dagenOver > 0) {
			prijs += (dagenOver * 2);
			}
		return prijs;
	}
}
	


