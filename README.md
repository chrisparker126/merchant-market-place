# Merchant Market Place

The merchant market place REST app allows clients to create merchant instances 
and then allow these merchants to create offers for the market place

## Running application
The application is built using the spring framework and uses Maven for
dependency management

### Build app

You need Java JDK 1.8 and Maven.

first clone the project and in application directory simply run the command 

<code>mvn clean package</code> 

### Run app
The code comes with an embedded tomcat servelet container so you can simply run the jar 

<code> java -Dspring.profiles.active=production -jar target\merchant-market-place-0.0.1-SNAPSHOT.jar</code>

The "production" bean profile is needed to use the correct bean dependencies. 
Running tests you need to use the "test" profile.

The app should run on "http://localhost:8080"

## Example

Getting a merchant's offer running on local host

  * http://localhost:8080/merchant/1/offer/2
    * response    
  <code> { "name" : "games console", "description" : "lots of fun", "price" : { "amount" 299.99" "currency" : "GBP" }, "merchantOfferId" : { "merchantId" : 1, "offerId" : 2 } } </code>
   * status : 200
  
# API

1. Create Merchant 
  * **URL** /merchant 
  * method: **POST**
  * Data Params (media type: JSON)
    * name [string] required
    * description [string] optional
  * Success Response
    * status 200
    * content: JSON echo of merchant
      * name [string]
      * description [string] 
      * merhcnatId [integer]
  * Error Response
    * status 
      * 400 Bad Request
    * content JSON see Error topic at bottom
	
         
2. Get Merchant
  * **URL** /merchant/:id
    * :id [integer] 
  * method: **GET**
  * Data Params none
  * Success Response
    * status 200
    * content: JSON
      * name [string]
      * description [string]
      * merchantId [integer]
  * Error Response
    * status 
      * 400 Bad Request
      * 404 Not found
    * content JSON see Error topic at bottom
 
3. Delete Merchant
  * URL /merchant/:id
    * :id [integer] 
  * method: **DELETE**
  * Data Params none
  * Success Response
    * status 200
    * content JSON
      * name [string]
      * description [string]
      * merchantId [integer]
  * Error Response
    * status 
      * 400 Bad Request
      * 404 Not found
    * content JSON see Error topic at bottom
    
4. Create Merchant Offer
  * **URL** /merchant/:id/offer 
  * method: **POST**
  * Data Params (media type: JSON)
    * name [string] required
    * description [string] optional
    * price [composite] required
      * amount [string]
      * currency [string] ISO 3 digit alpha
  * Success Response
    * status 200
    * content: JSON echo of merchant
      * name [string]
      * description [string] 
      * price
        * amount [string]
        * currency [string] ISO 3 digit alpha      
      * merchantOfferId
        * merchantId
        * offerId
  * Error Response
    * status 
      * 400 Bad Request
      * 404 Not found
    * content JSON see merchant place error
	
5. Get Merchant Offer
  * **URL** /merchant/:id/offer/:oid
    * :id [integer] merchant id
    * :oid [integer] offer id
  * method: **GET**
  * Data Params none
  * Success Response
    * status 200
    * content: JSON
      * name [string]
      * description [string] 
      * price
        * amount [string]
        * currency [string] ISO 3 digit alpha      
      * merchantOfferId
        * merchantId
        * offerId
  * Error Response
    * status 
      * 400 Bad Request
      * 404 Not found
    * content JSON see merchant place error
6. Get merchant offers
  * **URL** /merchant/:id/offers
    * :id [integer] merchant id
  * method: **GET**
  * Data Params none
  * Success Response
    * status 200
    * content: JSON
      * list 
        * name [string]
        * description [string] 
        * price
        * merchantOfferId
          * merchantId
          * offerId
  * Error Response
    * status 
      * 400 Bad Request
      * 404 Not found
    * content JSON see merchant place error 
7. Delete Merchant Offer
  * **URL** /merchant/:id/offer/:oid
    * :id [integer] merchant id
    * :oid [integer] offer id
  * method: **DELETE**
  * Data Params none
  * Success Response
    * status 200
    * content: JSON of deleted merhant offer
      * name [string]
      * description [string] 
      * price
        * amount [string]
        * currency [string] ISO 3 digit alpha      
      * merchantOfferId
        * merchantId
        * offerId
  * Error Response
    * status 
      * 400 Bad Request
      * 404 Not found
    * content JSON see merchant place error
8. Update Merchant Offer
  * **URL** /merchant/:id/offer/:oid
    * :id [integer] merchant id
    * :oid [integer] offer id
  * method: **PUT**
  * Data Params (media type: JSON)
    * name [string] optional
    * description [string] optional
    * price [composite] optional
      * amount [string]
      * currency [string] ISO 3 digit alpha
  * Success Response
    * status 200
    * content: JSON of deleted merhant offer
      * name [string] optional
      * description [string] optional
      * price [composite] optional
        * amount [string]
        * currency [string] ISO 3 digit alpha           
  * Error Response
    * status 
      * 400 Bad Request
      * 404 Not found
    * content JSON see Error topic at bottom

## Errors

A json body is returned in most error response status codes. 

* errorCode [integer]
* description [string]

### Error Codes
* 1, merchant does not exist 
* 2, merchant offer does not exist
* 3, invalid parameters
* 4, invalid path values

