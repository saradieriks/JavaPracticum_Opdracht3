package test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import domain.Item;

public class ItemTest {
	private Item item;
	
	@Before
	public void setUp() throws Exception {
		item = new Item("Een product", 'A', 1);
	}
	
	@Test
	public void test_Adres_Met_Vijf_Parameters_Wordt_Aangemaakt() {
		Item nieuwItem = new Item("Nog een ander product", 'B', 2);
		
		assertEquals("Nog een ander product", nieuwItem.getTitel());
		assertEquals('B', nieuwItem.getType());
		assertEquals(2, nieuwItem.getID());
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void test_Item_Met_Onmogelijke_Negatieve_ID(){
		Item itemTest = new Item("Test", 'A', -1);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void test_Item_Met_Onmogelijke_Nul_ID(){
		Item itemTest = new Item("Test", 'A', 0);
	}


}
