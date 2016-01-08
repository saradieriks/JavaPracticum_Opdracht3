package io;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;


public class IOReaderDB {
	
	static String db = "jdbc:derby:db;create=true";
	static Connection con = null;
	static Statement st = null;
	static ResultSet rs = null;
	static String sql = null;
	static DatabaseMetaData dbmd = null;
	private static HashMap<String,String> movies;
	private static HashMap<String,String> games;
	private static HashMap<String,String> cds;
	private static HashMap<String,String> reservaties;
	private static HashMap<Integer,String> klanten;

	public IOReaderDB() throws SQLException {
	}
	
	public static Boolean refreshItems() throws SQLException {
		DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
        con = DriverManager.getConnection(db);
        movies = new HashMap<String, String>();
		st = con.createStatement();
        sql = "SELECT id, titel, type FROM FILMS";       
        rs = st.executeQuery(sql);   
        while(rs.next()) {
        	String id = rs.getString("type") + rs.getInt("id");
        	String titel = rs.getString("titel");
        	movies.put(id, titel);
        }
        games = new HashMap<String, String>();
        st = con.createStatement();
        sql = "SELECT id, titel, type FROM SPELLEN";       
        rs = st.executeQuery(sql);   
        while(rs.next()) {
        	String id = rs.getString("type") + rs.getInt("id");
        	String titel = rs.getString("titel");
        	games.put(id, titel);
        }
        cds = new HashMap<String, String>();
        st = con.createStatement();
        sql = "SELECT id, titel, type FROM CDS";       
        rs = st.executeQuery(sql);   
        while(rs.next()) {
        	String id = rs.getString("type") + rs.getInt("id");
        	String titel = rs.getString("titel");
        	cds.put(id, titel);
        }
        con.close();
		return true;
	}
	//0;Klant:1;Item:;Prijs:20.5;StartDatum:21 september 2015;AantalDagen:2;Boete:30.5;betaald:false
	public static Boolean refreshReservaties() throws SQLException {
		DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
        con = DriverManager.getConnection(db);
        reservaties = new HashMap<String, String>();
		st = con.createStatement();
        sql = "SELECT * FROM RESERVATIES";       
        rs = st.executeQuery(sql);   
        while(rs.next()) {
        	int id = rs.getInt("id");
        	int klantID = rs.getInt("klantID");
        	String itemID = rs.getString("itemID");
        	int aantalDagen = rs.getInt("aantaldagen");
        	double prijs = rs.getDouble("prijs");
        	String startDatum = rs.getString("startdatum");
        	double boete = rs.getDouble("boete");
        	int betaald = rs.getInt("betaald");
        	boolean bet = false;
        	if (betaald == 1) {bet = true;}
        	reservaties.put(id+"", "Klant:"+klantID+";Item:"+itemID+";Prijs:"+prijs+";StartDatum:"+startDatum+";AantalDagen:"+aantalDagen+";Boete:"+boete+";betaald:"+bet);
        }
        con.close();
        return true;
	}
	//0=Bart;Jaspers;Steegje;1;1;3000;Leuven;belgie;bartje@gmail.com
	public static Boolean refreshKlanten() throws SQLException {
		DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
        con = DriverManager.getConnection(db);
        klanten = new HashMap<Integer, String>();
		st = con.createStatement();
        sql = "SELECT * FROM KLANTEN";       
        rs = st.executeQuery(sql);   
        while(rs.next()) {
        	int id = rs.getInt("id");
        	String naam = rs.getString("naam");
        	String voornaam = rs.getString("voornaam");
        	String adres = rs.getString("adres");
        	String email = rs.getString("email");
        	klanten.put(id, voornaam+";"+naam+";"+adres+";"+email);
        }
        con.close();
        return true;
	}
	
	public static HashMap<String,String> getMovies() {
		//movies = new HashMap<String,String>();
		try {
			refreshItems();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return movies;
	}
	
	public static HashMap<String,String> getGames() {
		try {
			refreshItems();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return games;
	}
	
	public static HashMap<String,String> getCDs() {
		try {
			refreshItems();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cds;
	}
	
	public static HashMap<String,String> getReservaties() {
		try {
			refreshReservaties();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reservaties;
	}
	
	public static HashMap<Integer,String> getKlanten() {
		try {
			refreshKlanten();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return klanten;
	}
	
	//public static void main(String [] args) throws SQLException {
		/*IOReaderDB reader = new IOReaderDB();
		DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
        con = DriverManager.getConnection(db);
        /*st = con.createStatement();
        
        sql = "INSERT INTO FILMS " +
        			"(titel, type)" +
        			"VALUES('Dit is een derde film', 'M')";
        
        st.executeUpdate(sql);*/
        /*
        st = con.createStatement();
        
        sql = "SELECT id, titel, type FROM FILMS";
        
        rs = st.executeQuery(sql);
        
        while(rs.next()) {
        	int id = rs.getInt("id");
        	String titel = rs.getString("titel");
        	String type = rs.getString("type");
        	
        	System.out.println("ID: " + type + id + " .. Titel: " + titel);
        	
        }
        
        con.close();
        */
	//}
	
}
