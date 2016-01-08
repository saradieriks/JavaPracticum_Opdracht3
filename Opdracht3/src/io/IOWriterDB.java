package io;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import domain.*;

public class IOWriterDB {
	
	static String db = "jdbc:derby:db;create=true";
	static Connection con = null;
	static Statement st = null;
	static ResultSet rs = null;
	static String sql = null;
	static DatabaseMetaData dbmd = null;

	public IOWriterDB() throws SQLException {
		// Als tabellen niet bestaan, aanmaken
				DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
		        con = DriverManager.getConnection(db);
		        st = (Statement) con.createStatement();
		        dbmd = con.getMetaData();
		        rs = dbmd.getTables(null, null, "FILMS", null);
		        if (!rs.next()) {
			        sql = "CREATE TABLE FILMS ("
			        		+ "id INTEGER not NULL GENERATED ALWAYS AS IDENTITY, "
			        		+ "titel VARCHAR(255), "
			        		+ "type VARCHAR(1), "
			        		+ "PRIMARY KEY ( id ))";
			        st.executeUpdate(sql);
		        }
		        dbmd = con.getMetaData();
		        rs = dbmd.getTables(null, null, "SPELLEN", null);
		        if (!rs.next()) {
			        sql = "CREATE TABLE SPELLEN ("
			        		+ "id INTEGER not NULL GENERATED ALWAYS AS IDENTITY, "
			        		+ "titel VARCHAR(255), "
			        		+ "type VARCHAR(1), "
			        		+ "PRIMARY KEY ( id ))";
			        st.executeUpdate(sql);
		        }
		        dbmd = con.getMetaData();
		        rs = dbmd.getTables(null, null, "CDS", null);
		        if (!rs.next()) {
			        sql = "CREATE TABLE CDS ("
			        		+ "id INTEGER not NULL GENERATED ALWAYS AS IDENTITY, "
			        		+ "titel VARCHAR(255), "
			        		+ "type VARCHAR(1), "
			        		+ "PRIMARY KEY ( id ))";
			        st.executeUpdate(sql);
		        }
		        dbmd = con.getMetaData();
		        rs = dbmd.getTables(null, null, "KLANTEN", null);
		        if (!rs.next()) {
			        sql = "CREATE TABLE KLANTEN ("
			        		+ "id INTEGER not NULL GENERATED ALWAYS AS IDENTITY, "
			        		+ "naam VARCHAR(255), "
			        		+ "voornaam VARCHAR(255), "
			        		+ "adres VARCHAR(255), "
			        		+ "email VARCHAR(255), "
			        		+ "PRIMARY KEY ( id ))";
			        st.executeUpdate(sql);
		        }
		        dbmd = con.getMetaData();
		        rs = dbmd.getTables(null, null, "RESERVATIES", null);
		        if (!rs.next()) {
			        sql = "CREATE TABLE RESERVATIES ("
			        		+ "id INTEGER not NULL GENERATED ALWAYS AS IDENTITY, "
			        		+ "klantID INTEGER, "
			        		+ "itemID VARCHAR(10), "
			        		+ "aantaldagen INTEGER, "
			        		+ "prijs DOUBLE, "
			        		+ "startdatum VARCHAR(255), "
			        		+ "boete DOUBLE, "
			        		+ "betaald INTEGER, "
			        		+ "PRIMARY KEY ( id ))";
			        st.executeUpdate(sql);
		        }
		        con.close();
	}
	
	public static boolean writeItem(Item item) throws SQLException {
		IOWriterDB writer = new IOWriterDB();
		char type = item.getType();
		String titel = item.getTitel();
		DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
        con = DriverManager.getConnection(db);
        st = con.createStatement();
		switch (type) {
			case 'M':
				sql = "INSERT INTO FILMS " +
	        			"(titel, type)" +
	        			"VALUES('"+titel+"', '"+type+"')";
				break;
			case 'G':
				sql = "INSERT INTO SPELLEN " +
	        			"(titel, type)" +
	        			"VALUES('"+titel+"', '"+type+"')";
				break;
			case 'C':
				sql = "INSERT INTO CDS " +
	        			"(titel, type)" +
	        			"VALUES('"+titel+"', '"+type+"')";
				break;
		}
		st.executeUpdate(sql);
		IOReaderDB.refreshItems();
		con.close();
		return true;
	}
	
	public static boolean writeKlant(Klant klant) throws SQLException {
		IOWriterDB writer = new IOWriterDB();
		String naam = klant.getNaam();
		String voornaam = klant.getVoornaam();
		String adres = klant.getAdres().getStraat() + ";"
				+ klant.getAdres().getNummer() + ";"
				+ klant.getAdres().getBox() + ";" 
				+ klant.getAdres().getPostcode() + ";"
				+ klant.getAdres().getGemeente() + ";"
				+ klant.getAdres().getLand();
		String email = klant.getEmail();
		DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
        con = DriverManager.getConnection(db);
        st = con.createStatement();
        sql = "INSERT INTO KLANTEN " +
    			"(naam, voornaam, adres, email)" +
    			"VALUES('"+naam+"', '"+voornaam+"', '"+adres+"', '"+email+"')";
        st.executeUpdate(sql);
		IOReaderDB.refreshKlanten();
		con.close();
		return true;
	}

	public static boolean writeReservatie(Reservatie reservatie) throws SQLException {
		IOWriterDB writer = new IOWriterDB();
		Double prijs = reservatie.getPrijs();
		Datum startDatum = reservatie.getStartDatum();
		Item item = reservatie.getItem();
		int aantalDagen = reservatie.getAatalDagen();
		Double boete = reservatie.getBoete();
		Boolean betaald = reservatie.getBetaald();
		int klantID = reservatie.klantID();
		int bet = 0;
		if (betaald) bet = 1;
		DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
        con = DriverManager.getConnection(db);
        st = con.createStatement();
        sql = "INSERT INTO RESERVATIES " +
    			"(klantID, itemID, aantalDagen, prijs, startdatum, boete, betaald)" +
    			"VALUES("+klantID+", '"+item.getType() + item.getID()+"', "+aantalDagen+", "+prijs+", '"+startDatum+"', "+boete+", "+bet+")";
        st.executeUpdate(sql);
		IOReaderDB.refreshReservaties();
		con.close();
		return true;
	}
	
	//public static void main(String [] args) throws SQLException {
		//IOWriterDB writer = new IOWriterDB();
		/*
		DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
        con = DriverManager.getConnection(db);
        st = con.createStatement();
        sql = "DROP TABLE RESERVATIES";
        st.executeUpdate(sql);
		con.close();
		*/
		
		//Item item = new Item("Dit is nog een ander spel", 'G');
		//writeItem(item);
		
		/*
		Adres adres = new Adres("Straat", "1", "b", "3000", "Leuven", "België");
		Klant klant = new Klant("Peter", "Peters", adres, "jan@peters.be");
		writeKlant(klant);
		*/
		/*
		Datum datum = new Datum(8,1,2016);
		Reservatie reservatie = new Reservatie(20.7, datum, item, 7, 30.2, false, 3);
		writeReservatie(reservatie);
		*/
		/*
		Iterator<Entry<String, String>> iteratorReservaties = IOReaderDB.getReservaties().entrySet().iterator() ;
        while(iteratorReservaties.hasNext()){
            Entry<String, String> test = iteratorReservaties.next();
            System.out.println(test.getKey() +" :: "+ test.getValue());
        }
		Iterator<Entry<Integer, String>> iteratorKlanten = IOReaderDB.getKlanten().entrySet().iterator() ;
        while(iteratorKlanten.hasNext()){
            Entry<Integer, String> test = iteratorKlanten.next();
            System.out.println(test.getKey() +" :: "+ test.getValue());
        }
		Iterator<HashMap.Entry<String, String>> iteratorMovies = IOReaderDB.getMovies().entrySet().iterator() ;
        while(iteratorMovies.hasNext()){
            HashMap.Entry<String, String> test = iteratorMovies.next();
            System.out.println(test.getKey() +" :: "+ test.getValue());
        }
        */
		/*
        Iterator<HashMap.Entry<String, String>> iteratorGames = IOReaderDB.getGames().entrySet().iterator() ;
        while(iteratorGames.hasNext()){
            HashMap.Entry<String, String> test = iteratorGames.next();
            System.out.println(test.getKey() +" :: "+ test.getValue());
        }
        */
	//}
	
	
}
