package in.pulseinfotech.printphoto.exception;


/**
 * 
 * This class is a subclass of <code>InvalidIdException</code>. Thrown to indicate
 * that the application has attempted to create an OrderID but that OrderID does not have
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

public class OrderIDException extends InvalidIdException{
	public OrderIDException(String msg) {
		super(msg);
	}
}
