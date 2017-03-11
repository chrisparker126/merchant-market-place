package marketplace.controllers;



import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import marketplace.core.IMarketPlace;
import marketplace.domain.MarketPlaceError;
import marketplace.domain.MarketPlaceErrorCodes;
import marketplace.domain.Merchant;
import marketplace.domain.MerchantOffer;
import marketplace.domain.MerchantOfferId;


@RestController
public class MarketPlaceController {


	
	public MarketPlaceController(IMarketPlace marketPlace) {
		super();
		this.marketPlace = marketPlace;
	}

	@RequestMapping(value="/merchant", method=RequestMethod.POST,
			produces="application/json", consumes="application/json")
	public ResponseEntity<?> createMerchant(
			@RequestBody Merchant merchant)
	{	
	
		if(merchant.getName()  == null)
			return new ResponseEntity< MarketPlaceError >(new 
					MarketPlaceError(MarketPlaceErrorCodes.INVALID_PARAMETERS), 
					HttpStatus.BAD_REQUEST);
		
		Merchant m =  marketPlace.createMerchant(merchant.getName(), merchant.getDescription());
		return new ResponseEntity< Merchant >(m,
				HttpStatus.OK);		
	}
	
	@RequestMapping(value="/merchant/{mid}", method=RequestMethod.GET,
			produces="application/json")
	public ResponseEntity<?> getMerchant(
			 @PathVariable int mid)
	{	
		Merchant merchant = marketPlace.getMerchant(mid);
		
		if(merchant == null)
			return new ResponseEntity<MarketPlaceError>( new MarketPlaceError(
					MarketPlaceErrorCodes.MERCHANT_DOES_NOT_EXIST), HttpStatus.NOT_FOUND);
		
        return new ResponseEntity<Merchant>(merchant, HttpStatus.OK);
	}
	
	@RequestMapping(value="/merchant/{mid}", method=RequestMethod.DELETE,
			produces="application/json")
	public ResponseEntity<?> deleteMerchant(
			 @PathVariable int mid)
	{	
		if(marketPlace.getMerchantExists(mid))
		{
			return new ResponseEntity<Merchant>(marketPlace.deleteMerchant(mid),
					HttpStatus.OK);
		}
		return new ResponseEntity<MarketPlaceError>( new MarketPlaceError(
				MarketPlaceErrorCodes.MERCHANT_DOES_NOT_EXIST), HttpStatus.NOT_FOUND);	
	}
	
	@RequestMapping(value="/merchant/{mid}/offers", method=RequestMethod.GET,
			produces="application/json")
	public ResponseEntity< ? > offers(
			 @PathVariable int mid)
	{	
		if(marketPlace.getMerchantExists(mid))
		{
			Collection<MerchantOffer> offers = marketPlace.getMerchantOffers(mid);
			
			return new ResponseEntity<Collection<MerchantOffer>>
			(offers, HttpStatus.OK);						
			
		}
		else
		{
			return new ResponseEntity< MarketPlaceError >(new 
					MarketPlaceError(MarketPlaceErrorCodes.MERCHANT_DOES_NOT_EXIST), 
					HttpStatus.NOT_FOUND);
		}			
		
	}
	
	@RequestMapping(value="/merchant/{mid}/offer/{oid}", method=RequestMethod.GET,
			produces="application/json")
	public ResponseEntity< ? > offer(
			 @PathVariable int mid, @PathVariable int oid)
	{	
		if(marketPlace.getMerchantExists(mid))
		{
			MerchantOffer offer = marketPlace.getMerchantOffer(new MerchantOfferId(mid, oid));
			
			if(offer == null)
				return new ResponseEntity< MarketPlaceError >(new 
						MarketPlaceError(MarketPlaceErrorCodes.OFFER_DOES_NOT_EXIST), 
						HttpStatus.NOT_FOUND);
			else
				return new ResponseEntity< MerchantOffer >(offer, 
						HttpStatus.OK);
		}
		else
			return new ResponseEntity< MarketPlaceError >(new 
					MarketPlaceError(MarketPlaceErrorCodes.MERCHANT_DOES_NOT_EXIST), 
					HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value="/merchant/{mid}/offer", method=RequestMethod.POST,
			produces="application/json", consumes="application/json")
	public ResponseEntity<?> createOffer(
			 @PathVariable int mid, @RequestBody MerchantOffer offer)
	{	

		if(!marketPlace.getMerchantExists(mid))
			return new ResponseEntity< MarketPlaceError >(new 
					MarketPlaceError(MarketPlaceErrorCodes.MERCHANT_DOES_NOT_EXIST), 
					HttpStatus.NOT_FOUND);
				
		MerchantOffer createdOffer = marketPlace.createMerchantOffer(
				mid, offer.getName(), offer.getDescription(), null);
		
		return new ResponseEntity<MerchantOffer>(createdOffer, HttpStatus.OK);
	}
	
	@RequestMapping(value="/merchant/{mid}/offer", method=RequestMethod.PUT, 
			produces="application/json", consumes="application/json")
	public ResponseEntity<?> updateOffer(
			 @RequestBody MerchantOffer offer)
	{	
		MerchantOfferId offerId = offer.getMerchantOfferId();
		
		if(offerId == null)
			return new ResponseEntity< MarketPlaceError >(new 
					MarketPlaceError(MarketPlaceErrorCodes.INVALID_PARAMETERS), 
					HttpStatus.BAD_REQUEST);
		
		if(marketPlace.getMerchantExists(offerId.getMerchantId()))
		{
			MerchantOffer updatedOffer = marketPlace.updateMerchantOffer(offer);
			
			if(updatedOffer == null)
				return new ResponseEntity< MarketPlaceError >(new 
						MarketPlaceError(MarketPlaceErrorCodes.OFFER_DOES_NOT_EXIST), 
						HttpStatus.NOT_FOUND);
			else
				return new ResponseEntity< MerchantOffer >(updatedOffer, 
						HttpStatus.OK);
		}
		else
			return new ResponseEntity< MarketPlaceError >(new 
					MarketPlaceError(MarketPlaceErrorCodes.MERCHANT_DOES_NOT_EXIST), 
					HttpStatus.NOT_FOUND);		
	}
	
	@Autowired
	private IMarketPlace marketPlace;
}
