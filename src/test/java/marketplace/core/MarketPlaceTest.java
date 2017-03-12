package marketplace.core;

import static org.hamcrest.CoreMatchers.any;
import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.joda.money.Money;

import org.junit.Test;

import marketplace.core.IMerchantManager.MerchantManagerException;
import marketplace.core.IMerchantOfferManager.MerchantOfferManagerException;
import marketplace.domain.Merchant;
import marketplace.domain.MerchantOffer;
import marketplace.domain.MoneyDeserialiser;

public class MarketPlaceTest {

	@Test
	public final void testCreateMerchant() {
		
		IMerchantManager mockMerchantManager = mock(IMerchantManager.class);
		IMerchantOfferManager mockMerchantOfferManager = mock(IMerchantOfferManager.class);
		
		try {
			when(mockMerchantManager.createMerchant("merchant1", ""))
			.thenReturn(new Merchant("dada", 1, "ddad"));
		} catch (MerchantManagerException e) {
		
			e.printStackTrace();
		}
		MarketPlace marketPlace = new MarketPlace(mockMerchantManager, mockMerchantOfferManager);
		Merchant m = marketPlace.createMerchant("merchant1", "");
		
		assertEquals(m.getName(), "dada");
		assertEquals(m.getDescription(), "ddad");
	}


	@Test
	public final void testCreateMerchantOffer() {
		IMerchantManager mockMerchantManager = mock(IMerchantManager.class);
		IMerchantOfferManager mockMerchantOfferManager = mock(IMerchantOfferManager.class);
		
		try {
			when(mockMerchantOfferManager.createMerchantOffer("product2",
						null, null, 1))
				.thenReturn(new MerchantOffer("product2", null, null, 
						Money.parse("USD 1.50")));
		} catch (MerchantOfferManagerException e) {

			e.printStackTrace();
		}
		MarketPlace marketPlace = new MarketPlace(mockMerchantManager, mockMerchantOfferManager);
		MerchantOffer mo = marketPlace.createMerchantOffer(1, "product2", null, null);
		
		assertEquals(mo.getName(), "product2");
		assertEquals(mo.getPrice(), Money.parse("USD 1.50"));
	}

}
