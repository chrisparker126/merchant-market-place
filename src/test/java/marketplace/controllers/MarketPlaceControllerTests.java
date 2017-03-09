package marketplace.controllers;

import org.junit.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.json.JSONObject;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;



@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MarketPlaceControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void createMerchantTest() throws Exception {

    
    	JSONObject j = new JSONObject();
    	String createMerchant = j.put("name", "merchant1").toString();
    	
        this.mockMvc.perform(post("/merchant").contentType(MediaType.APPLICATION_JSON)
        		.content(createMerchant)).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("merchant1"));
    }
    
    
    @Test
    public void getMerchantTest() throws Exception {

    
    	JSONObject j = new JSONObject();
    	String createMerchant = j.put("name", "merchant1").toString();
    	
        this.mockMvc.perform(post("/merchant").contentType(MediaType.APPLICATION_JSON)
        		.content(createMerchant)).andDo(print()).andExpect(status().isOk());
        
        this.mockMvc.perform(get("/merchant/1").contentType(MediaType.APPLICATION_JSON)).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("merchant"));
    }

}
