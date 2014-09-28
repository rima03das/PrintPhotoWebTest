package in.pulseinfotech.printphoto.services.storage;

import in.pulseinfotech.printphoto.services.logging.PrintPhotoLogger;
import in.pulseinfotech.printphoto.services.logging.PrintPhotoLogger.LOG;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * This class is a base class for all kind of storage services
 * 
 * @author Raman Ahuja
 * @version 1.0
 * @since 16 September 2014 <br>
 * <br>
 * @see CloudStoreService
 * @see LocalStoreService
 * @see VendorStoreService
 */
public abstract class StorageService {
	private static String FQCN = StorageService.class.getName();
	/**
	 * static block for logger info.
	 */
	static {
		PrintPhotoLogger.log4j(FQCN, LOG.INFO, "Storage Service Loaded.", null);
	}

	List<String> errorsList;

	public StorageService() {
		errorsList = new ArrayList<String>();
	}

	@Override
	protected void finalize() throws Throwable {
		PrintPhotoLogger.log4j(FQCN, LOG.INFO, "Storage Service UnLoaded.",
				null);
	}
}
