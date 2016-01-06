package test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import domain.Item;

public class ItemTest {
	private Item item, itemGelijk, itemNietGelijk;
	
	@Before
	public void setUp() throws Exception {
		item = new Item("Een product", 'A', 1);
		itemGelijk = new Item("Een product", 'A', 1);
		itemNietGelijk = new Item("Tweede product", 'B', 2);
	}
	
	@Test
	public void test_Adres_Met_Vijf_Parameters_Wordt_Aangemaakt() {
		Item nieuwItem = new Item("Derde product", 'C', 3);
		
		assertEquals("Derde product", nieuwItem.getTitel());
		assertEquals('C', nieuwItem.getType());
		assertEquals(3, nieuwItem.getID());
		assertEquals(nieuwItem.getTitel(), "Derde product");
		assertEquals(nieuwItem.getType(), 'C');
		assertEquals(nieuwItem.getID(), 3);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void test_Item_Met_Onmogelijke_Negatieve_ID(){
		Item itemTest = new Item("Test", 'A', -1);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void test_Item_Met_Onmogelijke_Nul_ID(){
		Item itemTest = new Item("Test", 'A', 0);
	}
	
	@Test
	public void test_Equals_True_Als_Items_Gelijk_Zijn() {
		assertTrue(Integer.valueOf(item.getID()).equals(Integer.valueOf(itemGelijk.getID())));
		assertTrue(item.getTitel().equals(itemGelijk.getTitel()));
		assertTrue(Character.valueOf(item.getType()).equals(Character.valueOf(itemGelijk.getType())));
		assertTrue(Integer.valueOf(itemGelijk.getID()).equals(Integer.valueOf(item.getID())));
		assertTrue(itemGelijk.getTitel().equals(item.getTitel()));
		assertTrue(Character.valueOf(itemGelijk.getType()).equals(Character.valueOf(item.getType())));
	}
	
	@Test
	public void test_Equals_False_Als_Items_Niet_Gelijk_Zijn() {
		assertFalse(Integer.valueOf(item.getID()).equals(Integer.valueOf(itemNietGelijk.getID())));
		assertFalse(item.getTitel().equals(itemNietGelijk.getTitel()));
		assertFalse(Character.valueOf(item.getType()).equals(Character.valueOf(itemNietGelijk.getType())));
		assertFalse(Integer.valueOf(itemNietGelijk.getID()).equals(Integer.valueOf(item.getID())));
		assertFalse(itemNietGelijk.getTitel().equals(item.getTitel()));
		assertFalse(Character.valueOf(itemNietGelijk.getType()).equals(Character.valueOf(item.getType())));
	}


}
