package in.pulseinfotech.printphoto.dto.payment;


/**
 * This is an enumeration defining the state of the cheque given as payment. A
 * cheque can either be cleared, uncleared or not set.
 * 
 * @author Rima Das,Gufran Khurshid
 * @version 1.0
 * @since 16 September 2014 <br>
 * <br>
 * 
 *        {@link in.pulseinfotech.printphoto.dto.payment.ChequeStatus#CLEARED
 *        CLEARED},
 *        {@link in.pulseinfotech.printphoto.dto.payment.ChequeStatus#UNCLEARED
 *        UNCLEARED},
 *        {@link in.pulseinfotech.printphoto.dto.payment.ChequeStatus#NOTSET
 *        NOTSET}
 * 
 */
public enum ChequeStatus {

	/**
	 * CLEARED: The cheque has been cleared.
	 */
	CLEARED("cleared"),
	/**
	 * UNCLEARED: The cheque has not been cleared
	 */
	UNCLEARED("uncleared"),
	/**
	 * NOTSET: The value is not set
	 */
	NOTSET("notset");

	private String statusCode;

	private ChequeStatus(String statusCode) {
		this.statusCode = statusCode;
	}

	/**
	 * 
	 * @return Status Code.
	 */
	public String getChequeStatusCode() {
		return statusCode;
	}

}
