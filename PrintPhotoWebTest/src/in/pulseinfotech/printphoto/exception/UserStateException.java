package in.pulseinfotech.printphoto.exception;


/**
 * 
 * This class is a subclass of <code>UserException</code>. Thrown to indicate
 * that the state of an order is invalid.
 * 
 * @author Raman Ahuja
 * @version 1.0
 * @since 16 September 2014 <br>
 * <br>
 * @see UserException
 * 
 */
public class UserStateException extends UserException{
	public UserStateException(String msg) {
		super(msg);
	}
}
