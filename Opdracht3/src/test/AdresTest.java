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
		adresNietGelijk = new Adres("Brusselsebaan", "128", "100", "Brussel", "Frankrijk");
	}
	
	@Test
	public void test_Adres_Met_Vijf_Parameters_Wordt_Aangemaakt() {
		Adres nieuwAdres = new Adres("Brusselsebaan", "128", "1000", "Brussel", "België");
		
		assertEquals("Brusselsebaan", nieuwAdres.getStraat());
		assertEquals("128", nieuwAdres.getNummer());
		assertEquals("1000", nieuwAdres.getPostcode());
		assertEquals("Brussel", nieuwAdres.getGemeente());
		assertEquals("België", nieuwAdres.getLand());
		assertEquals(nieuwAdres.getStraat(), "Brusselsebaan");
		assertEquals(nieuwAdres.getNummer(), "128");
		assertEquals(nieuwAdres.getPostcode(), "1000");
		assertEquals(nieuwAdres.getGemeente(), "Brussel");
		assertEquals(nieuwAdres.getLand(), "België");		
	}
	
	@Test
	public void test_Adres_Met_Vier_Parameters_Wordt_Aangemaakt() {
		Adres nieuwAdres = new Adres("Brusselsebaan", "128", "1000", "Brussel");
		
		assertEquals("Brusselsebaan", nieuwAdres.getStraat());
		assertEquals("128", nieuwAdres.getNummer());
		assertEquals("1000", nieuwAdres.getPostcode());
		assertEquals("Brussel", nieuwAdres.getGemeente());
		assertEquals(nieuwAdres.getStraat(), "Brusselsebaan");
		assertEquals(nieuwAdres.getNummer(), "128");
		assertEquals(nieuwAdres.getPostcode(), "1000");
		assertEquals(nieuwAdres.getGemeente(), "Brussel");
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
		assertTrue(adres.getStraat().equals(adresGelijk.getStraat()));
		assertTrue(adres.getNummer().equals(adresGelijk.getNummer()));
		assertTrue(adres.getPostcode().equals(adresGelijk.getPostcode()));
		assertTrue(adres.getGemeente().equals(adresGelijk.getGemeente()));
		assertTrue(adres.getLand().equals(adresGelijk.getLand()));
		assertTrue(adresGelijk.getStraat().equals(adres.getStraat()));
		assertTrue(adresGelijk.getNummer().equals(adres.getNummer()));
		assertTrue(adresGelijk.getPostcode().equals(adres.getPostcode()));
		assertTrue(adresGelijk.getGemeente().equals(adres.getGemeente()));
		assertTrue(adresGelijk.getLand().equals(adres.getLand()));
	}
	
	@Test
	public void test_Equals_False_Als_Adressen_Niet_Gelijk_Zijn() {
		assertFalse(adresGelijk.getStraat().equals(adresNietGelijk.getStraat()));
		assertFalse(adresGelijk.getNummer().equals(adresNietGelijk.getNummer()));
		assertFalse(adresGelijk.getPostcode().equals(adresNietGelijk.getPostcode()));
		assertFalse(adresGelijk.getGemeente().equals(adresNietGelijk.getGemeente()));
		assertFalse(adresGelijk.getLand().equals(adresNietGelijk.getLand()));
		assertFalse(adresNietGelijk.getStraat().equals(adresGelijk.getStraat()));
		assertFalse(adresNietGelijk.getNummer().equals(adresGelijk.getNummer()));
		assertFalse(adresNietGelijk.getPostcode().equals(adresGelijk.getNummer()));
		assertFalse(adresNietGelijk.getGemeente().equals(adresGelijk.getGemeente()));
		assertFalse(adresNietGelijk.getLand().equals(adresGelijk.getLand()));
	}
	

}
