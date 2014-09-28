package in.pulseinfotech.printphoto.services.persistence;

import java.util.ArrayList;
import java.util.List;

import in.pulseinfotech.printphoto.dto.Address;
import in.pulseinfotech.printphoto.dto.Order;
import in.pulseinfotech.printphoto.dto.User;
import in.pulseinfotech.printphoto.dto.UserBlockedStatus;
import in.pulseinfotech.printphoto.dto.UserStatus;
import in.pulseinfotech.printphoto.services.logging.PrintPhotoLogger;
import in.pulseinfotech.printphoto.services.logging.PrintPhotoLogger.LOG;

/**
 * 
 * This class is a subclass <code>PersistenceService</code> defining the mail
 * template for user Services.
 * 
 * @author Raman Ahuja
 * @version 1.0
 * @since 16 September 2014 <br>
 * <br>
 * @see PersistenceService
 * 
 */
public class UserService extends PersistenceService {

	private static String FQCN = UserService.class.getName();
	/**
	 * static block for logger info.
	 */
	static {
		PrintPhotoLogger.log4j(FQCN, LOG.INFO, "User Service Loaded.", null);
	}

	/**
	 * 
	 * @param u
	 *            Reference of {@link User}
	 * @return
	 */
	public boolean addUser(User u) {
		return false;
	}

	/**
	 * 
	 * @param u
	 *            list of reference of {@link User}
	 * @return
	 */
	public boolean addUser(User... u) {
		return false;
	}

	/**
	 * 
	 * @param u
	 *            Reference of {@link User}
	 * @return
	 */
	public boolean deleteUser(User u) {
		return false;
	}

	/**
	 * 
	 * @param emailId
	 * @return
	 */
	public boolean deleteUser(String emailId) {
		return false;
	}

	/**
	 * 
	 * @param phoneNumber
	 * @return
	 */
	public boolean deleteUser(long phoneNumber) {
		return false;
	}

	/**
	 * 
	 * @param emailId
	 * @return
	 */
	public User getUser(String emailId) {
		return (new User());
	}

	/**
	 * 
	 * @param mobNumber
	 * @return
	 */
	public User getUser(long mobNumber) {
		return (new User());
	}

	/**
	 * 
	 * @param id
	 * @param name
	 * @param mobNumber
	 * @param emailId
	 * @param password
	 * @param defaultAddress
	 * @param userStatus
	 * @param userBlockedStatus
	 * @param comment
	 * @return
	 */
	public User getUser(long id, String name, long mobNumber, String emailId,
			String password, Address defaultAddress, UserStatus userStatus,
			UserBlockedStatus userBlockedStatus, String userComment) {
		return (new User());
	}

	/**
	 * 
	 * @param u
	 *            Reference of {@link User}
	 * @return
	 */
	public boolean blockUser(User u) {
		return false;
	}

	/**
	 * @param u
	 *            Reference of {@link User}
	 * @return
	 */
	public boolean unBlockUser(User u) {
		return false;
	}

	/**
	 * 
	 * @param u
	 *            Reference of {@link User}
	 * @return
	 */
	public boolean authenticate(User u) {
		return false;
	}

	/**
	 * 
	 * @param u
	 *            Reference of {@link User}
	 * @return
	 */
	public List<Order> getOrderHistory(User u) {
		return null;
	}

	/**
	 * 
	 * @param u
	 *            Reference of {@link User}
	 * @return
	 */
	public boolean updateOrderStatus(User u) {
		return false;
	}

	List<String> errorsList;

	/**
	 * This method collects all the error and returns them in a list
	 * 
	 * @return
	 */
	public UserService() {
		errorsList = new ArrayList<String>();
	}

	@Override
	protected void finalize() throws Throwable {
		PrintPhotoLogger.log4j(FQCN, LOG.INFO, "User Service UnLoaded.", null);
	}
}
