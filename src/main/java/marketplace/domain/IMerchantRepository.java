package marketplace.domain;

public interface IMerchantRepository {

	public Merchant addMerchant(Merchant merchant) ;
	public Integer getTopMerchantId() ;
	public Merchant getMerchant(Integer merchantId) ;
	public Merchant deleteMerchant(Integer merchantId) ;	
	public boolean getMerchantExists(Integer merchantId);
}
