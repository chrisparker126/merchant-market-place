package marketplace.core;

import static org.junit.Assert.*;

import org.junit.Test;

import marketplace.domain.IMerchantInfoRepository;
import marketplace.domain.IMerchantOfferRepository;
import marketplace.domain.IMerchantRepository;
import marketplace.domain.MerchantOffer;
import marketplace.domain.MerchantOfferId;
import marketplace.domain.exceptions.MerchantOfferManagerException;

import static org.mockito.Mockito.*;

import java.util.Collection;
import java.util.LinkedList;

import org.joda.money.Money;


public class MerchantOfferManagerTests {

	@Test
	public final void testCreateMerchantOffer() throws MerchantOfferManagerException {
		
		IMerchantOfferRepository repo = mock(IMerchantOfferRepository.class);
		IMerchantInfoRepository repoInfo = mock(IMerchantInfoRepository.class);
		
		MerchantOfferId moid = new MerchantOfferId(1, 2);
		when(repo.addMerchantOffer(any())).thenReturn(new 
				MerchantOffer("product1", "a product", moid, Money.parse("USD 1.00")));	
		
		when(repoInfo.getDoesMerchantExist(1)).thenReturn(true);
		when(repo.getTopMerhantOfferIdForMerchantId(1)).thenReturn(moid);
		
		MerchantOfferManager offerManager = new 
		MerchantOfferManager(repo, repoInfo);
			
		MerchantOffer offer =  offerManager.createMerchantOffer("product1", "a product", Money.parse("USD 1.00"), 1);
		
		assertEquals(offer.getDescription(), "a product");
		assertEquals(offer.getName(), "product1");
		assertEquals(offer.price, Money.parse("USD 1.00"));
		assertEquals(offer.getMerchantOfferId(), moid);
		

	}

	@Test
	public final void testRemoveMerchantOffer() throws MerchantOfferManagerException {
		
		IMerchantOfferRepository repo = mock(IMerchantOfferRepository.class);
		IMerchantInfoRepository repoInfo = mock(IMerchantInfoRepository.class);
		
		MerchantOfferId moid = new MerchantOfferId(1, 2);
		when(repo.removeMerchantOffer(any())).thenReturn(new 
				MerchantOffer("product1", "a product", moid, Money.parse("USD 1.00")),
				(MerchantOffer) null);	
		
		when(repoInfo.getDoesMerchantExist(1)).thenReturn(true);
		
		MerchantOfferManager offerManager = new 
		MerchantOfferManager(repo, repoInfo);
			
		MerchantOffer offer =  offerManager.removeMerchantOffer(moid);
		
		assertEquals(offer.getDescription(), "a product");
		assertEquals(offer.getName(), "product1");
		assertEquals(offer.price, Money.parse("USD 1.00"));
		assertEquals(offer.getMerchantOfferId(), moid);
		
		MerchantOffer offerNull =  offerManager.removeMerchantOffer(moid);
		
		assertNull(offerNull);
			

	}

	@Test
	public final void testGetMerchantOffer() throws MerchantOfferManagerException {
		
		IMerchantOfferRepository repo = mock(IMerchantOfferRepository.class);
		IMerchantInfoRepository repoInfo = mock(IMerchantInfoRepository.class);
		
		MerchantOfferId moid = new MerchantOfferId(1, 2);
		when(repo.getMerchantOffer(any())).thenReturn(new 
				MerchantOffer("product1", "a product", moid, Money.parse("USD 1.00")));	
		
		when(repoInfo.getDoesMerchantExist(1)).thenReturn(true);
		
		MerchantOfferManager offerManager = new 
		MerchantOfferManager(repo, repoInfo);
			
		MerchantOffer offer =  offerManager.getMerchantOffer(moid);
		
		assertEquals(offer.getDescription(), "a product");
		assertEquals(offer.getName(), "product1");
		assertEquals(offer.price, Money.parse("USD 1.00"));
		assertEquals(offer.getMerchantOfferId(), moid);

	}
	
	public final void testGetMerchantOffers() throws MerchantOfferManagerException
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

			Collection<MerchantOffer> resultOffers =  offerManager.getMerchantOffers(1);
			
			assertEquals(resultOffers.size(), 2);
			

	}

}
