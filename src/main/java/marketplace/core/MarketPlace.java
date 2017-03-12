package marketplace.core;

import java.util.Collection;

import org.apache.log4j.Logger;
import org.joda.money.Money;
import org.springframework.beans.factory.annotation.Autowired;

import marketplace.core.IMerchantManager.MerchantManagerException;
import marketplace.core.IMerchantOfferManager.MerchantOfferManagerException;
import marketplace.domain.Merchant;
import marketplace.domain.MerchantOffer;
import marketplace.domain.MerchantOfferId;

/**
 * Thread safe implementation of market place interface
 * @author Chris.Parker
 *
 */
public class MarketPlace implements IMarketPlace {

	public MarketPlace(IMerchantManager merchantManager, IMerchantOfferManager merchantOfferManager) {
		super();
		this.merchantManager = merchantManager;
		this.merchantOfferManager = merchantOfferManager;
	}

	Logger logger = Logger.getLogger(MarketPlace.class);
	
	@Autowired
	private IMerchantManager merchantManager;
	
	@Autowired
	private IMerchantOfferManager merchantOfferManager;

	@Override
	public Merchant createMerchant(String merchantName, String description) {
		try {

			synchronized (this) {
				return merchantManager.createMerchant(merchantName, description);
			}
		} catch (MerchantManagerException e) {
			logger.error(e);
		}
		return null;
	}

	@Override
	public Merchant getMerchant(Integer merchantId) {
		try {
			synchronized (this) {
				return merchantManager.getMerchant(merchantId);
			}
		} catch (MerchantManagerException e) {
			logger.error(e);
		}
		return null;
	}

	@Override
	public Merchant deleteMerchant(Integer merchantId) {
		
		try {
			synchronized (this) {
				return merchantManager.deleteMerchant(merchantId);
			}
		} catch (MerchantManagerException e) {
			logger.error(e);
		}
		
		return null;
	}

	@Override
	public MerchantOffer createMerchantOffer(Integer merchantId, String offerName, String offerDescription, Money price) {
	
		try {
			synchronized (this) {
				return merchantOfferManager.createMerchantOffer(offerName, offerDescription, price, merchantId);
			}
		} catch (MerchantOfferManagerException e) {
			logger.error(e);
		}
		return null;
	}

	@Override
	public Collection<MerchantOffer> getMerchantOffers(Integer merchantId) {
		try {
			synchronized (this) {
				return merchantOfferManager.getMerchantOffers(merchantId);
			}
		} catch (MerchantOfferManagerException e) {
			logger.error(e);
		}
		return null;
	}

	@Override
	public MerchantOffer getMerchantOffer(MerchantOfferId offerId) {
		try {
			synchronized (this) {
				return merchantOfferManager.getMerchantOffer(offerId);
			}
		} catch (MerchantOfferManagerException e) {
			logger.error(e);
		}
		return null;
	}

	@Override
	public MerchantOffer updateMerchantOffer(MerchantOffer offer) {

		try {
			synchronized (this) {
				return merchantOfferManager.updateMerchantOffer(offer);
			}
		} catch (MerchantOfferManagerException e) {
			logger.error(e);
		} 
		
		return null;
	}

	@Override
	public MerchantOffer deleteMerchantOffer(MerchantOfferId offerId) {

		try {
			synchronized (this) {
				return merchantOfferManager.removeMerchantOffer(offerId);
			}
		} catch (MerchantOfferManagerException e) {
			logger.error(e);
		}
		return null;
	}

	@Override
	public boolean getMerchantExists(Integer merchantId) {
		synchronized (this) {
			return merchantManager.getMerchantExists(merchantId);
		}
	}	

}
