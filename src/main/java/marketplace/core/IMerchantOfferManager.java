package marketplace.core;

import java.util.Collection;
import java.util.List;

import org.joda.money.Money;
import marketplace.domain.*;


public interface IMerchantOfferManager {
	
	public class MerchantOfferManagerException extends Exception	
	{
		public MerchantOfferManagerException(String message) {
			super(message);
		}		
	}
	
	public void createMerchantOffer(String name, String description, 
			Money price, int merchantId) throws MerchantOfferManagerException;
	public boolean removeMerchantOffer(int merchantId, int merchantOfferId) 
	throws MerchantOfferManagerException;
	public Collection<MerchantOffer> getMerchantOffers(int merchantId);
}
