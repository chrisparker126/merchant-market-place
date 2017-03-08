package marketplace.core;

import static org.junit.Assert.*;
import org.junit.Test;
import marketplace.domain.IMerchantRepository;
import marketplace.domain.Merchant;

import static org.mockito.Mockito.*;

import org.apache.log4j.*;


public class MerchantManagerTests {

	Logger logger = Logger.getLogger(MerchantManagerTests.class);
	
	@Test
	public void testAddMerchant() {
		IMerchantRepository repo = mock(IMerchantRepository.class);
		
		try
		{
			when(repo.getTopMerchantId()).thenReturn(2);				
			MerchantManager merchantManager = new MerchantManager(repo);			
			Merchant m = merchantManager.createMerchant("Test1", "This is a test merchant");
			assertEquals(m.getMerchantId(), 3);
		}
		catch(Exception e)
		{
			logger.warn(e);
		}
	}

	@Test
	public void testGetMerchant() 
	{
		IMerchantRepository repo = mock(IMerchantRepository.class);
		
		try
		{
			MerchantManager merchantManager = new MerchantManager(repo);
			when(repo.getMerchant(2)).thenReturn(new Merchant("Test1", 2, "A Test merchant"));
			Merchant merchant = merchantManager.getMerchant(2);
					
			assertEquals(merchant.getName(), "Test1");
			assertEquals(merchant.getMerchantId(), 2);
			assertEquals(merchant.getDescription(), "A Test merchant");			
		}
		catch(Exception e)
		{
			logger.warn(e);
		}
	}
	

}