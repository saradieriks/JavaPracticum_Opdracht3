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
		adresNietGelijk = new Adres("Brusselsebaan", "128", "100", "Brussel", "Frankrijk");
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
		//assertTrue(klant.getKlantID
		assertTrue(klant.getNaam().equals(klantGelijk.getNaam()));
	}
	
	@Test
	public void test_Equals_False_Als_Klanten_Niet_Gelijk_Zijn() {

	}
	

}
