package in.pulseinfotech.printphoto.exception;

/**
 * 
 * This class is a subclass of <code>UserException</code>. Thrown to indicate
 * that the status of an user is invalid.
 * 
 * @author Raman Ahuja
 * @version 1.0
 * @since 16 September 2014 <br>
 * <br>
 * <br>
 * @see UserException
 * 
 */
public class UserStatusException extends UserException{
	public UserStatusException(String msg) {
		super(msg);
	}
}
