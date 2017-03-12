package marketplace.core;

import marketplace.domain.Merchant;

public interface IMerchantManager {

	/**
	 * To be thrown by implementers of interface
	 * to describe of merchant manager context specific error occuring
	 * @author Chris.Parker
	 *
	 */
	@SuppressWarnings("serial")
	public class MerchantManagerException extends Exception	
	{
		public MerchantManagerException(String message) {
			super(message);
		}		
	}
	
	/**
	 * Create merchant
	 * @param name name of merchant to create
	 * @param description description provided by merchant
	 * @return the merchant created, null if merchants fails to be created
	 * @throws MerchantManagerException 
	 */
	public Merchant createMerchant(String name, String description)
	throws MerchantManagerException;
	
	/**
	 * deletes merchant
	 * @param merchantId
	 * @return
	 * @throws MerchantManagerException
	 */
	public Merchant deleteMerchant(Integer merchantId)
	throws MerchantManagerException;

	/**
	 * get s merchant
	 * @param merchantId
	 * @return null if merchant does not exist
	 * @throws MerchantManagerException
	 */
	public Merchant getMerchant(int merchantId)
	throws MerchantManagerException;
	
	/**
	 * Get whether merchant exists of not
	 * @param merchantId
	 * @return  true if merchant exists, false otherwise
	 */
	public boolean getMerchantExists(int merchantId);
}
