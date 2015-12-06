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
	private Item item;
	

	
	@Before
	public void SetUp()throws Exception {
		datum = new Datum(21,9,2015);
		item = new Item("Eerste product", 'A', 1);
		Reservatie reservatie = new Reservatie(20.5, datum, item, 2, 30.5, false, 1);
		Reservatie reservatie2 = new Reservatie(10.5, datum, item, 5, 2);
		Reservatie reservatie3 = new Reservatie(11.8, datum, item, 10, 50.3, 3);
		Reservatie reservatie4 = new Reservatie(item, 25, 4);
		Reservatie reservatieGelijk = new Reservatie(20.5, datum, item, 2, 30.5, false, 1);
		Reservatie reservatieNietGelijk = new Reservatie(11.7, datum, item, 2, 5.5, false, 6);
	}
	
	
	
	@Test
	public void test_Reservatie_Met_7_Parameters_Wordt_Aangemaakt() {
		Reservatie nieuweReservatie = new Reservatie(10.5, datum, item, 7, 15.5, true, 9);

		assertEquals(Double.valueOf(10.5), nieuweReservatie.getPrijs());
		assertEquals(new Datum(21,9,2015), nieuweReservatie.getStartDatum());
		//assertEquals(new Item("Eerste product", 'A', 1), nieuweReservatie.getItem());
		assertEquals(7, nieuweReservatie.getAatalDagen());
		assertEquals(Double.valueOf(15.5), nieuweReservatie.getBoete());
		assertEquals(true, nieuweReservatie.getBetaald());
		assertEquals(9, nieuweReservatie.klantID());
	}
	
	@Test
	public void test_Reservatie_Met_6_Parameters_Wordt_Aangemaakt() {
		Reservatie nieuweReservatie = new Reservatie(12.7, datum, item, 4, 2.5, 8);

		assertEquals(Double.valueOf(12.7), nieuweReservatie.getPrijs());
		assertEquals(new Datum(21,9,2015), nieuweReservatie.getStartDatum());
		//assertEquals(new Item("Eerste product", 'A', 1), nieuweReservatie.getItem());
		assertEquals(4, nieuweReservatie.getAatalDagen());
		assertEquals(Double.valueOf(2.5), nieuweReservatie.getBoete());
		assertEquals(8, nieuweReservatie.klantID());
	}

	
	@Test
	public void test_Reservatie_Met_5_Parameters_Wordt_Aangemaakt() {
		Reservatie nieuweReservatie = new Reservatie(12.7, datum, item, 4, 8);

		assertEquals(Double.valueOf(12.7), nieuweReservatie.getPrijs());
		assertEquals(new Datum(21,9,2015), nieuweReservatie.getStartDatum());
		//assertEquals(new Item("Eerste product", 'A', 1), nieuweReservatie.getItem());
		assertEquals(4, nieuweReservatie.getAatalDagen());
		assertEquals(8, nieuweReservatie.klantID());
	}

	@Test
	public void test_Reservatie_Met_3_Parameters_Wordt_Aangemaakt() {
		Reservatie nieuweReservatie = new Reservatie(item, 4, 8);

		//assertEquals(new Item("Eerste product", 'A', 1), nieuweReservatie.getItem());
		assertEquals(4, nieuweReservatie.getAatalDagen());
		assertEquals(8, nieuweReservatie.klantID());
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
}
