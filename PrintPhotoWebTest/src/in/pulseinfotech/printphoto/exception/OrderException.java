package in.pulseinfotech.printphoto.exception;

/**
 * 
 * This class is a base class  for all kinds of order exceptions. 
 * 
 * @author Raman Ahuja
 * @version 1.0
 * @since 16 September 2014 <br>
 * <br>
 * <br>
 * 
 */
public class OrderException extends Exception{
	public OrderException(String msg) {
		super(msg);
	}
}
