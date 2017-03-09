package marketplace.domain;


import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import org.joda.money.Money;
import java.io.IOException;

public class MoneySerialiser extends JsonSerializer<Money> {


	@Override
	public void serialize(Money value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
		jgen.writeStartObject();
		{
			jgen.writeStringField("amount", value.getAmount().toPlainString());
			jgen.writeStringField("currency", value.getCurrencyUnit().getCurrencyCode());
		}
		jgen.writeEndObject();
	}


}