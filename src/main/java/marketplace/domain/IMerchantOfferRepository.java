package marketplace.domain;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import marketplace.domain.exceptions.*;

/**
 * Do not assume implementations are thread safe
 * @author Chris.Parker
 *
 */
public interface IMerchantOfferRepository {
	
	/**
	 * Adds an offer for a merchant 
	 * @param offer the merchant id and offer id should be unique
	 * @return the offer that has been added
	 */
	public MerchantOffer addMerchantOffer(MerchantOffer offer) ;
	
	/**
	 * 
	 * @param merchantId
	 * @return
	 * @throws IOException
	 */
	public MerchantOfferId getTopMerhantOfferIdForMerchantId(Integer merchantOfferId) ;
	
	/**
	 * retrieves a particular offer for a merchant
	 * @param offerId
	 * @return the offer requested, or null if the offer does not exist for merchant
	 * @throws IOException
	 */
	public MerchantOffer getMerchantOffer(MerchantOfferId offerId);
	
	/**
	 * retrieves offers a merchant has
	 * @param merchantId the id of the merchant whom to retrieve offers for
	 * @return if not offers exist, returns an empty collection
	 */
	public Collection<MerchantOffer> getMerchantOffers(Integer merchantId) ;
	
	/**
	 * 
	 * @param offerId
	 * @return null if offer did not exist, or value of offer that has been deleted
	 */
	public MerchantOffer removeMerchantOffer(MerchantOfferId offerId) ;
	
	/**
	 * 
	 * @param offer
	 * @return
	 */
	public MerchantOffer updateMerchantOffer(MerchantOffer offer);
}
