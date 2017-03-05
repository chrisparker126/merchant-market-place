package marketplace.domain;

import java.io.IOException;
import marketplace.domain.exceptions.*;

public interface IMerchantRepository {

	public void addMerchant(Merchant merchant) throws IOException, AlreadyExistException;
	public int getTopMerchantId() throws IOException;
	public Merchant getMerchant(int merchantId) throws IOException;
	public Merchant deleteMerchant(int merchantId) throws IOException;
	
}
