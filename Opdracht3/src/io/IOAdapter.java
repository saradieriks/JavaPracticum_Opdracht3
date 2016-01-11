package io;

import io.IOReader;
import io.IOReaderDB;
import io.IOReaderTemplate;
import io.IOWriter;
import io.IOWriterDB;

import java.io.IOException;
import java.util.HashMap;

import domain.Item;
import domain.Klant;
import domain.Reservatie;
import io.ExcelHandler;


public class IOAdapter {
	
	
	//Failed returns van de HashMaps
	private static HashMap<String,String> failedReturn = null;
	private static HashMap<Integer,String> failedReturnKlanten = null;

	
	private Integer ioKeuze;
	/* ioKeuze is een keuze voor de gebruiker om te kiezen welke io hij gaat gebruiken.
	 * 0 = nog geen io gekozen, de gebruiker krijgt een pop-up om de db te kiezen.
	 * 1 = txt file
	 * 2 = DB
	 * 3 = Excel file
	 * */
	
	public IOAdapter(Integer ioKeuze){
		this.ioKeuze = ioKeuze;
				
	}
	
	public boolean writeItem(Item item){
		try{
			switch(ioKeuze){
		
			case 1:
				return IOWriter.writeItem(item);
			case 2:
				return IOWriterDB.writeItem(item);
			case 3:
				return true;
			}
		}
		catch (IOException e) {
			return false;
		}
		catch (Exception e) {
			return false;
		}
		return false;
	}
	
	public boolean writeKlant(Klant klant){
		try{
			switch(this.ioKeuze){
			case 1:
				return IOWriter.writeKlant(klant);
			case 2:
				return IOWriterDB.writeKlant(klant);
			case 3:
				break;
			} 
		}
		catch (IOException e) {
			return false;
		}
		catch (Exception e) {
			return false;
		}
		return false;
	}
	
	public boolean writeReservatie(Reservatie reservatie){
		try{
			switch(this.ioKeuze){
			case 1:
				return IOWriter.writeReservatie(reservatie);
			case 2:
				return IOWriterDB.writeReservatie(reservatie);
			case 3:
				break;
			}
		}
		catch (IOException e) {
			return false;
		}
		catch (Exception e) {
			return false;
		}
		return false;
	}
	
	public HashMap<String,String> getMovies(){

			switch(this.ioKeuze){
			case 1:
				return IOReader.getMovies();
			case 2:
				return IOReaderDB.getMovies();
			case 3:
				break;
			}
			return failedReturn;
	}
	public HashMap<String,String> getGames(){

		switch(this.ioKeuze){
		case 1:
			return IOReader.getGames();
		case 2:
			return IOReaderDB.getGames();
		case 3:
			break;
		}
		return failedReturn;
	}
	public HashMap<String,String> getCDs(){

		switch(this.ioKeuze){
		case 1:
			return IOReader.getCDs();
		case 2:
			return IOReaderDB.getCDs();
		case 3:
			break;
		}
		return failedReturn;
	}
	public HashMap<String,String> getReservaties(){

		switch(this.ioKeuze){
		case 1:
			return IOReader.getReservaties();
		case 2:
			return IOReaderDB.getReservaties();
		case 3:
			break;
		}
		return failedReturn;
	}
	public HashMap<Integer,String> getKlanten(){

		switch(this.ioKeuze){
		case 1:
			return IOReader.getKlanten();
		case 2:
			return IOReaderDB.getKlanten();
		case 3:
			break;
		}
		return failedReturnKlanten;
	}



}
