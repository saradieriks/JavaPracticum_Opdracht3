package io;

import io.IOReader;
import io.IOReaderDB;
import io.IOReaderTemplate;
import io.IOWriter;
import io.IOWriterDB;
import io.ExcelHandler;


public class IOAdapter {
	
	private Integer ioKeuze;
	
	public IOAdapter(Integer ioKeuze){
		this.ioKeuze = ioKeuze;
		
		switch(this.ioKeuze){
		
		case 1:
			IOReader reader = new IOReader();
			break;
		case 2:
			break;
		case 3:
			break;
		
		}
		
	}

}
