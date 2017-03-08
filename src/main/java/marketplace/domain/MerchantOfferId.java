package marketplace.domain;

public class MerchantOfferId
{
	public MerchantOfferId(int merchantId, int offerId) {
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
	
	public int getMerchantId() {
		return merchantId;
	}
	public int getOfferId() {
		return offerId;
	}
	private int merchantId;
	private int offerId;
}