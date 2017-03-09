package marketplace.domain;

public interface IMerchantRepository {

	public Merchant addMerchant(Merchant merchant) ;
	public int getTopMerchantId() ;
	public Merchant getMerchant(int merchantId) ;
	public Merchant deleteMerchant(int merchantId) ;	
	public boolean getMerchantExists(int merchantId);
}
