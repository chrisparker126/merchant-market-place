package marketplace.domain;

/**
 * Representation of errors that can happen within merchant market place
 * @author Chris.Parker
 *
 */
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
