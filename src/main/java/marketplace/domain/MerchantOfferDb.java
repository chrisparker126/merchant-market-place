package marketplace.domain;


import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.SortedMap;
import java.util.TreeMap;


public class MerchantOfferDb implements IMerchantOfferRepository {


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
	public MerchantOfferId getTopMerhantOfferIdForMerchantId(Integer merchantId) {

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

	@Override
	public MerchantOffer updateMerchantOffer(MerchantOffer offer) {
	
		MerchantOffer currentOffer = getMerchantOffer(offer.getMerchantOfferId());
		
		if(currentOffer == null)
			return null;
		
		if(offer.name == null)
			offer.name = currentOffer.name;
		
		if(offer.description == null)
			offer.description = currentOffer.description;
		
		if(offer.price == null)
			offer.price = currentOffer.price;
		
		SortedMap<Integer, MerchantOffer> merchantOffers = 
				merchantOffersMap.get(offer.getMerchantOfferId().getMerchantId());
		
		merchantOffers.put(offer.getMerchantOfferId().getOfferId(), 
				offer);
		return offer;
	}

	@Override
	public Collection<MerchantOffer> getMerchantOffers(Integer merchantId) {

		SortedMap<Integer, MerchantOffer> merchantOffers =  merchantOffersMap.get(merchantId);
		if(merchantOffers == null)
		{
			return new LinkedList<MerchantOffer>();
			
		}else
		{
			return merchantOffers.values();
		}			
	}
	
	private HashMap<Integer, SortedMap<Integer, MerchantOffer> > merchantOffersMap = new
			HashMap<Integer, SortedMap<Integer, MerchantOffer> >();




	
}
