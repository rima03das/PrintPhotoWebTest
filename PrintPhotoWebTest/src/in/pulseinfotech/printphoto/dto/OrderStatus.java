package in.pulseinfotech.printphoto.dto;

/**
 * This is an enumeration defining the the various status of an {@link Order}.
 * 
 * @author Rima Das
 * @version 1.0
 * @since 16 September 2014 <br>
 * <br>
 * <br>
 * 
 *  {@link in.pulseinfotech.printphoto.dto.OrderStatus#NEW NEW},
 *  {@link in.pulseinfotech.printphoto.dto.OrderStatus#UNCONFIRMED UNCONFIRMED},
 *  {@link in.pulseinfotech.printphoto.dto.OrderStatus#CONFIRMED CONFIRMED},
 *  {@link in.pulseinfotech.printphoto.dto.OrderStatus#PRINTING PRINTING},
 *  {@link in.pulseinfotech.printphoto.dto.OrderStatus#PRINTED PRINTED},
 *  {@link in.pulseinfotech.printphoto.dto.OrderStatus#SHIPPED SHIPPED},
 *  {@link in.pulseinfotech.printphoto.dto.OrderStatus#DELIVERED DELIVERED},
 *  {@link in.pulseinfotech.printphoto.dto.OrderStatus#CANCELLED CANCELLED}
 * 
 */

public enum OrderStatus {

	/**
	 * NEW: The Order has just being placed. No further verification or
	 * confirmation has yet been done
	 */
	NEW("new"), 
	/**
	 * UNCONFIRMED:
	 */
	UNCONFIRMED("unconfirmed"), 
	/**
	 * CONFIRMED: The order has been confirmed and is ready to be taken up.
	 */
	CONFIRMED("confirmed"), 
	
	/**
	 * PRINTING: The order has been picked up by the lab for printing and its under processing.
	 */
	PRINTING("printing"), 
	/**
	 * PRINTED: Lab has completed the order but it has not yet being dispatched. 
	 */
	PRINTED("printed"), 
	
	/**
	 * SHIPPED: The order has been dispatched for the delivery address
	 */
	SHIPPED("shiPped"), 
	
	/**
	 * DEIVERED: The order has been delivered and accepted by the user.  
	 */
	DELIVERED("delivered"), 
	
	/**
	 * CANCELLED: The order has been cancelled by the user before it was taken by the lab.
	 */
	CANCELLED("cancelled");

	private String orderStatus;

	private OrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	/**
	 * 
	 * @return Order Status
	 */
	public String getOrderStatus() {
		return orderStatus;
	}

}
