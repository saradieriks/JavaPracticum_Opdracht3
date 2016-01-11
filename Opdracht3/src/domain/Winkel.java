package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
* De Winkel klasse is de facade klasse van het domein
*
*/


public class Winkel {
	

	public double getPrijs(Item item, int aantalDagen)
	{
		return item.getPrijs(aantalDagen);
	}
	
	public Cd getCd(String titel, int id)
	{
		Cd CD = new Cd(titel,'C', id);
		return CD;

	}
	
	public Cd getCd(String titel)
	{
		Cd CD = new Cd(titel, 'C');
		return CD;
	}
	
	public Film getFilm(String titel, int id)
	{
		Film FILM = new Film(titel,'C', id);
		return FILM;

	}
	
	public Film getFilm(String titel)
	{
		Film FILM = new Film(titel, 'C');
		return FILM;
	}
	
	public Spel getSpel(String titel, int id)
	{
		Spel SPEL = new Spel(titel,'S', id);
		return SPEL;

	}
	
	public Spel getSpel(String titel)
	{
		Spel SPEL = new Spel(titel, 'S');
		return SPEL;
	}
	
	public Adres getAdres(String straat, String nummer, String box, String postcode,
			  String gemeente, String land)
	{
		Adres ADRES = new Adres (straat,nummer,box,postcode,
				  gemeente, land);
		return ADRES;
	}
	
	public Adres getAdres(String straat, String nummer, String postcode,
			  String gemeente, String land)
	{
		Adres ADRES = new Adres (straat,nummer,postcode,
				  gemeente, land);
		return ADRES;
	}
	
	public Adres getAdres(String straat, String nummer, String postcode,
			  String gemeente)
	{
		Adres ADRES = new Adres(straat,nummer,postcode,
				  gemeente);
		return ADRES;
				
	}
	
	public Reservatie getReservatie (Double prijs, Datum startDatum, 
			Item item, int aantalDagen, Double boete, Boolean betaald, int klantID)
	{
		Reservatie RESERVATIE = new Reservatie (prijs,startDatum, 
				item,aantalDagen,boete, betaald, klantID);
		return RESERVATIE;
	}
	
	public Reservatie getReservatie(Double prijs, Datum startDatum, 
			Item item, int aantalDagen, Double boete, Boolean betaald)
	{
		Reservatie RESERVATIE = new Reservatie(prijs,startDatum, 
				item, aantalDagen,boete, betaald);
		return RESERVATIE;
	}
	
	public Reservatie getReservatie(Double prijs, Datum startDatum, Item item, 
			int aantalDagen, int klantID)
	{
		Reservatie RESERVATIE = new Reservatie(prijs, startDatum,item, 
				aantalDagen, klantID);
		return RESERVATIE;
	}
	
	public Reservatie getReservatie(Double prijs, Datum startDatum, 
			Item item, int aantalDagen, Double boete, int klantID)
	{
		Reservatie RESERVATIE = new Reservatie(prijs,startDatum, 
				item,aantalDagen,boete, klantID);
		return RESERVATIE;
	}
	
	public Reservatie getReservatie(Item item, int aantalDagen, int klantID)
	{
		Reservatie RESERVATIE = new Reservatie(item,aantalDagen,klantID);
		return RESERVATIE;
	}
	
	public Klant getKlant (int klantID, String naam, String voornaam, Adres adres,
			  String email)
	{
		Klant KLANT = new Klant(klantID,naam,voornaam,adres,
				   email);
		return KLANT;
				
		
	}
	
	public Klant getKlant(String naam, String voornaam, Adres adres, String email)
	{
		Klant KLANT = new Klant (naam,voornaam,adres,email);
		return KLANT;
				
		
	}
	
	public Klant getKlant(int klantID, String naam, String voornaam, Adres adres)
	{
		Klant KLANT = new Klant(klantID,naam,voornaam,adres);
		return KLANT;
		
	}
	
	public Klant getKlant(String naam, String voornaam, Adres adres)
	{
		Klant KLANT = new Klant(naam,voornaam,adres);
		return KLANT;
		
	}




}
