package marketplace.core;

import java.util.Collection;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import marketplace.domain.Merchant;
import marketplace.domain.MerchantOffer;
import marketplace.domain.MerchantOfferId;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Merchant getMerchant(int merchantId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Merchant updateMerchant(int merchantId, String merchantName, String description) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Merchant deleteMerchant(int merchantId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MerchantOffer createMerchantOffer(int merchantId, String offerName, String offerDescription, String price,
			String currency) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<MerchantOffer> getMerchantOffers(int merchantId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MerchantOffer getMerchantOffer(MerchantOfferId offerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MerchantOffer updateMerchantOffer(MerchantOfferId offerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MerchantOffer deleteMerchantOffer(MerchantOfferId offerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getMerchantExists(int merchantId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getMerchantOfferExists(MerchantOfferId offerId) {
		// TODO Auto-generated method stub
		return false;
	}

	
	
	

}
