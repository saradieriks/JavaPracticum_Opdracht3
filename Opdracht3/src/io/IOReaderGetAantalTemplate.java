package io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public abstract class IOReaderGetAantalTemplate {
	
	public long getAantal(String path) throws IOException {
		List<String> regels = Files.newBufferedReader(
				Paths.get(path)).lines().collect(Collectors.toList()
			  );
		long aantal = regels.size();
		return aantal;
	}

}
