package marketplace.core;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import marketplace.domain.IMarketPlaceRepository;
import marketplace.domain.Merchant;

public class MerchantManager implements IMerchantManager {

	public MerchantManager(IMarketPlaceRepository repository) {
		super();
		this.repository = repository;
	}

	@Autowired
	private IMarketPlaceRepository repository = null;
			
	@Override
	public int createMerchant(String name, String description) throws MerchantManagerException {		
		try
		{
			int newMerchantId = repository.getTopMerchantId() + 1;
			repository.insertMerchant(new Merchant(name, newMerchantId, description));
			return newMerchantId;
		}catch(IOException e)
		{
			throw new MerchantManagerException(e.getMessage());
		}
	}

	@Override
	public boolean deleteMerchant(int merchantId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean changeMerchangeName(int merchantId, String name) {
		// TODO Auto-generated method stub
		return false;
	}

}
