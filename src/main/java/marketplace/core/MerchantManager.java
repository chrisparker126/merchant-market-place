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
		try
		{
			synchronized (this) {			
				int newMerchantId = repository.getTopMerchantId() + 1;
				return repository.addMerchant(new Merchant(name, newMerchantId, description));
			}
						
		}catch(Exception e)
		{
			throw new MerchantManagerException(e.getMessage());
		}
	}

	@Override
	public Merchant deleteMerchant(int merchantId) throws MerchantManagerException {

		synchronized (this) {	
			return repository.deleteMerchant(merchantId);
		}
	}

	@Override
	public void changeMerchangeName(int merchantId, String name) throws MerchantManagerException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Merchant getMerchant(int merchantId) throws MerchantManagerException {

		synchronized (this) {
			return repository.getMerchant(merchantId);
		}
	}

}
