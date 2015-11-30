package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import domain.Item;
import domain.Reservatie;
import ui.WinkelPanel;

public class WinkelController extends JFrame {

	private static Map <String,List<Item>> Items = new HashMap<>();
	private static Map <String,List<Reservatie>> Reservaties = new HashMap<>();

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
