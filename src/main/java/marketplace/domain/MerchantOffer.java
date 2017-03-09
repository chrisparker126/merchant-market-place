package marketplace.domain;

import org.joda.money.Money;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import marketplace.domain.MoneyDeserialiser;
import marketplace.domain.MoneySerialiser;

public class MerchantOffer {
	
	public MerchantOffer()
	{
		
	}
	
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
	
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
		
	public String name;
	
	public String description;
	public MerchantOfferId merchantOfferId;
	
	@JsonDeserialize(using = MoneyDeserialiser.class)
	@JsonSerialize(using = MoneySerialiser.class)
	public Money price;


	public Money getPrice() {
		return price;
	}
	
}
