package marketplace.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import marketplace.core.IMarketPlace;
import marketplace.domain.Merchant;


@RestController
public class MarketPlaceController {

	public MarketPlaceController(IMarketPlace marketPlace) {
		super();
		this.marketPlace = marketPlace;
	}

	@RequestMapping(value="/create_merchant", method=RequestMethod.POST)
	public Merchant createMerchant(
			@RequestParam(value="name", defaultValue="") String name,
			@RequestParam(value="description", defaultValue="") String description)
	{		
        return marketPlace.createMerchant(name, description);
	}

	@Autowired
	private IMarketPlace marketPlace;
}
