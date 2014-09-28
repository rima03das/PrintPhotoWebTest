package in.pulseinfotech.printphoto.exception;

/**
 * 
 * This class is a subclass of <code>InvalidIdException</code>. Thrown to
 * indicate that the application has attempted to create an UserID but that
 * UserID does not have the appropriate format or that it already exists.
 * 
 * @author Raman Ahuja
 * @version 1.0
 * @since 16 September 2014 <br>
 * <br>
 * @see InvalidIdException
 * 
 */
public class UserIDException extends InvalidIdException {

	public UserIDException(String msg) {
		super(msg);
	}

}
