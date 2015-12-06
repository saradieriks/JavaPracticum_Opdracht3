package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import domain.Adres;

public class AdresTest {
	private Adres adres, adresGelijk, adresNietGelijk;
	
	@Before
	public void SetUp()throws Exception {
		adres = new Adres("Leuvensebaan", "28", "3000", "Leuven", "België");
		adresGelijk = new Adres("Leuvensebaan", "28", "3000", "Leuven", "België");
		adresNietGelijk = new Adres("Brusselsebaan", "128", "100", "Brussel");
	}
	
	@Test
	public void test_Adres_Met_Vijf_Parameters_Wordt_Aangemaakt() {
		Adres nieuwAdres = new Adres("Brusselsebaan", "128", "1000", "Brussel", "België");
		
		assertEquals("Brusselsebaan", nieuwAdres.getStraat());
		assertEquals("128", nieuwAdres.getNummer());
		assertEquals("1000", nieuwAdres.getPostcode());
		assertEquals("Brussel", nieuwAdres.getGemeente());
		assertEquals("België", nieuwAdres.getLand());
	}
	
	@Test
	public void test_Adres_Met_Vier_Parameters_Wordt_Aangemaakt() {
		Adres nieuwAdres = new Adres("Brusselsebaan", "128", "1000", "Brussel");
		
		assertEquals("Brusselsebaan", nieuwAdres.getStraat());
		assertEquals("128", nieuwAdres.getNummer());
		assertEquals("1000", nieuwAdres.getPostcode());
		assertEquals("Brussel", nieuwAdres.getGemeente());
	}
	
	/*
	@Test
	public void test_Adres_Met_Default_Constructor() {
		Adres nieuwAdres = new Adres();
		
		assertNotNull(nieuwAdres);
	}
	
	
	@Test
	public void test_Adres_Met_Verkeerde_Input_Postcode() {
		Adres nieuwAdres = new Adres("Brusselsebaan", "128", "100", "Brussel");
		
		assertEquals("Brusselsebaan", nieuwAdres.getStraat());
		assertEquals("128", nieuwAdres.getNummer());
		assertEquals("100", nieuwAdres.getPostcode());
		assertEquals("Brussel", nieuwAdres.getGemeente());
	}
	
	@Test
	public void test_Adres_Met_Verkeerde_Input_Nummer() {
		Adres nieuwAdres = new Adres("Brusselsebaan", "", "1000", "Brussel");
		
		assertEquals("Brusselsebaan", nieuwAdres.getStraat());
		assertEquals("", nieuwAdres.getNummer());
		assertEquals("1000", nieuwAdres.getPostcode());
		assertEquals("Brussel", nieuwAdres.getGemeente());
	}
	*/
	
	@Test
	public void test_Equals_True_Als_Adressen_Gelijk_Zijn() {
		assertEquals(adres, adresGelijk);
		assertEquals(adresGelijk, adres);
	}
	
	@Test
	public void test_Equals_False_Als_Adressen_Niet_Gelijk_Zijn() {
		assertFalse(adresGelijk.equals(adresNietGelijk));
	}
	

}
