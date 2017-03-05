package marketplace.core;

import marketplace.domain.Merchant;

public interface IMerchantManager {

	public class MerchantManagerException extends Exception	
	{
		public MerchantManagerException(String message) {
			super(message);
		}		
	}
	
	public int createMerchant(String name, String description)
	throws MerchantManagerException;
	
	public void deleteMerchant(int merchantId)
	throws MerchantManagerException;
	
	public void changeMerchangeName(int merchantId, String name)
	throws MerchantManagerException;
	
	public Merchant getMerchant(int merchantId)
	throws MerchantManagerException;
}
