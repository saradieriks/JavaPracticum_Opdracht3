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
	
	//prijs van een item zonder te weten welk type - dit gaat er nog vanuit dat 
	//casten nodig is hiervoor
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
		
		if (item.getClass().getName() == "Spel")
		{
			return ((Spel) item).getPrijs(aantalDagen);
		}
		return 0;

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

	
	

	
	

}
