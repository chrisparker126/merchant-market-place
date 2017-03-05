package marketplace.core;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



import marketplace.domain.Merchant;


@RestController
public class MarketPlaceController {

	@RequestMapping(value="/create_merchant", method=RequestMethod.POST)
	public Merchant createMerchant(@RequestParam(value="name", defaultValue="World") String name)
	{
        return new Merchant(name, 1, "I sell poo");
	}

}
