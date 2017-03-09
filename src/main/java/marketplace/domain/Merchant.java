package marketplace.domain;

public class Merchant {

	public Merchant()
	{
		
	}
	
	public Merchant(String name, int merchantId, String description) {		
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
	public int merchantId;
	public String description;
	
}
