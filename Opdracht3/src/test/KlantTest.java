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
	private Adres adres;
	private Klant klant;
	
	@Before
	public void SetUp()throws Exception {
		adres = new Adres("Leuvensebaan", "351", "b", "3000", "Leuven", "België");
		klant = new Klant(1, "World", "Hello", adres, "hello.world@world.com");
	}
		
	@Test
	public void test_Klant_Met_5_Parameters_Wordt_Aangemaakt() {
		Klant nieuweKlant = new Klant(1, "World", "Hello", adres, "hello.world@world.com");
		
		assertEquals(1, nieuweKlant.getKlantID());
		assertEquals("World", nieuweKlant.getNaam());
		assertEquals("Hello", nieuweKlant.getVoornaam());
		assertEquals(new Adres("Brusselsesebaan", "35", "a", "1000", "Brussel", "België"), nieuweKlant.getAdres());
		assertEquals("hello.world@world.com", nieuweKlant.getEmail());
	}
	
	@Test
	public void test_Klant_Met_4_Parameters_Zonder_KlantID_Wordt_Aangemaakt() {
		Klant nieuweKlant = new Klant("World", "Hello", adres, "hello.world@world.com");
		
		assertEquals("World", nieuweKlant.getNaam());
		assertEquals("Hello", nieuweKlant.getVoornaam());
		assertEquals(new Adres("Leuvensebaan", "351", "b", "3000", "Leuven", "België"), nieuweKlant.getAdres());
		assertEquals("hello.world@world.com", nieuweKlant.getEmail());
	}
	
	@Test
	public void test_Klant_Met_4_Parameters_Zonder_Email_Wordt_Aangemaakt() {
		Klant nieuweKlant = new Klant(1, "World", "Hello", adres);
		
		assertEquals(1, nieuweKlant.getKlantID());
		assertEquals("World", nieuweKlant.getNaam());
		assertEquals("Hello", nieuweKlant.getVoornaam());
		assertEquals(new Adres("Leuvensebaan", "351", "b", "3000", "Leuven", "België"), nieuweKlant.getAdres());
	}
	
	@Test
	public void test_Klant_Met_3_Parameters_Wordt_Aangemaakt() {
		Klant nieuweKlant = new Klant("World", "Hello", adres);
		
		assertEquals("World", nieuweKlant.getNaam());
		assertEquals("Hello", nieuweKlant.getVoornaam());
		assertEquals(new Adres("Leuvensebaan", "351", "b", "3000", "Leuven", "België"), nieuweKlant.getAdres());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_Klant_Met_Onmogelijke_Negatieve_KlantID_Wordt_Aangemaakt() {
		Klant nieuweKlant = new Klant(-1, "World", "Hello", adres, "hello.world@world.com");

	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test_Klant_Met_Onmogelijke_Null_KlantID_Wordt_Aangemaakt() {
		Klant nieuweKlant = new Klant(0, "World", "Hello", adres, "hello.world@world.com");

	}
	
	

}
