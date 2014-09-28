package in.pulseinfotech.printphoto.dto;

import in.pulseinfotech.printphoto.dto.payment.Payment;
import in.pulseinfotech.printphoto.exception.AddressException;
import in.pulseinfotech.printphoto.exception.OrderIDException;
import in.pulseinfotech.printphoto.exception.UserException;
import in.pulseinfotech.printphoto.services.logging.PrintPhotoLogger;
import in.pulseinfotech.printphoto.services.logging.PrintPhotoLogger.LOG;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * This class holds the details of an order placed by an user. It saves the
 * Order ID, User Details as an reference to User, List of products, delivery
 * address.
 * 
 * @author Rima Das,Gufran Khurshid
 * @version 1.1
 * @since 16 September 2014 <br>
 * <br>
 * <br>
 * 
 *        {@link in.pulseinfotech.printphoto.dto.Order#orderId OrderID},
 *        {@link in.pulseinfotech.printphoto.dto.Order#user User},
 *        {@link in.pulseinfotech.printphoto.dto.Order#productList Product List}
 *        , {@link in.pulseinfotech.printphoto.dto.Order#deliveryAddress
 *        Delivery Address},
 *        {@link in.pulseinfotech.printphoto.dto.Order#orderComment
 *        OrderComment}
 */

@Entity
@Table(name="ORDER_JI")
public class Order {

	private static String FQCN = Order.class.getName();

	/**
	 * This member variable holds an id to uniquely identify an order
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long orderId;

	/**
	 * This is a reference variable pointing to the User. User holds all the
	 * details about an user that he had entered during registration.
	 */
	@OneToOne
	private User user;

	/**
	 * This member variable holds a list of Products that an user has requested
	 * for.
	 */
	@OneToMany
	
	private List<Product> productList = new ArrayList<Product>();

	/**
	 * This member variable holds the address to where the order is to be
	 * delivered. This is a reference of the {@link Address} class.
	 */
	@Embedded
	private Address deliveryAddress;

	/**
	 * This member variable holds the payment details associated with the order.
	 * This is a reference of the {@link Payment} class.
	 */
	@OneToOne
	Payment payment;

	/**
	 * 
	 */
	private String orderComment;

	//
	// private Date orderDate;
	//
	//
	// public Date getOrderDate() {
	// return orderDate;
	// }
	//
	// public void setOrderDate(Date orderDate) {
	// this.orderDate = orderDate;
	// }

	/**
	 * 
	 * @return The OrderId
	 */
	public long getOrderId() {
		return orderId;
	}

	/**
	 * 
	 * @param orderId
	 *            Sets the order ID
	 * @throws OrderIDException
	 */
	public void setOrderId(long orderId) throws OrderIDException {

		if (orderId >= 0) {
			this.orderId = orderId;

		} else {
			PrintPhotoLogger.log4j(FQCN, LOG.ERROR, "Negative Order ID",
					new OrderIDException(" Negative Order ID "));
			throw new OrderIDException(" Negative Order ID ");
		}
	}

	/**
	 * 
	 * @return The reference of an {@link User}
	 */
	public User getUser() {
		return user;
	}

	/**
	 * 
	 * @param user
	 *            Sets the reference of an {@link User}
	 * @throws UserException
	 */
	public void setUser(User user) throws UserException {
		if (user != null) {
			this.user = user;
		} else {
			PrintPhotoLogger.log4j(FQCN, LOG.ERROR,
					"NUll value received for User", new UserException(
							"NUll value received for User"));
			throw new UserException("NUll value received for User");
		}
	}

	/**
	 * 
	 * @return The list of product ordered.
	 */
	public List<Product> getProductList() {
		return productList;
	}

	/**
	 * 
	 * @param productList
	 *            Sets the list of product ordered
	 */
	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	/**
	 * 
	 * @return The reference of an {@link Address}
	 */
	public Address getDeliveryAddress() {
		return deliveryAddress;
	}

	/**
	 * 
	 * @param deliveryAddress
	 *            Sets the reference of an {@link Address}
	 * @throws AddressException
	 */
	public void setDeliveryAddress(Address deliveryAddress)
			throws AddressException {
		if (deliveryAddress != null) {
			this.deliveryAddress = deliveryAddress;
		} else {
			PrintPhotoLogger
					.log4j(FQCN, LOG.ERROR,
							"Null reference received for address",
							new AddressException(
									"Null reference received for address"));
			throw new AddressException("Null reference received for address");
		}
	}

	/**
	 * 
	 * @return Any comment entered about the order.
	 */
	public String getOrderComment() {
		return orderComment;
	}

	/**
	 * 
	 * @param orderComment
	 *            Sets any comment entered about the order.
	 */
	public void setOrderComment(String orderComment) {
		this.orderComment = orderComment;
	}

	/**
	 * 
	 * @return
	 */
	public Payment getPayment() {
		return payment;
	}

	/**
	 * 
	 * @param payment
	 */
	public void setPayment(Payment payment) {
		this.payment = payment;
	}

}
