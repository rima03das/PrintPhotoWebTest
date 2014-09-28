package in.pulseinfotech.printphoto.exception;

/**
 * 
 * This class is a subclass of <code>InvalidIdException</code>. Thrown to indicate
 * that the application has attempted to create a PaymentModeId but that
 * PaymentModeId does not have the appropriate format or that it already exists.
 * 
 * @author Rima Das
 * @version 1.0
 * @since 20 September 2014 <br>
 * <br>
 * @see InvalidIdException
 * 
 */
public class PaymentModeIdException extends InvalidIdException {

	public PaymentModeIdException(String msg) {
		super(msg);
	}

}
