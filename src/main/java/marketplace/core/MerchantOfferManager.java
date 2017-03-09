package marketplace.core;

import java.util.Collection;
import org.joda.money.Money;
import org.springframework.beans.factory.annotation.Autowired;

import marketplace.domain.IMerchantInfoRepository;
import marketplace.domain.IMerchantOfferRepository;
import marketplace.domain.MerchantOffer;
import marketplace.domain.MerchantOfferId;

public class MerchantOfferManager implements IMerchantOfferManager {

	@Autowired
	IMerchantOfferRepository repository = null;
	
	@Autowired
	IMerchantInfoRepository merchantInfoRepo = null;
	
	@Override
	public MerchantOffer getMerchantOffer(MerchantOfferId offerId) throws MerchantOfferManagerException {
		synchronized (this) {
			return repository.getMerchantOffer(offerId);
		}		
	}

	public MerchantOfferManager(IMerchantOfferRepository repository, IMerchantInfoRepository infoRepo) {
		super();
		this.repository = repository;
		this.merchantInfoRepo = infoRepo;
	}
	
	@Override
	public MerchantOffer createMerchantOffer(String name, String description, Money price, int merchantId)
			throws MerchantOfferManagerException {
	
		// first check merchant exists
		
		synchronized (this) {
			
			try {
				if(merchantInfoRepo.getDoesMerchantExist(merchantId))
				{
					MerchantOfferId moid = repository.getTopMerhantOfferIdForMerchantId(merchantId);
					return repository.addMerchantOffer(new MerchantOffer(name, description, 
							new MerchantOfferId(merchantId,
									moid.getOfferId()+1)
							, price));
				}
				else
					return null;
			} catch (Exception e) {
			
				throw new MerchantOfferManagerException(e.getMessage());
			}
		}
	}

	@Override
	public MerchantOffer removeMerchantOffer(MerchantOfferId merchantOfferId) throws MerchantOfferManagerException {

		synchronized (this) {
			return repository.removeMerchantOffer(merchantOfferId);	
		}
		
		
	}

	@Override
	public Collection<MerchantOffer> getMerchantOffers(int merchantId) 
			throws MerchantOfferManagerException
	{
		synchronized (this) {
			return repository.getMerchantOffers(merchantId);	
		}
				
	}

	@Override
	public MerchantOffer updateMerchantOffer(MerchantOffer offer) throws MerchantOfferManagerException {
		
		synchronized (this) {
			return repository.updateMerchantOffer(offer);
		}
		
	}

}
