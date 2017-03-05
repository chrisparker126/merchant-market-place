package marketplace.domain;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import marketplace.domain.exceptions.AlreadyExistException;

public class MerchantOfferDb implements IMerchantOfferRepository {

	@Override
	public Collection<MerchantOffer> getMerchantOffers(int merchantId) throws IOException {

		SortedMap<Integer, MerchantOffer> merchantOffers =  merchantOffersMap.get(merchantId);
		if(merchantOffers == null)
		{
			return null;
			
		}else
		{
			return merchantOffers.values();
		}			
	}

	@Override
	public MerchantOffer removeMerchantOffer(MerchantOfferId offerId) throws IOException {
		
		Integer mid = offerId.getMerchantId();
		Integer oid = offerId.getMerchantOfferId();
		
		SortedMap<Integer, MerchantOffer> merchantOffers =  merchantOffersMap.get(mid);
		if(merchantOffers == null)
		{
			return null;
			
		}else
		{
			return merchantOffers.remove(oid);
		}
	}

	@Override
	public void addMerchantOffer(MerchantOffer offer) throws AlreadyExistException, IOException {

		MerchantOfferId offerId = offer.getMerchantOfferId();
		Integer mid = offerId.getMerchantId();
		Integer oid = offerId.getMerchantOfferId();
		
		SortedMap<Integer, MerchantOffer> merchantOffers =  merchantOffersMap.get(mid);
		if(merchantOffers == null)
		{
			merchantOffers = new TreeMap<Integer, MerchantOffer>();
			merchantOffersMap.put(mid, merchantOffers);
			
		}else
		{
			if(merchantOffers.containsKey(oid))
				throw new AlreadyExistException("Offer exists already for Id: " +   offer.getMerchantOfferId());
		}
		
		merchantOffers.put(mid, offer);		
	}

	@Override
	public MerchantOfferId getTopMerhantOfferIdForMerchantId(int merchantId) throws IOException {

		SortedMap<Integer, MerchantOffer> merchantOffers =  merchantOffersMap.get(merchantId);
		if(merchantOffers == null)
		{
			return new MerchantOfferId(merchantId, 1);
			
		}else
		{
			return new MerchantOfferId(merchantId, merchantOffers.lastKey()+1); 
		}			
	}

	@Override
	public MerchantOffer getMerchantOffer(MerchantOfferId offerId) throws IOException {
		
		Integer mid = offerId.getMerchantId();
		Integer oid = offerId.getMerchantOfferId();
		
		SortedMap<Integer, MerchantOffer> merchantOffers =  merchantOffersMap.get(mid);
		if(merchantOffers == null)
		{
			return null;
			
		}else
		{
			return merchantOffers.get(oid);
		}		
	}
	
	private HashMap<Integer, SortedMap<Integer, MerchantOffer> > merchantOffersMap;
	
}
