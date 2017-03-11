package marketplace.domain;

public class MerchantOfferId
{
	public MerchantOfferId(){}
	public MerchantOfferId(Integer merchantId, Integer offerId) {
		super();
		this.merchantId = merchantId;
		this.offerId = offerId;
	}
	@Override
	public boolean equals(Object obj) {
		MerchantOfferId moid = (MerchantOfferId) obj;
		return moid.getMerchantId() == this.merchantId
				&& moid.getOfferId() == this.offerId;
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	
	public Integer getMerchantId() {
		return merchantId;
	}
	public Integer getOfferId() {
		return offerId;
	}
	public Integer merchantId;
	public Integer offerId;
}