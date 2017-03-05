package marketplace.core;

import java.util.Collection;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import marketplace.domain.Merchant;
import marketplace.domain.MerchantOffer;

public class MarketPlace implements IMarketPlace {
	
	@Override
	public Merchant createMerchant(String merchantName, String description) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MerchantOffer createMerchantOffer(int merchantId, String offerName, String offerDescription, String price) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<MerchantOffer> getMerchantOffers(int merchantId) {
		// TODO Auto-generated method stub
		return null;
	}

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
	
	
	

}
