package marketplace.domain;

import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.Test;
import org.joda.money.Money;

public class MerchantOfferDbTests {

	@Test
	public final void testGetMerchantOffers() {
		
		MerchantOfferId moid =  new MerchantOfferId(1, 1);
		MerchantOfferDb db = new MerchantOfferDb();
		db.addMerchantOffer(new MerchantOffer(
				"product1", "a product", moid, Money.parse("USD 1.00")));
		
		MerchantOffer offer = db.getMerchantOffer(moid);
	
		assertEquals(offer.getDescription(), "a product");
		assertEquals(offer.getName(), "product1");
	}

	@Test
	public final void testRemoveMerchantOffer() {

		MerchantOfferId moid =  new MerchantOfferId(1, 1);
		MerchantOfferDb db = new MerchantOfferDb();
		db.addMerchantOffer(new MerchantOffer(
				"product1", "a product", moid, Money.parse("USD 1.00")));
		
		MerchantOffer offer = db.getMerchantOffer(moid);
	
		assertNotNull(offer);
		
		db.removeMerchantOffer(moid);
		
		MerchantOffer offer2 = db.getMerchantOffer(moid);
		
		assertNull(offer2);
	}

	@Test
	public final void testAddMerchantOffer() {
		
		MerchantOfferId moid =  new MerchantOfferId(1, 1);
		MerchantOfferDb db = new MerchantOfferDb();
		db.addMerchantOffer(new MerchantOffer(
				"product1", "a product", moid, Money.parse("GBP 1.00")));
		
		MerchantOffer offer = db.getMerchantOffer(moid);
	
		assertNotNull(offer);
	}

	@Test
	public final void testGetTopMerhantOfferIdForMerchantId() {
		MerchantOfferId moid =  new MerchantOfferId(1, 1);
		MerchantOfferDb db = new MerchantOfferDb();
		db.addMerchantOffer(new MerchantOffer(
				"product1", "a product", moid, Money.parse("USD 1.00")));
		
		MerchantOfferId moid2 =  new MerchantOfferId(2, 1);
		db.addMerchantOffer(new MerchantOffer(
				"product1", "a product", moid2, Money.parse("USD 1.00")));
		
		MerchantOfferId moid3 =  new MerchantOfferId(2, 2);
		db.addMerchantOffer(new MerchantOffer(
				"product2", "a 2nd product", moid3, Money.parse("USD 1.00")));
		
		assertEquals(db.getTopMerhantOfferIdForMerchantId(2).getOfferId(), 2);
	}

	@Test
	public final void testGetMerchantOffer() {
		MerchantOfferDb db = new MerchantOfferDb();
		
		MerchantOfferId moid2 =  new MerchantOfferId(2, 1);
		db.addMerchantOffer(new MerchantOffer(
				"product1", "a product", moid2, Money.parse("USD 1.00")));
		
		MerchantOfferId moid3 =  new MerchantOfferId(2, 2);
		db.addMerchantOffer(new MerchantOffer(
				"product2", "a 2nd product", moid3, Money.parse("USD 1.00")));
		
		Collection<MerchantOffer> offers = db.getMerchantOffers(2);
		
		assertEquals(offers.size(), 2);
	}

}
