package marketplace.domain;

/**
 * This exist purely to provide information on merchants
 * to interested clients
 * and isolate ability to make changes to merchants 
 * @author Chris.Parker
 */
public interface IMerchantInfoRepository {
	Merchant getMerchant(int merchantId) ;
	boolean getDoesMerchantExist(int merchantId) ;
}
