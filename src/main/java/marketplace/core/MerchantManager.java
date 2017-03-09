package marketplace.core;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import marketplace.domain.IMerchantRepository;
import marketplace.domain.Merchant;

public class MerchantManager implements IMerchantManager {

	private Logger logger = Logger.getLogger(MarketPlace.class);
	
	public MerchantManager(IMerchantRepository repository) {
		super();
		this.repository = repository;
	}

	@Autowired
	private IMerchantRepository repository = null;
			
	@Override
	public Merchant createMerchant(String name, String description) throws MerchantManagerException {
		
		logger.info("Creating merchant with name: " + name);
		
		try
		{
			synchronized (this) {			
				int newMerchantId = repository.getTopMerchantId() + 1;
				Merchant m = new Merchant(name, newMerchantId, description);
				repository.addMerchant(m);
				return m;
			}
						
		}catch(Exception e)
		{
			throw new MerchantManagerException(e.getMessage());
		}
	}

	@Override
	public Merchant deleteMerchant(int merchantId) throws MerchantManagerException {

		logger.info("Deleting merchant with Id: " + merchantId);
		
		synchronized (this) {	
			return repository.deleteMerchant(merchantId);
		}
	}


	@Override
	public Merchant getMerchant(int merchantId) throws MerchantManagerException {

		logger.info("Retrieving merchant with Id: " + merchantId);
		
		synchronized (this) {
			return repository.getMerchant(merchantId);
		}
	}

	@Override
	public boolean getMerchantExists(int merchantId) {
		synchronized (this) {
			return repository.getMerchantExists(merchantId);
		}
		
	}

}
