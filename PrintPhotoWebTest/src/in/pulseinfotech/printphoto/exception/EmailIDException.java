package in.pulseinfotech.printphoto.exception;


/**
 * 
 * This class is a subclass of <code>UserException</code>. Thrown to indicate that the application has attempted to access an email id but
 * that email id does not have the appropriate format or does not exists.
 * 
 * @author Raman Ahuja
 * @version 1.0
 * @since 16 September 2014 <br>
 * <br>
 * 
 * @see UserException
 */
public class EmailIDException extends UserException{
	public EmailIDException(String msg) {
		super(msg);
	}
}
