package marketplace.domain;
import static org.junit.Assert.*;

import org.junit.Test;

public class MerchantDbTests {

	@Test
	public final void testGetDoesMerchantExist() {
		MerchantDb db = new MerchantDb();
		db.addMerchant(new Merchant("merchant1", 1, "description"));
		
		assertTrue(db.getDoesMerchantExist(1));
		assertFalse(db.getDoesMerchantExist(2));
	}

	@Test
	public final void testAddMerchant() {
		MerchantDb db = new MerchantDb();
		db.addMerchant(new Merchant("merchant1", 1, "description"));
		Merchant m = db.getMerchant(1);
		
		assertEquals(m.getMerchantId(), 1);
		assertEquals(m.getDescription(), "description");
		assertEquals(m.getName(), "merchant1");
	}

	@Test
	public final void testGetTopMerchantId() {
		MerchantDb db = new MerchantDb();
		db.addMerchant(new Merchant("merchant1", 1, "description"));
		db.addMerchant(new Merchant("merchant1", 2, "description"));
		
		assertEquals(db.getTopMerchantId(), 2);
	}

	@Test
	public final void testGetMerchant() {
		MerchantDb db = new MerchantDb();
		db.addMerchant(new Merchant("merchant1", 1, "description"));
		Merchant m = db.getMerchant(1);
		
		assertEquals(m.getDescription(), "description");
		assertEquals(m.getName(), "merchant1");
	}

	@Test
	public final void testDeleteMerchant() {
		MerchantDb db = new MerchantDb();
		db.addMerchant(new Merchant("merchant1", 1, "description"));

		Merchant m = db.deleteMerchant(1);
		
		assertEquals(m.getDescription(), "description");
		assertEquals(m.getName(), "merchant1");
		
		assertNull(db.getMerchant(1));
		
	}

}
