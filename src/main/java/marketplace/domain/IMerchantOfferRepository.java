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
	 * @throws AlreadyExistException
	 * @throws IOException
	 */
	public void addMerchantOffer(MerchantOffer offer) throws AlreadyExistException, IOException;
	
	/**
	 * 
	 * @param merchantId
	 * @return
	 * @throws IOException
	 */
	public MerchantOfferId getTopMerhantOfferIdForMerchantId(int merchantId) throws IOException;
	
	/**
	 * retrieves a particular offer for a merchant
	 * @param offerId
	 * @return the offer requested, or null if the offer does not exist for merchant
	 * @throws IOException
	 */
	public MerchantOffer getMerchantOffer(MerchantOfferId offerId) throws IOException;
	
	/**
	 * retrieves offers a merchant has
	 * @param merchantId the id of the merchant whom to retrieve offers for
	 * @return
	 * @throws IOException
	 */
	public Collection<MerchantOffer> getMerchantOffers(int merchantId) throws IOException;
	
	/**
	 * 
	 * @param offerId
	 * @return null if offer did not exist, or value of offer that has been deleted
	 * @throws IOException
	 */
	public MerchantOffer removeMerchantOffer(MerchantOfferId offerId) throws IOException;
	
}
