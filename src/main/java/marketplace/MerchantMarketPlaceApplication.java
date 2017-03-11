package marketplace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.ActiveProfiles;

@SpringBootApplication
@ImportResource("classpath:Beans.xml")
@ActiveProfiles(profiles="production")
public class MerchantMarketPlaceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MerchantMarketPlaceApplication.class, args);
	}
}
