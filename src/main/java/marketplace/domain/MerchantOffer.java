package marketplace.domain;

import org.joda.money.Money;

public class MerchantOffer {
	
	public MerchantOfferId getMerchantOfferId() {
		return merchantOfferId;
	}
	public MerchantOffer(String name, String description, MerchantOfferId merchantOfferId, Money price) {
		super();
		this.name = name;
		this.description = description;
		this.merchantOfferId = merchantOfferId;
		this.price = price;
	}
	
	enum OfferType { Goods, Services }
	
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	public Money getPrice() {
		return price;
	}
	
	private final String name;
	private final String description;
	private final MerchantOfferId merchantOfferId;
	private final Money price;
	
}
