package in.pulseinfotech.printphoto.exception;



/**
 * 
 * This class is a subclass of <code>OrderException</code>. Thrown to indicate
 * that the status of an order is invalid.
 * 
 * @author Raman Ahuja
 * @version 1.0
 * @since 16 September 2014 <br>
 * <br>
 * <br>
 * @see OrderException
 * 
 */
public class OrderStatusException extends OrderException{
	public OrderStatusException(String msg) {
		super(msg);
	}
}
