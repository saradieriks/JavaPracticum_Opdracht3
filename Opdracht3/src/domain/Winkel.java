package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
* De Winkel klasse is de facade klasse
* 
* WORK IN PROGRESS :-)
*
*/


public class Winkel {
	
	//prijs van een item zonder te weten welk type
	public double getPrijs(Item item, int aantalDagen)
	{
		if (item.getClass().getName() == "Cd")
		{
			return ((Cd) item).getPrijs(aantalDagen);
		}
		
		if (item.getClass().getName() == "Film")
		{
			return ((Film) item).getPrijs(aantalDagen);
		}
		return 0;
	}
	
	
	// Deze methode moet nog verder afgewerkt worden
	public Boolean maakNieuweReservatie(String id, int klantID, int aantalDagen) {
		/*
		 * Deze maakt een nieuwe reservatie aan en zal indien positief dan ook
		 * een refresh doen van de reservaties via de ioReader
		 */
		return true;
	}
	
	// Deze methode moet nog verder afgewerkt worden
	public Double brengTerug(List<Item> lijst) {
		/*
		 * Deze functie bepaalt het totaal te betalen bedrag en de boeten. 
		 * Concreet past deze functie de objecten aan en vult overal het bedrag 
		 * en de boete in.
		 */
		return 0D; 
	}
	
	// Deze methode moet nog afgewerkt worden
	public String geefAlleItems() {
		/*
		 * Dit geeft een geformateerde lijst voor consoledisplay terug.
		 * opgave punt 4
		 */
		return "";
	}
	
	// Deze methode moet nog afgewerkt worden
	public String zoekItems(String woord, String type) {
		/*
		 * Geeft geformateerde lijst van alle items met dit woord in de titel 
		 * van dat type. Het type moet meegegeven worden als "movie" of "game".
		 */
		return "";
	}
	
	

}
