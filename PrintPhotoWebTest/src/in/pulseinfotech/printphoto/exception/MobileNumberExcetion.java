package in.pulseinfotech.printphoto.exception;

/**
 * This class is a subclass of <code>UserException</code>. Thrown to indicate
 * that the application has attempted to access a mobile number which is either
 * wrong does not exists
 * 
 * @author Raman Ahuja
 * @version 1.0
 * @since 16 September 2014 <br>
 * <br>
 * <br>
 * @see UserException
 * 
 */
public class MobileNumberExcetion extends UserException {
	public MobileNumberExcetion(String msg) {
		super(msg);
	}
}
