package in.pulseinfotech.printphoto.exception;

/**
 * 
 * This class is a subclass of <code>InvalidIdException</code>. Thrown to
 * indicate that the application has attempted to create a ShipmentReceiptID but
 * that ShipmentReceiptID does not have the appropriate format or that it
 * already exists.
 * 
 * @author Raman Ahuja
 * @version 1.0
 * @since 16 September 2014 <br>
 * <br>
 * <br>
 * @see InvalidIdException
 * 
 */

public class ShipmentReceiptIDException extends InvalidIdException {

	public ShipmentReceiptIDException(String msg) {
		super(msg);
	}

}
