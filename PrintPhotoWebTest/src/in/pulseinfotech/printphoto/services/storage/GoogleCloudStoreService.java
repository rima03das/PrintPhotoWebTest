package in.pulseinfotech.printphoto.services.storage;

import in.pulseinfotech.printphoto.services.logging.PrintPhotoLogger;
import in.pulseinfotech.printphoto.services.logging.PrintPhotoLogger.LOG;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * This class is a subclass of <code>CloudStoreService</code>. This class is
 * responsible for storing data over Google cloud.
 * 
 * @author Raman Ahuja
 * @version 1.0
 * @since 16 September 2014 <br>
 * <br>
 * @see CloudStoreService
 * 
 */

public class GoogleCloudStoreService extends CloudStoreService {

	private static String FQCN = GoogleCloudStoreService.class.getName();
	/**
	 * static block for logger info.
	 */
	static {
		PrintPhotoLogger.log4j(FQCN, LOG.INFO,
				"Google Cloud Store Service Loaded.", null);
	}

	List<String> errorsList;

	/**
	 * This method collects all the error and returns them in a list
	 * 
	 * @return
	 */
	public GoogleCloudStoreService() {
		errorsList = new ArrayList<String>();
	}

	@Override
	protected void finalize() throws Throwable {
		PrintPhotoLogger.log4j(FQCN, LOG.INFO,
				"Cloud Storage Service UnLoaded.", null);
	}
}
