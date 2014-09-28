package in.pulseinfotech.printphoto.exception;

/**
 * 
 * This class is a subclass of <code>UserException</code>. Thrown to indicate
 * that the application has attempted to create an ID but that ID does not have
 * the appropriate format.
 * 
 * @author Raman Ahuja
 * @version 1.0
 * @since 16 September 2014 <br>
 * <br>
 * @see UserException
 * @see OrderIDException
 * @see TrackingIDException
 * @see UserIDException
 */

public class InvalidIdException extends Exception {
	public InvalidIdException(String msg) {
		super(msg);
	}

}
