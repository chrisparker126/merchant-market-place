package marketplace.core;

public interface IMerchantManager {

	public class MerchantManagerException extends Exception	
	{
		public MerchantManagerException(String message) {
			super(message);
		}		
	}
	
	public int createMerchant(String name, String description)
	throws MerchantManagerException;
	public boolean deleteMerchant(int merchantId)
	throws MerchantManagerException;
	public boolean changeMerchangeName(int merchantId, String name)
	throws MerchantManagerException;
}
