package in.pulseinfotech.printphoto.services.persistence;

import in.pulseinfotech.printphoto.dto.Order;
import in.pulseinfotech.printphoto.dto.OrderStatus;
import in.pulseinfotech.printphoto.dto.User;
import in.pulseinfotech.printphoto.services.logging.PrintPhotoLogger;
import in.pulseinfotech.printphoto.services.logging.PrintPhotoLogger.LOG;
import in.pulseinfotech.printphoto.services.management.TrackingService;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * This class is a subclass <code>PersistenceService</code> defining the mail
 * template for Order Services.
 * 
 * @author Raman Ahuja
 * @version 1.0
 * @since 16 September 2014 <br>
 * <br>
 * @see PersistenceService
 * 
 */
public class OrderService extends PersistenceService {

	private static String FQCN = OrderService.class.getName();
	/**
	 * static block for logger info.
	 */
	static {
		PrintPhotoLogger.log4j(FQCN, LOG.INFO, "Order Service Loaded.", null);
	}

	/**
	 * 
	 * @param order
	 * @return Boolean
	 */
	public boolean saveOrder(Order order) {
		return false;
	}

	/**
	 * 
	 * @param order
	 * @return boolean
	 */
	public boolean cancelOrder(Order order) {

		return false;
	}

	/**
	 * 
	 * @param order
	 * @return null
	 */
	public Order checkOrderStatus(Order order) {
		return null;
	}

	/**
	 * 
	 * @param orderId
	 * @return
	 */
	public OrderStatus checkOrderStatus(long orderId) {
		return null;
	}

	/**
	 * 
	 * @param orderId
	 * @return boolean
	 */
	public boolean cancelOrder(long orderId) {
		return false;
	}

	/**
	 * 
	 * @param orerId
	 * @return
	 */
	public Order getOrder(long orerId) {
		return null;
	}

	/**
	 * 
	 * @param user
	 * @return
	 */
	public List<Order> getOrder(User user) {
		return null;
	}

	List<String> errorsList;

	/**
	 * This method collects all the error and returns them in a list
	 * 
	 * @return
	 */
	public OrderService() {
		errorsList = new ArrayList<String>();
	}

	@Override
	protected void finalize() throws Throwable {
		PrintPhotoLogger.log4j(FQCN, LOG.INFO, "Order Service UnLoaded.", null);
	}
}
