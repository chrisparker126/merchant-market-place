package marketplace.domain;

import java.io.IOException;

import marketplace.domain.exceptions.AlreadyExistException;
import marketplace.domain.exceptions.DoesNotExistException;

public class MerchantDb implements IMerchantRepository, IMerchantInfoRepository {

	@Override
	public boolean getDoesMerchantExist(int merchantId) throws IOException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addMerchant(Merchant merchant) throws IOException, AlreadyExistException {
		// TODO Auto-generated method stub

	}

	@Override
	public int getTopMerchantId() throws IOException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Merchant getMerchant(int merchantId) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Merchant deleteMerchant(int merchantId) throws IOException {
		return null;
	}

}
