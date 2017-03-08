package marketplace.core;

import static org.junit.Assert.*;

import org.junit.Test;

import marketplace.core.IMerchantOfferManager.MerchantOfferManagerException;
import marketplace.domain.IMerchantInfoRepository;
import marketplace.domain.IMerchantOfferRepository;
import marketplace.domain.IMerchantRepository;
import marketplace.domain.MerchantOffer;
import marketplace.domain.MerchantOfferId;

import static org.mockito.Mockito.*;

import java.util.Collection;
import java.util.LinkedList;

import org.joda.money.Money;


public class MerchantOfferManagerTests {

	@Test
	public final void testCreateMerchantOffer() {
		
		IMerchantOfferRepository repo = mock(IMerchantOfferRepository.class);
		IMerchantInfoRepository repoInfo = mock(IMerchantInfoRepository.class);
		
		MerchantOfferId moid = new MerchantOfferId(1, 2);
		when(repo.addMerchantOffer(any())).thenReturn(new 
				MerchantOffer("product1", "a product", moid, Money.parse("USD 1.00")));	
		
		when(repoInfo.getDoesMerchantExist(1)).thenReturn(true);
		when(repo.getTopMerhantOfferIdForMerchantId(1)).thenReturn(moid);
		
		MerchantOfferManager offerManager = new 
		MerchantOfferManager(repo, repoInfo);
		
		try {
			
			MerchantOffer offer =  offerManager.createMerchantOffer("product1", "a product", Money.parse("USD 1.00"), 1);
			
			assertEquals(offer.getDescription(), "a product");
			assertEquals(offer.getName(), "product1");
			assertEquals(offer.getPrice(), Money.parse("USD 1.00"));
			assertEquals(offer.getMerchantOfferId(), moid);
			
		} catch (MerchantOfferManagerException e) {

			e.printStackTrace();
		}
	}

	@Test
	public final void testRemoveMerchantOffer() {
		
		IMerchantOfferRepository repo = mock(IMerchantOfferRepository.class);
		IMerchantInfoRepository repoInfo = mock(IMerchantInfoRepository.class);
		
		MerchantOfferId moid = new MerchantOfferId(1, 2);
		when(repo.removeMerchantOffer(any())).thenReturn(new 
				MerchantOffer("product1", "a product", moid, Money.parse("USD 1.00")),
				(MerchantOffer) null);	
		
		when(repoInfo.getDoesMerchantExist(1)).thenReturn(true);
		
		MerchantOfferManager offerManager = new 
		MerchantOfferManager(repo, repoInfo);
		
		try {			
			
			MerchantOffer offer =  offerManager.removeMerchantOffer(moid);
			
			assertEquals(offer.getDescription(), "a product");
			assertEquals(offer.getName(), "product1");
			assertEquals(offer.getPrice(), Money.parse("USD 1.00"));
			assertEquals(offer.getMerchantOfferId(), moid);
			
			MerchantOffer offerNull =  offerManager.removeMerchantOffer(moid);
			
			assertNull(offerNull);
			
		} catch (MerchantOfferManagerException e) {

			e.printStackTrace();
		}
	}

	@Test
	public final void testGetMerchantOffer() {
		
		IMerchantOfferRepository repo = mock(IMerchantOfferRepository.class);
		IMerchantInfoRepository repoInfo = mock(IMerchantInfoRepository.class);
		
		MerchantOfferId moid = new MerchantOfferId(1, 2);
		when(repo.getMerchantOffer(any())).thenReturn(new 
				MerchantOffer("product1", "a product", moid, Money.parse("USD 1.00")));	
		
		when(repoInfo.getDoesMerchantExist(1)).thenReturn(true);
		
		MerchantOfferManager offerManager = new 
		MerchantOfferManager(repo, repoInfo);
		
		try {
			
			MerchantOffer offer =  offerManager.getMerchantOffer(moid);
			
			assertEquals(offer.getDescription(), "a product");
			assertEquals(offer.getName(), "product1");
			assertEquals(offer.getPrice(), Money.parse("USD 1.00"));
			assertEquals(offer.getMerchantOfferId(), moid);
			
		} catch (MerchantOfferManagerException e) {

			e.printStackTrace();
		}
	}
	
	public final void testGetMerchantOffers()
	{
		IMerchantOfferRepository repo = mock(IMerchantOfferRepository.class);
		IMerchantInfoRepository repoInfo = mock(IMerchantInfoRepository.class);
		
		MerchantOfferId moid = new MerchantOfferId(1, 2);
		
		LinkedList<MerchantOffer> offers = new LinkedList<MerchantOffer>();
		offers.add(new 
				MerchantOffer("product1", "a product", moid, Money.parse("USD 1.00")));
		offers.add(new 
				MerchantOffer("product2", "a product", moid, Money.parse("USD 2.00")));
		when(repo.getMerchantOffers(any())).thenReturn(offers);	
		
		when(repoInfo.getDoesMerchantExist(1)).thenReturn(true);
		
		MerchantOfferManager offerManager = new 
		MerchantOfferManager(repo, repoInfo);
		
		try {
			
			Collection<MerchantOffer> resultOffers =  offerManager.getMerchantOffers(1);
			
			assertEquals(resultOffers.size(), 2);
			
		} catch (MerchantOfferManagerException e) {

			e.printStackTrace();
		}
	}

}
