# merchant-market-place

The merchant market place REST app allows clients to create an instance of merchant 

## Running application
The application is built using the spring interface and uses Maven for
dependency management

You need Java JDK 1.8 and Maven.

first clone the project and in application directory simply run the command 

<code>mvn clean package</code> 

The code comes with embedded tomcat server so you can simply run with Java 

<code> java -Dspring.profiles.active=production -jar target\merchant-market-place-0.0.1-SNAPSHOT.jar</code>

The "production" bean profile is required to run the app

# API

1. Create Merchant 
  * url : /merchant 
  * method: POST
  * Data Params (media type: JSON)
   * name [string] required
   * description [string] optional 
2. Get Merchant
..* url : /merchant/:id
...* :id [integer] 
..* method: GET
..* Data Params none 
3. Delete Merchant
4. Create Merchant Offer
5. Get Merchant Offer
5. Delete Merchant Offer
6. Update Merchant Offer


## Error
