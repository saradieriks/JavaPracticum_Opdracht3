package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public abstract class IOReaderTemplate {
	
	public long getAantal(String path) throws IOException {
		List<String> regels = Files.newBufferedReader(
				Paths.get(path)).lines().collect(Collectors.toList()
			  );
		long aantal = regels.size();
		return aantal;
	}
	
	public static void refreshIets(HashMap<String,String> map, File ffile, String naam) throws FileNotFoundException{
		String regel;
		if(ffile.exists() && !ffile.isDirectory()) { 
			BufferedReader readerIets = new BufferedReader(new FileReader(naam));
	        try {
				while ((regel = readerIets.readLine()) != null)
				{
				    String[] splits = regel.split("=");
				    String id = splits[0];
				    String titel = splits[1];
				    map.put(id, titel);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	}
}

