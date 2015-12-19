package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import domain.Adres;
import domain.Datum;
import domain.Item;
import domain.Klant;
import domain.Reservatie;

public class KlantTest {
	private Adres adres, adresGelijk, adresNietGelijk;
	private Klant klant, klantGelijk, klantNietGelijk;
	
	@Before
	public void SetUp()throws Exception {
		adres = new Adres("Leuvensebaan", "351", "b", "3000", "Leuven", "België");
		adresGelijk = new Adres("Leuvensebaan", "28", "3000", "Leuven", "België");
		adresNietGelijk = new Adres("Brusselsebaan", "128", "c", "100", "Brussel", "Frankrijk");
		klant = new Klant(1, "World", "Hello", adres, "hello.world@world.com");
		klantGelijk = new Klant(1, "World", "Hello", adres, "hello.world@world.com");
		klantNietGelijk = new Klant(2, "Sun", "By", adresNietGelijk, "by.sun@sun.com");
	}
		
	@Test
	public void test_Klant_Met_5_Parameters_Wordt_Aangemaakt() {
		Klant nieuweKlant = new Klant(1, "World", "Hello", adres, "hello.world@world.com");
		Adres nieuwAdres = new Adres("Leuvensebaan", "351", "b", "3000", "Leuven", "België");
		
		assertEquals(1, nieuweKlant.getKlantID());
		assertEquals("World", nieuweKlant.getNaam());
		assertEquals("Hello", nieuweKlant.getVoornaam());
		assertEquals(nieuwAdres.getStraat(), nieuweKlant.getAdres().getStraat());
		assertEquals(nieuwAdres.getNummer(), nieuweKlant.getAdres().getNummer());
		assertEquals(nieuwAdres.getBox(), nieuweKlant.getAdres().getBox());
		assertEquals(nieuwAdres.getPostcode(), nieuweKlant.getAdres().getPostcode());
		assertEquals(nieuwAdres.getGemeente(), nieuweKlant.getAdres().getGemeente());
		assertEquals(nieuwAdres.getLand(), nieuweKlant.getAdres().getLand());
		assertEquals("hello.world@world.com", nieuweKlant.getEmail());
		assertEquals(nieuweKlant.getKlantID(), 1);
		assertEquals(nieuweKlant.getNaam(), "World");
		assertEquals(nieuweKlant.getVoornaam(), "Hello");
		assertEquals(nieuweKlant.getAdres().getStraat(), nieuwAdres.getStraat());
		assertEquals(nieuweKlant.getAdres().getNummer(), nieuwAdres.getNummer());
		assertEquals(nieuweKlant.getAdres().getBox(), nieuwAdres.getBox());
		assertEquals(nieuweKlant.getAdres().getPostcode(), nieuwAdres.getPostcode());
		assertEquals(nieuweKlant.getAdres().getGemeente(), nieuwAdres.getGemeente());
		assertEquals(nieuweKlant.getAdres().getLand(), nieuwAdres.getLand());
		assertEquals(nieuweKlant.getEmail(), "hello.world@world.com");
	}
	
	@Test
	public void test_Klant_Met_4_Parameters_Zonder_KlantID_Wordt_Aangemaakt() {
		Klant nieuweKlant = new Klant("World", "Hello", adres, "hello.world@world.com");
		Adres nieuwAdres = new Adres("Leuvensebaan", "351", "b", "3000", "Leuven", "België");
		
		assertEquals("World", nieuweKlant.getNaam());
		assertEquals("Hello", nieuweKlant.getVoornaam());
		assertEquals(nieuwAdres.getStraat(), nieuweKlant.getAdres().getStraat());
		assertEquals(nieuwAdres.getNummer(), nieuweKlant.getAdres().getNummer());
		assertEquals(nieuwAdres.getBox(), nieuweKlant.getAdres().getBox());
		assertEquals(nieuwAdres.getPostcode(), nieuweKlant.getAdres().getPostcode());
		assertEquals(nieuwAdres.getGemeente(), nieuweKlant.getAdres().getGemeente());
		assertEquals(nieuwAdres.getLand(), nieuweKlant.getAdres().getLand());
		assertEquals("hello.world@world.com", nieuweKlant.getEmail());
		assertEquals(nieuweKlant.getNaam(), "World");
		assertEquals(nieuweKlant.getVoornaam(), "Hello");
		assertEquals(nieuweKlant.getAdres().getStraat(), nieuwAdres.getStraat());
		assertEquals(nieuweKlant.getAdres().getNummer(), nieuwAdres.getNummer());
		assertEquals(nieuweKlant.getAdres().getBox(), nieuwAdres.getBox());
		assertEquals(nieuweKlant.getAdres().getPostcode(), nieuwAdres.getPostcode());
		assertEquals(nieuweKlant.getAdres().getGemeente(), nieuwAdres.getGemeente());
		assertEquals(nieuweKlant.getAdres().getLand(), nieuwAdres.getLand());
		assertEquals(nieuweKlant.getEmail(), "hello.world@world.com");
	}
	
	@Test
	public void test_Klant_Met_4_Parameters_Zonder_Email_Wordt_Aangemaakt() {
		Klant nieuweKlant = new Klant(1, "World", "Hello", adres);
		Adres nieuwAdres = new Adres("Leuvensebaan", "351", "b", "3000", "Leuven", "België");
		
		assertEquals(1, nieuweKlant.getKlantID());
		assertEquals("World", nieuweKlant.getNaam());
		assertEquals("Hello", nieuweKlant.getVoornaam());
		assertEquals(nieuwAdres.getStraat(), nieuweKlant.getAdres().getStraat());
		assertEquals(nieuwAdres.getNummer(), nieuweKlant.getAdres().getNummer());
		assertEquals(nieuwAdres.getBox(), nieuweKlant.getAdres().getBox());
		assertEquals(nieuwAdres.getPostcode(), nieuweKlant.getAdres().getPostcode());
		assertEquals(nieuwAdres.getGemeente(), nieuweKlant.getAdres().getGemeente());
		assertEquals(nieuwAdres.getLand(), nieuweKlant.getAdres().getLand());
		assertEquals(nieuweKlant.getKlantID(), 1);
		assertEquals(nieuweKlant.getNaam(), "World");
		assertEquals(nieuweKlant.getVoornaam(), "Hello");
		assertEquals(nieuweKlant.getAdres().getStraat(), nieuwAdres.getStraat());
		assertEquals(nieuweKlant.getAdres().getNummer(), nieuwAdres.getNummer());
		assertEquals(nieuweKlant.getAdres().getBox(), nieuwAdres.getBox());
		assertEquals(nieuweKlant.getAdres().getPostcode(), nieuwAdres.getPostcode());
		assertEquals(nieuweKlant.getAdres().getGemeente(), nieuwAdres.getGemeente());
		assertEquals(nieuweKlant.getAdres().getLand(), nieuwAdres.getLand());
	}
	
	@Test
	public void test_Klant_Met_3_Parameters_Wordt_Aangemaakt() {
		Klant nieuweKlant = new Klant("World", "Hello", adres);
		Adres nieuwAdres = new Adres("Leuvensebaan", "351", "b", "3000", "Leuven", "België");
		
		assertEquals("World", nieuweKlant.getNaam());
		assertEquals("Hello", nieuweKlant.getVoornaam());
		assertEquals(nieuwAdres.getStraat(), nieuweKlant.getAdres().getStraat());
		assertEquals(nieuwAdres.getNummer(), nieuweKlant.getAdres().getNummer());
		assertEquals(nieuwAdres.getBox(), nieuweKlant.getAdres().getBox());
		assertEquals(nieuwAdres.getPostcode(), nieuweKlant.getAdres().getPostcode());
		assertEquals(nieuwAdres.getGemeente(), nieuweKlant.getAdres().getGemeente());
		assertEquals(nieuwAdres.getLand(), nieuweKlant.getAdres().getLand());
		assertEquals(nieuweKlant.getNaam(), "World");
		assertEquals(nieuweKlant.getVoornaam(), "Hello");
		assertEquals(nieuweKlant.getAdres().getStraat(), nieuwAdres.getStraat());
		assertEquals(nieuweKlant.getAdres().getNummer(), nieuwAdres.getNummer());
		assertEquals(nieuweKlant.getAdres().getBox(), nieuwAdres.getBox());
		assertEquals(nieuweKlant.getAdres().getPostcode(), nieuwAdres.getPostcode());
		assertEquals(nieuweKlant.getAdres().getGemeente(), nieuwAdres.getGemeente());
		assertEquals(nieuweKlant.getAdres().getLand(), nieuwAdres.getLand());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_Klant_Met_Onmogelijke_Negatieve_KlantID_Wordt_Aangemaakt() {
		Klant nieuweKlant = new Klant(-1, "World", "Hello", adres, "hello.world@world.com");

	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_Klant_Met_Onmogelijke_Null_KlantID_Wordt_Aangemaakt() {
		Klant nieuweKlant = new Klant(0, "World", "Hello", adres, "hello.world@world.com");

	}
	
	@Test
	public void test_Equals_True_Als_Klanten_Gelijk_Zijn() {
		assertTrue(Integer.valueOf(klant.getKlantID()).equals(Integer.valueOf(klantGelijk.getKlantID())));
		assertTrue(klant.getNaam().equals(klantGelijk.getNaam()));
		assertTrue(klant.getVoornaam().equals(klantGelijk.getVoornaam()));
		assertTrue(klant.getAdres().getStraat().equals(klantGelijk.getAdres().getStraat()));
		assertTrue(klant.getAdres().getNummer().equals(klantGelijk.getAdres().getNummer()));
		assertTrue(klant.getAdres().getBox().equals(klantGelijk.getAdres().getBox()));
		assertTrue(klant.getAdres().getPostcode().equals(klantGelijk.getAdres().getPostcode()));
		assertTrue(klant.getAdres().getGemeente().equals(klantGelijk.getAdres().getGemeente()));
		assertTrue(klant.getAdres().getLand().equals(klantGelijk.getAdres().getLand()));
		assertTrue(Integer.valueOf(klantGelijk.getKlantID()).equals(Integer.valueOf(klant.getKlantID())));
		assertTrue(klantGelijk.getNaam().equals(klant.getNaam()));
		assertTrue(klantGelijk.getVoornaam().equals(klant.getVoornaam()));
		assertTrue(klantGelijk.getAdres().getStraat().equals(klant.getAdres().getStraat()));
		assertTrue(klantGelijk.getAdres().getNummer().equals(klant.getAdres().getNummer()));
		assertTrue(klantGelijk.getAdres().getBox().equals(klant.getAdres().getBox()));
		assertTrue(klantGelijk.getAdres().getPostcode().equals(klant.getAdres().getPostcode()));
		assertTrue(klantGelijk.getAdres().getGemeente().equals(klant.getAdres().getGemeente()));
		assertTrue(klantGelijk.getAdres().getLand().equals(klant.getAdres().getLand()));
	}
	
	@Test
	public void test_Equals_False_Als_Klanten_Niet_Gelijk_Zijn() {
		assertFalse(Integer.valueOf(klant.getKlantID()).equals(Integer.valueOf(klantNietGelijk.getKlantID())));
		assertFalse(klant.getNaam().equals(klantNietGelijk.getNaam()));
		assertFalse(klant.getVoornaam().equals(klantNietGelijk.getVoornaam()));
		assertFalse(klant.getAdres().getStraat().equals(klantNietGelijk.getAdres().getStraat()));
		assertFalse(klant.getAdres().getNummer().equals(klantNietGelijk.getAdres().getNummer()));
		assertFalse(klant.getAdres().getBox().equals(klantNietGelijk.getAdres().getBox()));
		assertFalse(klant.getAdres().getPostcode().equals(klantNietGelijk.getAdres().getPostcode()));
		assertFalse(klant.getAdres().getGemeente().equals(klantNietGelijk.getAdres().getGemeente()));
		assertFalse(klant.getAdres().getLand().equals(klantNietGelijk.getAdres().getLand()));
		assertFalse(Integer.valueOf(klantNietGelijk.getKlantID()).equals(Integer.valueOf(klant.getKlantID())));
		assertFalse(klantNietGelijk.getNaam().equals(klant.getNaam()));
		assertFalse(klantNietGelijk.getVoornaam().equals(klant.getVoornaam()));
		assertFalse(klantNietGelijk.getAdres().getStraat().equals(klant.getAdres().getStraat()));
		assertFalse(klantNietGelijk.getAdres().getNummer().equals(klant.getAdres().getNummer()));
		assertFalse(klantNietGelijk.getAdres().getBox().equals(klant.getAdres().getBox()));
		assertFalse(klantNietGelijk.getAdres().getPostcode().equals(klant.getAdres().getPostcode()));
		assertFalse(klantNietGelijk.getAdres().getGemeente().equals(klant.getAdres().getGemeente()));
		assertFalse(klantNietGelijk.getAdres().getLand().equals(klant.getAdres().getLand()));
	}
	

}
