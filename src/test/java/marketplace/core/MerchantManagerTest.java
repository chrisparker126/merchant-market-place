package marketplace.core;

import static org.junit.Assert.*;
import org.junit.Test;
import marketplace.domain.IMarketPlaceRepository;
import static org.mockito.Mockito.*;

import org.apache.log4j.*;

public class MerchantManagerTest {

	Logger logger = Logger.getLogger(MerchantManagerTest.class);
	
	@Test
	public void testAddManager() {
		IMarketPlaceRepository repo = mock(IMarketPlaceRepository.class);
		
		try
		{
			when(repo.getTopMerchantId()).thenReturn(2);				
			MerchantManager merchantManager = new MerchantManager(repo);			
			int merchantId = merchantManager.createMerchant("Test1", "This is a test merchant");
			assertEquals(merchantId, 3);
		}
		catch(Exception e)
		{
			logger.warn(e);
		}
	}

	
	
}
