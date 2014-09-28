package in.pulseinfotech.printphoto.exception;

/**
 * 
 * This class is a subclass of <code>PaymentException</code>. Thrown to indicate
 * that the details provided for a payment is invalid.
 * 
 * @author Rima Das
 * @version 1.0
 * @since 20 September 2014 <br>
 * <br>
 * <br>
 * @see PaymentException
 * 
 */
public class PaymentDetailsException extends PaymentException {

	public PaymentDetailsException(String msg) {
		super(msg);
	}

}
