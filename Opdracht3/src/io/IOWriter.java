package io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import domain.*;

public class IOWriter {
	
	// FILE VERSIE
	
	public IOWriter() {
		
	}
	
	public static boolean writeItem(Item item) throws IOException {
		
		IOReader reader = new IOReader();
		
		char type = item.getType();
		String titel = item.getTitel().replace(' ', '+');
		
		String cat = "undefined";
		if (type == 'M') { cat = "movies"; }
		else if (type == 'G') { cat = "games"; }
		else if (type == 'C') { cat = "cds"; }
		
		BufferedWriter output = null;
		
	    try {
	    	
	    	File file = new File(cat + ".txt");
	        output = new BufferedWriter(new FileWriter(file, true));
	        long aantalItems = reader.getAantalItems(cat);
			String id = type + "" + aantalItems;
			
			String write = id + "=" + titel;
	        if (reader.hasItems(cat)) {
	        	write = "\r\n" + write;
	        }
	        output.write(write);
	        
	        reader.refreshItems();
	        
	    } catch ( IOException e ) {
	    	
	    	e.printStackTrace();
	    	
	    } finally {
	    	
	    	if ( output != null ) output.close();
	    	
	    }
	    
	    return true;
	    
	}
	
	public static boolean writeKlant(Klant klant) throws IOException {
		
		IOReader reader = new IOReader();
		
		BufferedWriter output = null;
		
	    try {
	    	
	    	File file = new File("klant.txt");
	        output = new BufferedWriter(new FileWriter(file, true));
	        long aantalItems = reader.getAantalKlanten();
			long id = aantalItems;
			
			String write = id + "=" + klant.getVoornaam() + ";" + klant.getNaam() + ";" + klant.getAdres().getStraat() + ";" + klant.getAdres().getNummer() +
					";" + klant.getAdres().getBox() + ";" + klant.getAdres().getPostcode() + ";" + klant.getAdres().getGemeente() + ";" 
					+ klant.getAdres().getLand() + ";" + klant.getEmail();
	        if (reader.hasItems("klant")) {
	        	write = "\r\n" + write;
	        }
	        output.write(write);
	        
	        reader.refreshKlanten();
	        
	    } catch ( IOException e ) {
	    	
	    	e.printStackTrace();
	    	
	    } finally {
	    	
	    	if ( output != null ) output.close();
	    	
	    }
	    
	    return true;
	    
	}
	
	public static boolean writeReservatie(Reservatie reservatie) throws IOException {
		IOReader reader = new IOReader();
		
		Double prijs = reservatie.getPrijs();
		Datum startDatum = reservatie.getStartDatum();
		Item item = reservatie.getItem();
		int aantalDagen = reservatie.getAatalDagen();
		Double boete = reservatie.getBoete();
		Boolean betaald = reservatie.getBetaald();
		int klantID = reservatie.klantID();
		
		BufferedWriter output = null;
		
	    try {
	    	
	    	File file = new File("reservaties.txt");
	        output = new BufferedWriter(new FileWriter(file, true));
	        long aantalItems = reader.getAantalItems("reservaties");
			
			String write = 
					aantalItems +
					"=Klant:" + klantID + 
					";Item:" + item.getID() +
					";Prijs:" + prijs.toString() +
					";StartDatum:" + startDatum.toString() + 
					";AantalDagen:" + Integer.toString(aantalDagen) +
					";Boete:" + boete.toString() +
					";betaald:" + betaald.toString()
					;
	        if (reader.hasItems("reservaties")) {
	        	write = "\r\n" + write;
	        }
	        output.write(write);
	        
	        reader.refreshItems();
	        
	    } catch ( IOException e ) {
	    	
	    	e.printStackTrace();
	    	
	    } finally {
	    	
	    	if ( output != null ) output.close();
	    	
	    }
	    
	    return true;
	}
	
	/*public static void main(String [] args) throws IOException {
		Item item = new Item("Eerste product", 'G', 5);
		IOWriter writer = new IOWriter();
		writer.writeItem(item);
	}*/
	
}
