package marketplace.domain;

public class Merchant {

	
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
	private final String name;
	private final int merchantId;
	private final String description;
	
}
