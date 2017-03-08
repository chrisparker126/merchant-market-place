package marketplace.core;

import marketplace.domain.Merchant;

public interface IMerchantManager {

	public class MerchantManagerException extends Exception	
	{
		public MerchantManagerException(String message) {
			super(message);
		}		
	}
	
	public Merchant createMerchant(String name, String description)
	throws MerchantManagerException;
	
	public Merchant deleteMerchant(int merchantId)
	throws MerchantManagerException;
	
	public void changeMerchangeName(int merchantId, String name)
	throws MerchantManagerException;
	
	public Merchant getMerchant(int merchantId)
	throws MerchantManagerException;
}
