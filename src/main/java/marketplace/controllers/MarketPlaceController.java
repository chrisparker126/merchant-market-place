package marketplace.controllers;

import java.util.Collection;
import java.util.LinkedList;

import org.joda.money.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import marketplace.core.IMarketPlace;
import marketplace.domain.Merchant;
import marketplace.domain.MerchantOffer;
import marketplace.domain.MerchantOfferId;


@RestController
public class MarketPlaceController {

	 @ResponseStatus(value=HttpStatus.NOT_FOUND)  // 404
	 public class MerchantOrOfferNotFoundException extends RuntimeException {
		 private static final long serialVersionUID = 1L;
	 }

	 @ResponseStatus(value=HttpStatus.BAD_REQUEST)  // 400
	 public class InvalidParameters extends RuntimeException {

		public InvalidParameters(String message) {
			super(message);
			
		}
		private static final long serialVersionUID = 1L;
	 }

	 
	public MarketPlaceController(IMarketPlace marketPlace) {
		super();
		this.marketPlace = marketPlace;
	}

	@RequestMapping(value="/merchant", method=RequestMethod.POST)
	public Merchant createMerchant(
			@RequestParam(value="name", defaultValue="") String name,
			@RequestParam(value="description", defaultValue="") String description)
	{	
		if(name.isEmpty())
		{
			throw new InvalidParameters("Invalid parameter, merchant name must be non empty");
		}
		else
			return marketPlace.createMerchant(name, description);
		
	}
	
	@RequestMapping(value="/merchant/{id}", method=RequestMethod.GET)
	public Merchant getMerchant(
			 @PathVariable int id)
	{	
		Merchant merchant = marketPlace.getMerchant(id);
		
		if(merchant == null)
			throw new MerchantOrOfferNotFoundException();
        return merchant;
	}
	
	@RequestMapping(value="/merchant/{mid}", method=RequestMethod.PUT)
	public Merchant updateMerchant(
			 @PathVariable int mid)
	{	
		return null;
	}

	@RequestMapping(value="/merchant/{mid}", method=RequestMethod.DELETE)
	public Merchant deleteMerchant(
			 @PathVariable int mid)
	{	
		return marketPlace.deleteMerchant(mid);		
	}
	
	@RequestMapping(value="/merchant/{id}/offers", method=RequestMethod.GET)
	public Collection<MerchantOffer> offers(
			 @PathVariable int id)
	{	
		Collection<MerchantOffer> offers = marketPlace.getMerchantOffers(id);
		
		if(offers != null)
			throw new MerchantOrOfferNotFoundException();
		else
		{
			offers = new LinkedList<MerchantOffer>();
			offers.add(new MerchantOffer("Product1", "description", new 
					MerchantOfferId(1, 2), Money.parse("USD 23.87")));
			return offers;
		}
	}
	
	@RequestMapping(value="/merchant/{mid}/offer/{oid}", method=RequestMethod.GET)
	public MerchantOffer offer(
			 @PathVariable int mid, @PathVariable int oid)
	{	
		MerchantOffer offer = marketPlace.getMerchantOffer(new MerchantOfferId(mid, oid));
		
		if(offer == null)
			throw new MerchantOrOfferNotFoundException();

		return offer;
	}
	
	@RequestMapping(value="/merchant/{mid}/offer", method=RequestMethod.POST)
	public MerchantOffer createOffer(
			 @PathVariable int mid, 
				@RequestParam(value="name", defaultValue="") String name,
				@RequestParam(value="description", defaultValue="") String description,
				@RequestParam(value="price", defaultValue="") String price,
				@RequestParam(value="curency", defaultValue="") String currency)
	{	
		
		MerchantOffer offer = marketPlace.createMerchantOffer(mid, name, description, price, currency);

		return offer;
	}
	
	@RequestMapping(value="/merchant/{mid}/offer", method=RequestMethod.PUT)
	public MerchantOffer updateOffer(
			 @PathVariable int mid, @PathVariable int oid,
				@RequestParam(value="name", defaultValue="") String name,
				@RequestParam(value="description", defaultValue="") String description,
				@RequestParam(value="price", defaultValue="") String price,
				@RequestParam(value="curency", defaultValue="") String currency)
	{	
		MerchantOffer offer = marketPlace.getMerchantOffer(new MerchantOfferId(mid, oid));
		
		if(offer == null)
			throw new MerchantOrOfferNotFoundException();

		return offer;
	}
	
	@Autowired
	private IMarketPlace marketPlace;
}
