package marketplace.controllers;


import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import marketplace.core.IMarketPlace;
import marketplace.domain.Merchant;
import marketplace.domain.MerchantOffer;
import marketplace.domain.MerchantOfferId;


@RestController
public class MarketPlaceController {

	class Error
	{
		public Error(){}
		public String error = "Failed";
		public Integer error_code = 1;
	}
	 @ResponseStatus(value=HttpStatus.NOT_FOUND)  // 404
	 public class MerchantOrOfferNotFoundException extends RuntimeException {
		 
		private static final long serialVersionUID = 1L;
			public MerchantOrOfferNotFoundException(String message) {
				super(message);
			}
			
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

	@RequestMapping(value="/merchant", method=RequestMethod.POST,
			produces="application/json", consumes="application/json")
	public Merchant createMerchant(
			@RequestBody Merchant merchant)
	{	
	
		if(merchant.getName()  == null)
			throw new InvalidParameters("merchant must have a name");
		
		Merchant m =  marketPlace.createMerchant(merchant.getName(), merchant.getDescription());
		return m;		
	}
	
	@RequestMapping(value="/merchant/{mid}", method=RequestMethod.GET,
			produces="application/json")
	public ResponseEntity<?> getMerchant(
			 @PathVariable int mid)
	{	
		Merchant merchant = marketPlace.getMerchant(mid);
		
		if(merchant == null)
			return new ResponseEntity<Error>( new Error(), HttpStatus.NOT_FOUND);
		
        return new ResponseEntity<Merchant>(merchant, HttpStatus.OK);
	}
	
	@RequestMapping(value="/merchant/{mid}", method=RequestMethod.DELETE,
			produces="application/json")
	public Merchant deleteMerchant(
			 @PathVariable int mid)
	{	
		return marketPlace.deleteMerchant(mid);		
	}
	
	@RequestMapping(value="/merchant/{mid}/offers", method=RequestMethod.GET,
			produces="application/json")
	public @ResponseBody Collection<MerchantOffer> offers(
			 @PathVariable int mid)
	{	
		if(marketPlace.getMerchantExists(mid))
		{
			Collection<MerchantOffer> offers = marketPlace.getMerchantOffers(mid);
			
			if(offers == null)
				throw new MerchantOrOfferNotFoundException("Could not get offers for merchant Id: "
						+ mid);
			else
			{
				return marketPlace.getMerchantOffers(mid);
			}
		}
		else
			throw new MerchantOrOfferNotFoundException("No merchant found with merchant Id: "
					+ mid);
		
	}
	
	@RequestMapping(value="/merchant/{mid}/offer/{oid}", method=RequestMethod.GET,
			produces="application/json")
	public MerchantOffer offer(
			 @PathVariable int mid, @PathVariable int oid)
	{	
		MerchantOffer offer = marketPlace.getMerchantOffer(new MerchantOfferId(mid, oid));
		
		if(offer == null)
			throw new MerchantOrOfferNotFoundException("Did not find an offer with Offer Id"
					+ "mid : " + mid + "oid: " + oid);

		return offer;
	}
	
	@RequestMapping(value="/merchant/{mid}/offer", method=RequestMethod.POST,
			produces="application/json", consumes="application/json")
	public @ResponseBody MerchantOffer createOffer(
			 @PathVariable int mid, @RequestBody MerchantOffer offer)
	{	

		if(!marketPlace.getMerchantExists(mid))
			throw new MerchantOrOfferNotFoundException("merchant does not exist for Merchant Id: " 
					+ mid);
				
		MerchantOffer createdOffer = marketPlace.createMerchantOffer(
				mid, offer.getName(), offer.getDescription(), null);
		
		return createdOffer;
	}
	
	@RequestMapping(value="/merchant/{mid}/offer", method=RequestMethod.PUT, 
			produces="application/json", consumes="application/json")
	public MerchantOffer updateOffer(
			 @RequestBody MerchantOffer offer)
	{	
		MerchantOffer updatedOffer = marketPlace.updateMerchantOffer(offer);
		
		if(updatedOffer == null)
			throw new MerchantOrOfferNotFoundException("Update failed for offer");

		return updatedOffer;
	}
	
	@Autowired
	private IMarketPlace marketPlace;
}
