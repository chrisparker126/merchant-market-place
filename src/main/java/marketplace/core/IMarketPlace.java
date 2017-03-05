package marketplace.core;

import java.util.Collection;

import org.joda.money.Money;

import marketplace.domain.Merchant;
import marketplace.domain.MerchantOffer;

public interface IMarketPlace {
	
	/**
	 * 
	 * @param merchantName
	 * @param description
	 * @return
	 */
	Merchant createMerchant(String merchantName, String description);
	
	/**
	 * 
	 * @param merchantId
	 * @param offerName
	 * @param offerDescription
	 * @param price
	 * @return
	 */
	MerchantOffer createMerchantOffer(int merchantId, String offerName, String offerDescription, String price);
	
	/**
	 * 
	 * @param merchantId
	 * @return
	 */
	Collection<MerchantOffer> getMerchantOffers(int merchantId);
}
