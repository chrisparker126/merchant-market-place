package marketplace.domain;

public class Merchant {

	public Merchant()
	{
		
	}
	
	public Merchant(String name, Integer merchantId, String description) {		
		this.name = name;
		this.merchantId = merchantId;
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public int getMerchantId() {
		return merchantId;
	}
	public String getDescription() {
		return description;
	}
	public String name;
	public Integer merchantId;
	public String description;
	
}
