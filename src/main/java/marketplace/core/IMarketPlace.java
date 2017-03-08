package marketplace.core;

import java.util.Collection;

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
	 * updates the merchant with fields given
	 * @param merchantName if not null, will update merchant name
	 * @param description if not null, will update merchant description
	 * @return the merchant with updated fields, or null if merchant does not exist
	 */
	Merchant updateMerchant(int merchantId, String merchantName, String description);
	
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
	 * @param price
	 * @param currency 3 letter ISO currency code
	 * @return offer if created successfully, null if not
	 */
	MerchantOffer createMerchantOffer(int merchantId, String offerName, String offerDescription, String price, String currency);
	
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
	MerchantOffer updateMerchantOffer(MerchantOfferId offerId);
	
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
	
	/**
	 * @param offerId id of offer to check if exists
	 * @return true if merchant offer exists, false otherwise
	 */
	boolean getMerchantOfferExists(MerchantOfferId offerId);
}
