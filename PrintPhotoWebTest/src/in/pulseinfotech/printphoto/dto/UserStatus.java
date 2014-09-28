package in.pulseinfotech.printphoto.dto;


/**
 * This is an enumeration defining the status of the {@link User}.
 * 
 * @author Rima Das
 * @version 1.0
 * @since 16 September 2014 <br>
 * <br>
 * 
 *        {@link in.pulseinfotech.printphoto.dto.UserStatus#BEGINNER BEGINNER},
 *        {@link in.pulseinfotech.printphoto.dto.UserStatus#PRO PRO},
 *        {@link in.pulseinfotech.printphoto.dto.UserStatus#CHAMPION CHAMPION},
 *        {@link in.pulseinfotech.printphoto.dto.UserStatus#EXPERT EXPERT}
 * 
 */
public enum UserStatus {

	/**
	 * BEGINNER: The user has just logged in Or is very new to the system OR has not ordered/received any oder yet.
	 */
	BEGINNER ("beginner"), 
	
	
	/**
	 * PRO: The user has ordered and received the delivery but had not used Cash on Delivery.
	 */
	PRO("pro"), 
	
	/**
	 * CHAMPION: The user has ordered and received the delivery but has successfully used Cash on Delivery.
	 */
	CHAMPION("champion"), 
	/**
	 * EXPERT: The user is a regular customer.
	 */
	EXPERT("expert");
	
	private String statusCode;
	
	private UserStatus(String statusCode) {
		this.statusCode = statusCode;
	}
	
	/**
	 * 
	 * @return Status Code
	 */
 
	public String getStatusCode() {
		return statusCode;
	}
 
}
