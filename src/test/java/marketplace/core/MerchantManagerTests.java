package marketplace.core;

import static org.junit.Assert.*;
import org.junit.Test;

import marketplace.core.IMerchantManager.MerchantManagerException;
import marketplace.domain.IMerchantRepository;
import marketplace.domain.Merchant;

import static org.mockito.Mockito.*;

import org.apache.log4j.*;


public class MerchantManagerTests {

	Logger logger = Logger.getLogger(MerchantManagerTests.class);
	
	@Test
	public void testAddMerchant() throws MerchantManagerException {
		IMerchantRepository repo = mock(IMerchantRepository.class);
		
		when(repo.getTopMerchantId()).thenReturn(2);				
		MerchantManager merchantManager = new MerchantManager(repo);			
		Merchant m = merchantManager.createMerchant("Test1", "This is a test merchant");
		assertEquals(m.getMerchantId(), 3);
		assertEquals(m.getName(), "Test1");
		assertEquals(m.getDescription(), "This is a test merchant");		
	}

	@Test
	public void testGetMerchant() throws MerchantManagerException 
	{
		IMerchantRepository repo = mock(IMerchantRepository.class);
		
		MerchantManager merchantManager = new MerchantManager(repo);
		when(repo.getMerchant(2)).thenReturn(new Merchant("Test1", 2, "A Test merchant"));
		Merchant merchant = merchantManager.getMerchant(2);
				
		assertEquals(merchant.getName(), "Test1");
		assertEquals(merchant.getMerchantId(), 2);
		assertEquals(merchant.getDescription(), "A Test merchant");			
	
	}
	
	
	@Test
	public void testDeleteMerchant() throws MerchantManagerException
	{
		IMerchantRepository repo = mock(IMerchantRepository.class);
		
		MerchantManager merchantManager = new MerchantManager(repo);
		when(repo.deleteMerchant(2)).thenReturn(new Merchant("Test1", 2, "A Test merchant"));
		Merchant merchant = merchantManager.deleteMerchant(2);
				
		assertEquals(merchant.getName(), "Test1");
		assertEquals(merchant.getMerchantId(), 2);
		assertEquals(merchant.getDescription(), "A Test merchant");		
	
	}

}
