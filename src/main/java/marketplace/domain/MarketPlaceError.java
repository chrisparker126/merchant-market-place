package marketplace.domain;

public class MarketPlaceError {
	
	public MarketPlaceError(Integer errorCode) {
		super();
		this.errorCode = errorCode;
		this.errorDescription = MarketPlaceErrorCodes.errorCodeToString(errorCode);
	}
	public MarketPlaceError(){}
	
	public Integer errorCode;
	public String errorDescription;
}
