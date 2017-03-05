package marketplace.domain;

import java.io.IOException;


public interface IMerchantInfoRepository {
	Merchant getMerchant(int merchantId) throws IOException;
	boolean getDoesMerchantExist(int merchantId) throws IOException;
}
