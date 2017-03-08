package marketplace.domain;


import java.util.Collection;
import java.util.HashMap;
import java.util.SortedMap;
import java.util.TreeMap;


public class MerchantOfferDb implements IMerchantOfferRepository {

	@Override
	public Collection<MerchantOffer> getMerchantOffers(int merchantId) {

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
	public MerchantOffer removeMerchantOffer(MerchantOfferId offerId) {
		
		Integer mid = offerId.getMerchantId();
		Integer oid = offerId.getOfferId();
		
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
	public MerchantOffer addMerchantOffer(MerchantOffer offer)  {

		MerchantOfferId offerId = offer.getMerchantOfferId();
		Integer mid = offerId.getMerchantId();
		Integer oid = offerId.getOfferId();
		
		SortedMap<Integer, MerchantOffer> merchantOffers =  merchantOffersMap.get(mid);
		if(merchantOffers == null)
		{
			merchantOffers = new TreeMap<Integer, MerchantOffer>();
			merchantOffersMap.put(mid, merchantOffers);
			
		}
		
		merchantOffers.put(oid, offer);	
		return offer;
	}

	@Override
	public MerchantOfferId getTopMerhantOfferIdForMerchantId(int merchantId) {

		SortedMap<Integer, MerchantOffer> merchantOffers =  merchantOffersMap.get(merchantId);
		if(merchantOffers == null)
		{
			return new MerchantOfferId(merchantId, 1);
			
		}else
		{
			return new MerchantOfferId(merchantId, merchantOffers.lastKey()); 
		}			
	}

	@Override
	public MerchantOffer getMerchantOffer(MerchantOfferId offerId) {
		
		Integer mid = offerId.getMerchantId();
		Integer oid = offerId.getOfferId();
		
		SortedMap<Integer, MerchantOffer> merchantOffers =  merchantOffersMap.get(mid);
		if(merchantOffers == null)
		{
			return null;
			
		}else
		{
			return merchantOffers.get(oid);
		}		
	}
	
	private HashMap<Integer, SortedMap<Integer, MerchantOffer> > merchantOffersMap = new
			HashMap<Integer, SortedMap<Integer, MerchantOffer> >();
	
}
