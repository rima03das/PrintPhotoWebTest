package in.pulseinfotech.printphoto.exception;

/**
 * 
 * This class is a subclass of <code>InvalidIdException</code>. Thrown to
 * indicate that the application has attempted to create a payment id but that
 * payment ID does not have the appropriate format or that it already exists.
 * 
 * @author Rima Das
 * @version 1.0
 * @since 20 September 2014 <br>
 * <br>
 * @see InvalidIdException
 * 
 */
public class PaymentIdException extends InvalidIdException {

	public PaymentIdException(String msg) {
		super(msg);
	}

}
