package in.pulseinfotech.printphoto.exception;

/**
 * This class is a subclass of <code>UserException</code>. Thrown to indicate that the application has attempted to create or access a username
 * which does not have the appropriate format.
 * 
 * @author Raman Ahuja
 * @version 1.0
 * @since 16 September 2014 <br>
 * <br>
 * <br>
 * @see UserException
 * 
 */
public class UsernameException  extends UserException{
	public UsernameException(String msg) {
		super(msg);
	}
}
