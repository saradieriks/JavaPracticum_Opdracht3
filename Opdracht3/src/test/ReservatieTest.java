package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import domain.Adres;
import domain.Datum;
import domain.Item;
import domain.Reservatie;

public class ReservatieTest {
	private Datum datum;
	private Item item, nieuwItem, itemNietGelijk;
	private Reservatie reservatie, reservatieGelijk, reservatieNietGelijk;
	

	
	@Before
	public void SetUp()throws Exception {
		datum = new Datum(21,9,2015);
		item = new Item("Eerste product", 'A', 1);
		nieuwItem = new Item ("Eerste product", 'A', 1);
		itemNietGelijk = new Item("Tweede product", 'B', 2);
		reservatie = new Reservatie(20.5, datum, item, 2, 30.5, false, 1);
		reservatieGelijk = new Reservatie(20.5, datum, item, 2, 30.5, false, 1);
		reservatieNietGelijk = new Reservatie(11.7, new Datum(15,9,2014), itemNietGelijk, 3, 5.5, true, 6);
	}
	
	
	
	@Test
	public void test_Reservatie_Met_7_Parameters_Wordt_Aangemaakt() {
		Reservatie nieuweReservatie = new Reservatie(10.5, datum, item, 7, 15.5, true, 9);
		
		assertEquals(Double.valueOf(10.5), nieuweReservatie.getPrijs());
		assertEquals(new Datum(21,9,2015), nieuweReservatie.getStartDatum());
		assertEquals(nieuwItem.getID(), nieuweReservatie.getItem().getID());
		assertEquals(nieuwItem.getTitel(), nieuweReservatie.getItem().getTitel());
		assertEquals(nieuwItem.getType(), nieuweReservatie.getItem().getType());
		assertEquals(7, nieuweReservatie.getAatalDagen());
		assertEquals(Double.valueOf(15.5), nieuweReservatie.getBoete());
		assertEquals(false, nieuweReservatie.getBetaald());
		assertEquals(9, nieuweReservatie.klantID());
		assertEquals(nieuweReservatie.getPrijs(), Double.valueOf(10.5));
		assertEquals(nieuweReservatie.getStartDatum(), new Datum(21, 9, 2015));
		assertEquals(nieuweReservatie.getItem().getID(), nieuwItem.getID());
		assertEquals(nieuweReservatie.getItem().getTitel(), nieuwItem.getTitel());
		assertEquals(nieuweReservatie.getItem().getType(), nieuwItem.getType());
		assertEquals(nieuweReservatie.getAatalDagen(), 7);
		assertEquals(nieuweReservatie.getBoete(), Double.valueOf(15.5));
		assertEquals(nieuweReservatie.getBetaald(), false);
		assertEquals(nieuweReservatie.klantID(), 9);
	}
	
	@Test
	public void test_Reservatie_Met_6_Parameters_Wordt_Aangemaakt() {
		Reservatie nieuweReservatie = new Reservatie(12.7, datum, item, 4, 2.5, 8);
		
		assertEquals(Double.valueOf(12.7), nieuweReservatie.getPrijs());
		assertEquals(new Datum(21,9,2015), nieuweReservatie.getStartDatum());
		assertEquals(nieuwItem.getID(), nieuweReservatie.getItem().getID());
		assertEquals(nieuwItem.getTitel(), nieuweReservatie.getItem().getTitel());
		assertEquals(nieuwItem.getType(), nieuweReservatie.getItem().getType());
		assertEquals(4, nieuweReservatie.getAatalDagen());
		assertEquals(Double.valueOf(2.5), nieuweReservatie.getBoete());
		assertEquals(8, nieuweReservatie.klantID());
		assertEquals(nieuweReservatie.getPrijs(), Double.valueOf(12.7));
		assertEquals(nieuweReservatie.getStartDatum(), new Datum(21,9,2015));
		assertEquals(nieuweReservatie.getItem().getID(), nieuwItem.getID());
		assertEquals(nieuweReservatie.getItem().getTitel(), nieuwItem.getTitel());
		assertEquals(nieuweReservatie.getItem().getType(), nieuwItem.getType());
		assertEquals(nieuweReservatie.getAatalDagen(), 4);
		assertEquals(nieuweReservatie.getBoete(), Double.valueOf(2.5));
		assertEquals(nieuweReservatie.klantID(), 8);
	}

	
	@Test
	public void test_Reservatie_Met_5_Parameters_Wordt_Aangemaakt() {
		Reservatie nieuweReservatie = new Reservatie(12.7, datum, item, 4, 8);
		
		assertEquals(Double.valueOf(12.7), nieuweReservatie.getPrijs());
		assertEquals(new Datum(21,9,2015), nieuweReservatie.getStartDatum());
		assertEquals(nieuwItem.getID(), nieuweReservatie.getItem().getID());
		assertEquals(nieuwItem.getTitel(), nieuweReservatie.getItem().getTitel());
		assertEquals(nieuwItem.getType(), nieuweReservatie.getItem().getType());
		assertEquals(4, nieuweReservatie.getAatalDagen());
		assertEquals(8, nieuweReservatie.klantID());
		assertEquals(nieuweReservatie.getPrijs(), Double.valueOf(12.7));
		assertEquals(nieuweReservatie.getStartDatum(), new Datum(21,9,2015));
		assertEquals(nieuweReservatie.getItem().getID(), nieuwItem.getID());
		assertEquals(nieuweReservatie.getItem().getTitel(), nieuwItem.getTitel());
		assertEquals(nieuweReservatie.getItem().getType(), nieuwItem.getType());
		assertEquals(nieuweReservatie.getAatalDagen(), 4);
		assertEquals(nieuweReservatie.klantID(), 8);
	}

	@Test
	public void test_Reservatie_Met_3_Parameters_Wordt_Aangemaakt() {
		Reservatie nieuweReservatie = new Reservatie(item, 4, 8);

		assertEquals(nieuwItem.getID(), nieuweReservatie.getItem().getID());
		assertEquals(nieuwItem.getTitel(), nieuweReservatie.getItem().getTitel());
		assertEquals(nieuwItem.getType(), nieuweReservatie.getItem().getType());
		assertEquals(4, nieuweReservatie.getAatalDagen());
		assertEquals(8, nieuweReservatie.klantID());
		assertEquals(nieuweReservatie.getItem().getID(), nieuwItem.getID());
		assertEquals(nieuweReservatie.getItem().getTitel(), nieuwItem.getTitel());
		assertEquals(nieuweReservatie.getItem().getType(), nieuwItem.getType());
		assertEquals(nieuweReservatie.getAatalDagen(), 4);
		assertEquals(nieuweReservatie.klantID(), 8);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void test_Reservatie_Met_Onmogelijke_Negatieve_Prijs(){
		Reservatie nieuweReservatie = new Reservatie(-5.6, datum, item, 7, 15.5, true, 9);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void test_Reservatie_Met_Onmogelijke_Negatieve_AantalDagen(){
		Reservatie nieuweReservatie = new Reservatie(7.5, datum, item, -9, 15.5, true, 9);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void test_Reservatie_Met_Onmogelijke_Negatieve_Boete(){
		Reservatie nieuweReservatie = new Reservatie(7.5, datum, item, 7, -15.5, true, 9);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void test_Reservatie_Met_Onmogelijke_Negatieve_KlantID(){
		Reservatie nieuweReservatie = new Reservatie(7.5, datum, item, 7, 15.5, true, -9);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void test_Reservatie_Met_Onmogelijke_Nul_KlantID(){
		Reservatie nieuweReservatie = new Reservatie(7.5, datum, item, 7, 15.5, true, 0);
	}
	
	@Test
	public void test_Equals_True_Als_Reservaties_Gelijk_Zijn() {
		assertTrue(reservatie.getPrijs().equals(reservatieGelijk.getPrijs()));
		assertTrue(reservatie.getStartDatum().equals(reservatieGelijk.getStartDatum()));
		assertTrue(reservatie.getItem().equals(reservatieGelijk.getItem()));
		assertTrue(Integer.valueOf(reservatie.getAatalDagen()).equals(Integer.valueOf(reservatieGelijk.getAatalDagen())));
		assertTrue(reservatie.getBoete().equals(reservatieGelijk.getBoete()));
		assertTrue(reservatie.getBetaald().equals(reservatieGelijk.getBetaald()));
		assertTrue(Integer.valueOf(reservatie.klantID()).equals(Integer.valueOf(reservatieGelijk.klantID())));
		assertTrue(reservatieGelijk.getPrijs().equals(reservatie.getPrijs()));
		assertTrue(reservatieGelijk.getStartDatum().equals(reservatie.getStartDatum()));
		assertTrue(reservatieGelijk.getItem().equals(reservatie.getItem()));
		assertTrue(Integer.valueOf(reservatieGelijk.getAatalDagen()).equals(Integer.valueOf(reservatie.getAatalDagen())));
		assertTrue(reservatieGelijk.getBoete().equals(reservatie.getBoete()));
		assertTrue(reservatieGelijk.getBetaald().equals(reservatie.getBetaald()));
		assertTrue(Integer.valueOf(reservatieGelijk.klantID()).equals(Integer.valueOf(reservatie.klantID())));
	}
	
	@Test
	public void test_Equals_False_Als_Reservaties_Niet_Gelijk_Zijn() {
		assertFalse(reservatie.getPrijs().equals(reservatieNietGelijk.getPrijs()));
		assertFalse(reservatie.getStartDatum().equals(reservatieNietGelijk.getStartDatum()));
		assertFalse(reservatie.getItem().equals(reservatieNietGelijk.getItem()));
		assertFalse(Integer.valueOf(reservatie.getAatalDagen()).equals(Integer.valueOf(reservatieNietGelijk.getAatalDagen())));
		assertFalse(reservatie.getBoete().equals(reservatieNietGelijk.getBoete()));
		//assertTrue(reservatie.getBetaald().equals(reservatieNietGelijk.getBetaald()));
		assertFalse(Integer.valueOf(reservatie.klantID()).equals(Integer.valueOf(reservatieNietGelijk.klantID())));
		assertFalse(reservatieNietGelijk.getPrijs().equals(reservatie.getPrijs()));
		assertFalse(reservatieNietGelijk.getStartDatum().equals(reservatie.getStartDatum()));
		assertFalse(reservatieNietGelijk.getItem().equals(reservatie.getItem()));
		assertFalse(Integer.valueOf(reservatieNietGelijk.getAatalDagen()).equals(Integer.valueOf(reservatie.getAatalDagen())));
		assertFalse(reservatieNietGelijk.getBoete().equals(reservatie.getBoete()));
		//assertTrue(reservatieNietGelijk.getBetaald().equals(reservatie.getBetaald()));
		assertFalse(Integer.valueOf(reservatieNietGelijk.klantID()).equals(Integer.valueOf(reservatie.klantID())));
	}
	
}
