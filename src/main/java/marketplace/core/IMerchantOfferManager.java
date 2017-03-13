package marketplace.core;

import java.util.Collection;

import org.joda.money.Money;
import marketplace.domain.*;
import marketplace.domain.exceptions.MerchantOfferManagerException;


public interface IMerchantOfferManager {
	
	public MerchantOffer createMerchantOffer(String name, String description, 
			Money price, Integer merchantId) throws MerchantOfferManagerException;
	public MerchantOffer removeMerchantOffer(MerchantOfferId merchantOfferId) 
	throws MerchantOfferManagerException;
	public Collection<MerchantOffer> getMerchantOffers(Integer merchantId)
			throws MerchantOfferManagerException;;
	public MerchantOffer getMerchantOffer(MerchantOfferId merchantOfferId)
					throws MerchantOfferManagerException;
	public MerchantOffer updateMerchantOffer(MerchantOffer offer)
			throws MerchantOfferManagerException;
}
