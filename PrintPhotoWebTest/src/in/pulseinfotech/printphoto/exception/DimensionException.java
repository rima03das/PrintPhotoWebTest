package in.pulseinfotech.printphoto.exception;

/**
 * 
 * Thrown to indicate that the application has attempted to create a dimension but
 * that dimension does not have the appropriate format.
 * 
 * @author Raman Ahuja
 * @version 1.0
 * @since 16 September 2014 <br>
 * <br>
 */
public class DimensionException extends Exception{
	public DimensionException(String msg) {
		super(msg);
	}
}
