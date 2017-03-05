package marketplace.domain;

import java.io.IOException;

public interface IMarketPlaceRepository {
	void insertMerchant(Merchant merchant) throws IOException;
	int getTopMerchantId() throws IOException;
}
