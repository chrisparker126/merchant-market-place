package marketplace.core;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.joda.money.Money;

import org.junit.Test;

import marketplace.core.IMerchantManager.MerchantManagerException;
import marketplace.domain.Merchant;
import marketplace.domain.MerchantOffer;
import marketplace.domain.MerchantOfferId;
import marketplace.domain.MoneyDeserialiser;
import marketplace.domain.exceptions.MerchantOfferManagerException;

public class MarketPlaceTest {

	@Test
	public final void testCreateMerchant() throws MerchantManagerException {
		
		IMerchantManager mockMerchantManager = mock(IMerchantManager.class);
		IMerchantOfferManager mockMerchantOfferManager = mock(IMerchantOfferManager.class);
		
		when(mockMerchantManager.createMerchant("merchant1", ""))
		.thenReturn(new Merchant("dada", 1, "ddad"));
	
		MarketPlace marketPlace = new MarketPlace(mockMerchantManager, mockMerchantOfferManager);
		Merchant m = marketPlace.createMerchant("merchant1", "");
		
		assertEquals(m.getName(), "dada");
		assertEquals(m.getDescription(), "ddad");
	}


	@Test
	public final void testCreateMerchantOffer() throws MerchantOfferManagerException {
		IMerchantManager mockMerchantManager = mock(IMerchantManager.class);
		IMerchantOfferManager mockMerchantOfferManager = mock(IMerchantOfferManager.class);
		
		when(mockMerchantOfferManager.createMerchantOffer("product2",
					null, null, 1))
			.thenReturn(new MerchantOffer("product2", null, null, 
					Money.parse("USD 1.50")));

		MarketPlace marketPlace = new MarketPlace(mockMerchantManager, mockMerchantOfferManager);
		MerchantOffer mo = marketPlace.createMerchantOffer(1, "product2", null, null);
		
		assertEquals(mo.getName(), "product2");
		assertEquals(mo.getPrice(), Money.parse("USD 1.50"));
	}

	@Test
	public final void testUpdateMerchantOffer() throws MerchantOfferManagerException {
		
		IMerchantManager mockMerchantManager = mock(IMerchantManager.class);
		IMerchantOfferManager mockMerchantOfferManager = mock(IMerchantOfferManager.class);
		
		MerchantOffer updatedOffer = new 
				MerchantOffer("productX", "X", new 
						MerchantOfferId(1, 3), null);
		when(mockMerchantOfferManager.updateMerchantOffer(updatedOffer))
			.thenReturn(updatedOffer);

		MarketPlace marketPlace = new MarketPlace(mockMerchantManager, mockMerchantOfferManager);
		MerchantOffer mo = marketPlace.updateMerchantOffer(updatedOffer);
		
		assertEquals(mo.getName(), "productX");
		assertNull(mo.getPrice());
		assertEquals(mo.getDescription(), "X");

	}

}
