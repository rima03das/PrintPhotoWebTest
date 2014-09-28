package in.pulseinfotech.printphoto.services;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * This class handles all the Printing services
 * 
 * @author Raman Ahuja
 * @version 1.0
 * @since 16 September 2014 <br>
 * 
 */
public class PhotoPrintManager {

	List<String> errorsList;

	/**
	 * This method collects all the error and returns them in a list
	 * 
	 * @return
	 */
	public PhotoPrintManager() {
		errorsList = new ArrayList<String>();
	}
}
