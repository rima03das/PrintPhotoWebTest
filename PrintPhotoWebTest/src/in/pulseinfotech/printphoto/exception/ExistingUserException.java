package in.pulseinfotech.printphoto.exception;

/**
 * * This class is a subclass of <code>UserException</code>. Thrown to indicate that the application has attempted to create an user with
 * the id that already exits.
 * 
 * @author Raman Ahuja
 * @version 1.0
 * @since 16 September 2014 <br>
 * <br>
 * <br>
 * 
 * @see UserException
 * 
 */
public class ExistingUserException extends UserException {
	public ExistingUserException(String msg) {
		super(msg);
	}
}
