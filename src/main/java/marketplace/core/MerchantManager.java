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
	public int createMerchant(String name, String description) throws MerchantManagerException {		
		try
		{
			int newMerchantId = repository.getTopMerchantId() + 1;
			repository.addMerchant(new Merchant(name, newMerchantId, description));
			return newMerchantId;
		}catch(Exception e)
		{
			throw new MerchantManagerException(e.getMessage());
		}
	}

	@Override
	public void deleteMerchant(int merchantId) throws MerchantManagerException {

		
	}

	@Override
	public void changeMerchangeName(int merchantId, String name) throws MerchantManagerException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Merchant getMerchant(int merchantId) throws MerchantManagerException {

		try{
			return repository.getMerchant(merchantId);
		}
		catch(IOException e)
		{
			logger.error(e);
			throw new MerchantManagerException(e.getMessage());
		}
	}

}
