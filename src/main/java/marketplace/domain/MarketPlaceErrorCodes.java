package marketplace.domain;

public class MarketPlaceErrorCodes {
	public static final int MERCHANT_DOES_NOT_EXIST = 1;
	public static final int OFFER_DOES_NOT_EXIST = 2;
	public static final int INVALID_PARAMETERS = 3;
	public static final int INVALID_PATH_VALUES = 4;
	
	public static String errorCodeToString(int errorCode)
	{
		switch (errorCode) {
		case MERCHANT_DOES_NOT_EXIST:
			return "Merchant does not exist";
		case OFFER_DOES_NOT_EXIST:
			return "Offer does not exist";
		case INVALID_PARAMETERS:
			return "One or more of you request parameters are incorrect";
		case INVALID_PATH_VALUES:
			return "Invalid path values";
		default:
			return "unknown error";
		}
	}
}
