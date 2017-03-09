package marketplace.domain;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import java.io.IOException;

public class MoneyDeserialiser extends JsonDeserializer<Money> {

	@Override
	public Money deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
		JsonNode moneyTree = jp.readValueAsTree();

		String amount = moneyTree.get("amount").asText();

		JsonNode currencyNode = moneyTree.get("currency");
		CurrencyUnit currency = CurrencyUnit.of(currencyNode.asText());

		return Money.parse(currency + " " + amount);
	}
}