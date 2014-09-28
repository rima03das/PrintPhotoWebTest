package in.pulseinfotech.printphoto.exception;

/**
 * 
 * Thrown to indicate that the application has attempted to create an address
 * but that the address reference is null.
 * This is an independent class
 * 
 * @author Rima Das
 * @version 1.0
 * @since 16 September 2014 <br>
 * <br>
 * <br>
 * 
 */
public class AddressException extends Exception{

	public AddressException(String msg) {
		super(msg);
	}
}
