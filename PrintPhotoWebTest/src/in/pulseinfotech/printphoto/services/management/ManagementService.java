package in.pulseinfotech.printphoto.services.management;

import in.pulseinfotech.printphoto.services.communication.SMSService;
import in.pulseinfotech.printphoto.services.logging.PrintPhotoLogger;
import in.pulseinfotech.printphoto.services.logging.PrintPhotoLogger.LOG;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * This class is an abstract class defining the various Management Services.
 * 
 * @author Raman Ahuja
 * @version 1.0
 * @since 16 September 2014 <br>
 * <br>
 * @see PaymentService
 * @see PrintingService
 * @see RateService
 * @see TrackingService
 * 
 */
public abstract class ManagementService {

	private static String FQCN = ManagementService.class.getName();
	/**
	 * static block for logger info.
	 */
	static {
		PrintPhotoLogger.log4j(FQCN, LOG.INFO, "Management Service Loaded.",
				null);
	}

	List<String> errorsList;

	/**
	 * This method collects all the error and returns them in a list
	 * 
	 * @return
	 */
	public ManagementService() {
		errorsList = new ArrayList<String>();
	}

	@Override
	protected void finalize() throws Throwable {
		PrintPhotoLogger.log4j(FQCN, LOG.INFO, "Management Service UnsLoaded.",
				null);
	}
}
