package in.pulseinfotech.printphoto.services.management;

import in.pulseinfotech.printphoto.services.logging.PrintPhotoLogger;
import in.pulseinfotech.printphoto.services.logging.PrintPhotoLogger.LOG;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * This class is a subclass <code>ManagementService</code> defining the payment
 * Services.
 * 
 * @author Raman Ahuja
 * @version 1.0
 * @since 16 September 2014 <br>
 * <br>
 * @see ManagementService
 */
public class PaymentService extends ManagementService {

	private static String FQCN = PaymentService.class.getName();
	/**
	 * static block for logger info.
	 */
	static {
		PrintPhotoLogger.log4j(FQCN, LOG.INFO, "Payment Service Loaded.", null);
	}

	List<String> errorsList;

	/**
	 * This method collects all the error and returns them in a list
	 * 
	 * @return
	 */
	public PaymentService() {
		errorsList = new ArrayList<String>();
	}

	@Override
	protected void finalize() throws Throwable {
		PrintPhotoLogger.log4j(FQCN, LOG.INFO, "Payment Service UnLoaded.",
				null);
	}
}
