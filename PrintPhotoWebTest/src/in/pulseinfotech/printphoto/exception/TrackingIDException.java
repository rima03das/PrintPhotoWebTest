package in.pulseinfotech.printphoto.exception;


/**
 * 
 * This class is a subclass of <code>InvalidIdException</code>. Thrown to indicate
 * that the application has attempted to create an TrackingID but that TrackingID does not have
 * the appropriate format or that it already exists.
 * 
 * @author Raman Ahuja
 * @version 1.0
 * @since 16 September 2014 <br>
 * <br>
 * <br>
 * @see InvalidIdException
 * 
 */
public class TrackingIDException extends InvalidIdException{
	public TrackingIDException(String msg) {
		super(msg);
	}
}
