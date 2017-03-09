package marketplace.core;

import java.util.Collection;

import org.joda.money.Money;

import marketplace.domain.Merchant;
import marketplace.domain.MerchantOffer;
import marketplace.domain.MerchantOfferId;

public interface IMarketPlace {
	
	/**
	 * creates a merchant with name and description
	 * @param merchantName
	 * @param description
	 * @return merchants created with id assigned
	 */
	Merchant createMerchant(String merchantName, String description);

	/**
	 * gets the merchant of the given merchant id
	 * @param merchantId id of merchant to get
	 * @return merchant or null if merchant does not exist
	 */
	Merchant getMerchant(int merchantId);
	
	/**
	 * 
	 * @param merchantName
	 * @param description
	 * @return the deleted merchant or null if merchant does not exist
	 */
	Merchant deleteMerchant(int merchantId);
	
	/**
	 * 
	 * @param merchantId id of merchant to create offer for
	 * @param offerName name of offer
	 * @param offerDescription offer description
	 * @param price TODO
	 * @return offer if created successfully, null if not
	 */
	MerchantOffer createMerchantOffer(int merchantId, String offerName, String offerDescription, Money price);
	
	/**
	 * get all the offers for a merchant
	 * @param merchantId
	 * @return merchants' offers or null if merchant does not exist or merchant has not offers
	 */
	Collection<MerchantOffer> getMerchantOffers(int merchantId);
	

	/**
	 * @param offerId
	 * @return
	 */
	MerchantOffer getMerchantOffer(MerchantOfferId offerId);
	
	/**
	 * 
	 * @param offerId
	 * @return
	 */
	MerchantOffer updateMerchantOffer(MerchantOffer offer);
	
	/**
	 * 
	 * @param offerId
	 * @return
	 */
	MerchantOffer deleteMerchantOffer(MerchantOfferId offerId);
	
	/**
	 * @param merchantId id of merchant to check if exists
	 * @return true if merchant exists, false otherwise
	 */
	boolean getMerchantExists(int merchantId);	
}
