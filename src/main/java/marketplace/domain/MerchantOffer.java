package marketplace.domain;

import org.joda.money.Money;

public class MerchantOffer {
	
	enum OfferType { Goods, Services }
	
	public MerchantOffer(String name, String description, int merchantId, int merchantOffId, Money price) {		
		this.name = name;
		this.description = description;
		this.merchantId = merchantId;
		this.merchantOffId = merchantOffId;
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	public int getMerchantId() {
		return merchantId;
	}
	public int getMerchantOffId() {
		return merchantOffId;
	}
	public Money getPrice() {
		return price;
	}
	private final String name;
	private final String description;
	private final int merchantId;
	private final int merchantOffId;
	private final Money price;
	
}
