package in.pulseinfotech.printphoto.dto;



/**
 * This is an enumeration defining the state of the {@link User}. An user can either be Blocked or Free.   
 * 
 * @author Rima Das
 * @version 1.0
 * @since 16 September 2014 <br>
 * <br>
 *
 *{@link in.pulseinfotech.printphoto.dto.UserBlockedStatus#FREE FREE},
 *{@link in.pulseinfotech.printphoto.dto.UserBlockedStatus#BLOCKED BLOCKED}
 *
 */
public enum UserBlockedStatus {

	/**
	 * FREE: The user has not done anything unethically and is free to use our service. 
	 */
	FREE("free"), 
	/**
	 * BLOCKED: The user has done something unethically and is blocked from our service.
	 */
	BLOCKED("blocked");
	
	
	private String statusCode;
	
	private UserBlockedStatus(String statusCode){
		this.statusCode = statusCode;
	}
	
	/**
	 * 
	 * @return Status Code.
	 */
	public String getBlockedStatusCode() {
		return statusCode;
	}
	
}
