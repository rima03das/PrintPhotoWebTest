package in.pulseinfotech.printphoto.services.management;

import in.pulseinfotech.printphoto.dto.OrderTrack;
import in.pulseinfotech.printphoto.services.communication.template.OrderTemplate;
import in.pulseinfotech.printphoto.services.logging.PrintPhotoLogger;
import in.pulseinfotech.printphoto.services.logging.PrintPhotoLogger.LOG;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * This class is a subclass <code>ManagementService</code> defining the Tracking
 * Services.
 * 
 * @author Raman Ahuja
 * @version 1.0
 * @since 16 September 2014 <br>
 * <br>
 * @see ManagementService
 */
public class TrackingService extends ManagementService {

	private static String FQCN = TrackingService.class.getName();
	/**
	 * static block for logger info.
	 */
	static {
		PrintPhotoLogger
				.log4j(FQCN, LOG.INFO, "Tracking Service Loaded.", null);
	}

	List<String> errorsList;

	/**
	 * This method collects all the error and returns them in a list
	 * 
	 * @return
	 */
	public TrackingService() {
		errorsList = new ArrayList<String>();
	}

	/**
	 * 
	 * @param orderTrack
	 * @return
	 */
	public boolean saveOrderTrack(OrderTrack orderTrack) {
		return false;
	}

	/**
	 * 
	 * @param orderTrack
	 * @return
	 */
	public boolean deleteOrderTrack(OrderTrack orderTrack) {
		return false;
	}

	/**
	 * 
	 * @param orderTrackId
	 * @return
	 */
	public boolean deleteOrderTrack(long orderTrackId) {
		return false;
	}

	/**
	 * 
	 * @param orderTrack
	 * @return
	 */
	public OrderTrack getOrderTrack(long orderTrack) {
		return null;
	}

	@Override
	protected void finalize() throws Throwable {
		PrintPhotoLogger.log4j(FQCN, LOG.INFO, "Tracking Service UnLoaded.",
				null);
	}
}
