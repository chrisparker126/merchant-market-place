package marketplace.controllers;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ImportResource;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import marketplace.core.IMarketPlace;
import marketplace.domain.Merchant;
import marketplace.domain.MerchantOffer;



@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ImportResource("classpath:Beans.xml")
@ActiveProfiles("test")
public class MarketPlaceControllerTests {
	
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void createMerchantTest() throws Exception {

    	IMarketPlace marketPlace = MockMarketPlaceFactory.marketPlace;
    	
    	when(marketPlace.createMerchant(any(), any()))
    	 .thenReturn(new Merchant("merchant1", 1, ""));
    	 
    	JSONObject j = new JSONObject();
    	String createMerchant = j.put("name", "merchant1").toString();
    	
        this.mockMvc.perform(post("/merchant").contentType(MediaType.APPLICATION_JSON)
        		.content(createMerchant)).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("merchant1"));
    }    
    
    @Test
    public void getMerchantTest() throws Exception {
    
    	IMarketPlace marketPlace = MockMarketPlaceFactory.marketPlace;
        
    	when(marketPlace.getMerchant(1))
    	 .thenReturn(new Merchant("merchant1", 1, ""));
    	
        this.mockMvc.perform(get("/merchant/1").contentType(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("merchant1"));
    }
    
    @Test
    public void deleteMerchantTest() throws Exception {

    	IMarketPlace marketPlace = MockMarketPlaceFactory.marketPlace;
        
    	when(marketPlace.deleteMerchant(1))
   	 	.thenReturn(new Merchant("merchant1", 1, ""));
        
    	when(marketPlace.getMerchantExists(1))
   	 	.thenReturn(false);
    	
        this.mockMvc.perform(delete("/merchant/1")).andDo(print()).andExpect(status().is4xxClientError());

        when(marketPlace.getMerchantExists(1))
      	 .thenReturn(true);

        when(marketPlace.deleteMerchant(1))
     	 .thenReturn( new Merchant("merchant2", 1, ""));
        this.mockMvc.perform(delete("/merchant/1")).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("merchant2"))
                .andExpect(jsonPath("$.merchantId").value(1));
    }
    
    @Test
    public void createMerchantOfferTest() throws Exception {

    	IMarketPlace marketPlace = MockMarketPlaceFactory.marketPlace;
    	when(marketPlace.getMerchantExists(1))
     	 .thenReturn(true);
    	
    	when(marketPlace.createMerchantOffer(any(), anyString(), anyString(), any()))
    	.thenReturn(new MerchantOffer("product1", "tasty", null, null));
    	
    	JSONObject j = new JSONObject();
    	String createOffer = j.put("name", "product1").put("description", "tasty").toString();
    	
        this.mockMvc.perform(post("/merchant/1/offer").contentType(MediaType.APPLICATION_JSON)
        		.content(createOffer)).andDo(print()).andExpect(status().isOk())
        .andExpect(jsonPath("$.description").value("tasty"))
        .andExpect(jsonPath("$.name").value("product1"));
    }

    @Test
    public void getMerchantOfferTest() throws Exception {
    	
    	IMarketPlace marketPlace = MockMarketPlaceFactory.marketPlace;
    	
    	reset(marketPlace);
    	
    	when(marketPlace.getMerchantExists(1))
     	 .thenReturn(true);
    	
    	when(marketPlace.getMerchantOffer(any())).thenReturn(null);
    			
        this.mockMvc.perform(get("/merchant/1/offer/2"))
        		.andDo(print()).andExpect(status().is4xxClientError())
        .andExpect(jsonPath("$.errorCode").value(2));
        
        when(marketPlace.getMerchantOffer(any())).thenReturn(
        		new MerchantOffer("pdd2", null, null, null));
        
        this.mockMvc.perform(get("/merchant/1/offer/2"))
		.andDo(print()).andExpect(status().isOk())
		.andExpect(jsonPath("$.name").value("pdd2"));

    }
    
    @Test
    public void deleteMerchantOfferTest() throws Exception {


    }
}
