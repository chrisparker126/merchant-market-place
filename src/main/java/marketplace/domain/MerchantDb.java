package marketplace.domain;

import java.util.TreeMap;

public class MerchantDb implements IMerchantRepository, IMerchantInfoRepository {

//	@Override
//	public Merchant updateMerchant(int merchantId, String name, String description) {
//		// TODO Auto-generated method stub
//		Merchant merchant = getMerchant(merchantId);
//		
//		if(merchant == null)
//			return null;
//		
//		Merchant updatedMerchant = 
//				new Merchant(name != null ? name : merchant.getName(), merchantId, 
//						description != null ? description : merchant.getDescription());
//		
//		merchants.put(merchantId, updatedMerchant);
//		return updatedMerchant;
//	}

	@Override
	public boolean getDoesMerchantExist(Integer merchantId) {
		return merchants.containsKey(merchantId);
	}

	@Override
	public Merchant addMerchant(Merchant merchant){
		return merchants.put(merchant.getMerchantId(), merchant);
	}

	@Override
	public int getTopMerchantId() {
		
		if(merchants.isEmpty())
			return 0;
		else
			return merchants.lastKey();
	}

	@Override
	public Merchant getMerchant(Integer merchantId) {
		return merchants.get(merchantId);
	}

	@Override
	public Merchant deleteMerchant(Integer merchantId) {
		return merchants.remove(merchantId);
	}

	private TreeMap<Integer, Merchant> merchants = new TreeMap<Integer, Merchant>();

	@Override
	public boolean getMerchantExists(Integer merchantId) {
		return getDoesMerchantExist(merchantId);
	}
}
