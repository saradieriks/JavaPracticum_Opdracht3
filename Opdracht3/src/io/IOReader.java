package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import domain.Klant;

public class IOReader {
	
	private HashMap<String,String> movies;
	private HashMap<String,String> games;
	private HashMap<String,String> cds;
	private HashMap<String,String> reservaties;
	private HashMap<Integer,String> klanten;
	
	// FILE VERSIE
	
	public IOReader() {
		
	}
	
	public Boolean refreshItems() throws IOException {
		movies = new HashMap<String, String>();
        String regel;
        @SuppressWarnings("resource")
		BufferedReader readerMovies = new BufferedReader(new FileReader("movies.txt"));
        while ((regel = readerMovies.readLine()) != null)
        {
            String[] splits = regel.split("=");
            String id = splits[0];
            String titel = splits[1];
            movies.put(id, titel);
        }
        games = new HashMap<String, String>();
        @SuppressWarnings("resource")
		BufferedReader readerGames = new BufferedReader(new FileReader("games.txt"));
        while ((regel = readerGames.readLine()) != null)
        {
            String[] splits = regel.split("=");
            String id = splits[0];
            String titel = splits[1];
            games.put(id, titel);
        }
        cds = new HashMap<String, String>();
        @SuppressWarnings("resource")
		BufferedReader readerCds = new BufferedReader(new FileReader("cds.txt"));
        while ((regel = readerCds.readLine()) != null)
        {
            String[] splits = regel.split("=");
            String id = splits[0];
            String titel = splits[1];
            cds.put(id, titel);
        }
		return true;
	}
	//0;Klant:1;Item:;Prijs:20.5;StartDatum:21 september 2015;AantalDagen:2;Boete:30.5;betaald:false
	public Boolean refreshReservaties() throws IOException {
		reservaties = new HashMap<String, String>();
		String regel;
        @SuppressWarnings("resource")
		BufferedReader readerReservaties = new BufferedReader(new FileReader("reservaties.txt"));
        while ((regel = readerReservaties.readLine()) != null)
        {
            String[] splits = regel.split("=");
            String id = splits[0];
            String reservatie = splits[1];
            /*
            String klant = splits[1];
            String item = splits[2];
            String prijs = splits[3];
            String startDatum = splits[4];
            String aantalDagen = splits[5];
            String boete = splits[6];
            String betaald = splits[7];*/
            reservaties.put(id, reservatie);
        }
		return true;
	}
	
	//0=Bart;Jaspers;Steegje;1;1;3000;Leuven;belgie;bartje@gmail.com
	public Boolean refreshKlanten() throws IOException {
		klanten = new HashMap<Integer, String>();
		String regel;
	    @SuppressWarnings("resource")
		BufferedReader readerKlanten = new BufferedReader(new FileReader("klant.txt"));
	    while ((regel = readerKlanten.readLine()) != null)
	    {
	        String[] splits = regel.split("=");
	        Integer id = Integer.parseInt(splits[0]);
	        String klant = splits[1];
	        klanten.put(id, klant);
	    }
		return true;
	}
	
	@SuppressWarnings("resource")
	public Boolean hasItems(String cat) {
		BufferedReader input = null;
		try {
            String file = cat + ".txt";
            input = new BufferedReader(new FileReader(file));
    		if (input.readLine() != null) {
    		    return true;
    		}
        } catch ( IOException e ) {
            e.printStackTrace();
        }
		return false;
	}
	
	public long getAantalItems(String cat) throws IOException {
		List<String> regels = Files.newBufferedReader(
								Paths.get(cat + ".txt")).lines().collect(Collectors.toList()
							  );
		long aantal = regels.size();
		return aantal;
	}
	
	@SuppressWarnings("resource")
	public Boolean hasReservaties() {
		BufferedReader input = null;
		try {
            String file = "reservaties.txt";
            input = new BufferedReader(new FileReader(file));
    		if (input.readLine() != null) {
    		    return true;
    		}
        } catch ( IOException e ) {
            e.printStackTrace();
        }
		return false;
	}
	
	public HashMap<String,String> getMovies() {
		return movies;
	}
	
	public HashMap<String,String> getGames() {
		return games;
	}
	
	public HashMap<String,String> getCDs() {
		return cds;
	}
	
	public HashMap<String,String> getReservaties() {
		return reservaties;
	}

	public long getAantalKlanten() throws IOException {
		List<String> regels = Files.newBufferedReader(
				Paths.get("klant.txt")).lines().collect(Collectors.toList()
			  );
		long aantal = regels.size();
		return aantal;
	}
	
	//public static void main(String [] args) throws IOException {
	//}

}
