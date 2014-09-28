package in.pulseinfotech.printphoto.dto.payment;



/**
 * This is an enumeration defining the payment status of an order.   
 * 
 * @author Rima Das
 * @version 1.0
 * @since 16 September 2014 <br>
 * <br>
 *
 *{@link in.pulseinfotech.printphoto.dto.payment.PaymentStatus#PAID PAID},
 *{@link in.pulseinfotech.printphoto.dto.payment.PaymentStatus#UNPAID UNPAID}
 *
 */
public enum PaymentStatus {

	/**
	 * PAID: The user has already paid for his order. 
	 */
	PAID("paid"), 
	/**
	 * UNPAID: The user has NOT paid for his order.
	 */
	UNPAID("unpaid");
	
	
	private String statusCode;
	
	private PaymentStatus(String statusCode){
		this.statusCode = statusCode;
	}
	
	/**
	 * 
	 * @return Status Code.
	 */
	public String getPaymentStatusCode() {
		return statusCode;
	}
	
	
}
