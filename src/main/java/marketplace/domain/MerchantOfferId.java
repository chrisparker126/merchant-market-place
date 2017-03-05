package marketplace.domain;

public class MerchantOfferId
{
	public MerchantOfferId(int merchantId, int merchantOfferId) {
		super();
		this.merchantId = merchantId;
		this.merchantOfferId = merchantOfferId;
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	public int getMerchantId() {
		return merchantId;
	}
	public int getMerchantOfferId() {
		return merchantOfferId;
	}
	private int merchantId;
	private int merchantOfferId;
}