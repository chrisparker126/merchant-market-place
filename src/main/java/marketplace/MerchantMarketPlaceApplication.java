package marketplace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
 
@SpringBootApplication
@ImportResource("classpath:Beans.xml")
public class MerchantMarketPlaceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MerchantMarketPlaceApplication.class, args);
	}
}
