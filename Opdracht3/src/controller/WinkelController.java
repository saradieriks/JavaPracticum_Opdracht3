package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import domain.Item;
import domain.Observer;
import domain.Reservatie;
import domain.Subject;
import ui.WinkelPanel;

public class WinkelController extends JFrame implements Subject {

	public static Map <String,List<Item>> Items = new HashMap<>();
	private static Map <String,List<Reservatie>> Reservaties = new HashMap<>();
	private static List<Observer>observers = new ArrayList<Observer>();
	
	/*
	 * De list observers moet alle klanten bevatten met IsObserver == true
	 * klanten die at runtime observer worden, worden toegevoegd via de methode binnen klant
	 * maakKlantObserver
	 * Wanneer een nieuw item wordt toegevoegd moet de methode
	 * notifyObservers(item) uitgevoerd worden.
	 */
	
	//observer methods
	public void addObserver(Observer o) {
		observers.add(o);	
	}
	public void removeObserver(Observer o) {
		observers.add(o);
	}
	private void notifyObservers(Item item) {
		Iterator i = observers.iterator();
		while (i.hasNext() ) {
			Observer o = (Observer) i.next();
			o.update(this, item);
		}
	}

    public WinkelController() {
        WinkelPanel paneel = new WinkelPanel();
        paneel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        paneel.setVisible(true);
        paneel.show();
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
