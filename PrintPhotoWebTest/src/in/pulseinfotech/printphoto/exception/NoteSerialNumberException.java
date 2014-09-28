package in.pulseinfotech.printphoto.exception;

/**
 * * This class is a subclass of <code>NoteValueException</code>. Thrown to
 * indicate that the application has attempted to insert a serial number which does not comply with the convention.
 * 
 * @author Rima Das
 * @version 1.0
 * @since 21 September 2014 <br>
 * <br>
 * <br>
 * 
 * @see NoteValueException
 * 
 */
public class NoteSerialNumberException extends NoteValueException {

	public NoteSerialNumberException(String msg) {
		super(msg);
	}

}
