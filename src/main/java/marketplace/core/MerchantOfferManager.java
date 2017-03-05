package marketplace.core;

import java.util.Collection;
import java.util.List;

import org.joda.money.Money;
import org.springframework.beans.factory.annotation.Autowired;

import marketplace.domain.IMerchantInfoRepository;
import marketplace.domain.IMerchantOfferRepository;
import marketplace.domain.IMerchantRepository;
import marketplace.domain.MerchantOffer;

public class MerchantOfferManager implements IMerchantOfferManager {

	public MerchantOfferManager(IMerchantOfferRepository repository, IMerchantInfoRepository infoRepo) {
		super();
		this.repository = repository;
		this.merchantInfoRepo = infoRepo;
	}

	@Autowired
	IMerchantOfferRepository repository = null;
	
	@Autowired
	IMerchantInfoRepository merchantInfoRepo = null;
	
	
	
	@Override
	public void createMerchantOffer(String name, String description, Money price, int merchantId)
			throws MerchantOfferManagerException {
	
		// first check merchant exists 
		
	}

	@Override
	public boolean removeMerchantOffer(int merchantId, int merchantOfferId) throws MerchantOfferManagerException {

		return false;
	}

	@Override
	public Collection<MerchantOffer> getMerchantOffers(int merchantId) {
		// TODO Auto-generated method stub
		return null;
	}

}
