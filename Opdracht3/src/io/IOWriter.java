package io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import domain.Item;

public class IOWriter {
	
	// FILE VERSIE
	
	public IOWriter() {
		
	}
	
	public boolean writeItem(Item item) throws IOException {
		
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
	
	public boolean writeReservatie() {
		return true;
	}
	
	/*public static void main(String [] args) throws IOException {
	}*/
	
}
