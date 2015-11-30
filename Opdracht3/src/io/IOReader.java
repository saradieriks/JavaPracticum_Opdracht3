package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class IOReader {
	
	private HashMap<String,String> movies;
	private HashMap<String,String> games;
	private HashMap<String,String> cds;
	
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

	public Boolean refreshReservaties() {
		/*reservaties = new HashMap<String, String>();
		String regel;
        @SuppressWarnings("resource")
		BufferedReader readerCds = new BufferedReader(new FileReader("reservaties.txt"));
        while ((regel = readerCds.readLine()) != null)
        {
            String[] splits = regel.split("=");
            String id = splits[0];
            String titel = splits[1];
            reservaties.put(id, titel);
        }*/
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
	
	public Boolean hasReservaties() {
		return true;
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
	
	//public static void main(String [] args) throws IOException {
	//}

}
