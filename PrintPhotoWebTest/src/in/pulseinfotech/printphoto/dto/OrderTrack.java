package in.pulseinfotech.printphoto.dto;

import in.pulseinfotech.printphoto.exception.AddressException;
import in.pulseinfotech.printphoto.exception.OrderException;
import in.pulseinfotech.printphoto.exception.OrderStatusException;
import in.pulseinfotech.printphoto.exception.TrackingIDException;
import in.pulseinfotech.printphoto.exception.UserIDException;
import in.pulseinfotech.printphoto.services.communication.MailService;
import in.pulseinfotech.printphoto.services.logging.PrintPhotoLogger;
import in.pulseinfotech.printphoto.services.logging.PrintPhotoLogger.LOG;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * This class keeps track of all the orders that had been placed through the
 * system. It generates an unique id and holds details like references of
 * <code>Order</code>, <code> OrderStatus</code> and Delivery
 * <code>Address</code>. Along with those it also keeps track of proposed
 * delivery date, actual delivery date and Shipment date.
 * 
 * @author Rima Das
 * @version 1.1
 * @since 16 September 2014 <br>
 * <br>
 * <br>
 * 
 *        {@link in.pulseinfotech.printphoto.dto.OrderTrack#trackingId Tracking
 *        Id},
 *        {@link in.pulseinfotech.printphoto.dto.OrderTrack#actualDeliveryDate
 *        Actual delivery date},
 *        {@link in.pulseinfotech.printphoto.dto.OrderTrack#OrderTrackComment
 *        OrderTrackComment},
 *        {@link in.pulseinfotech.printphoto.dto.OrderTrack#deliveryAddress
 *        Delivery Address},
 *        {@link in.pulseinfotech.printphoto.dto.OrderTrack#order Order},
 *        {@link in.pulseinfotech.printphoto.dto.OrderTrack#orderStatus Order
 *        Status},
 *        {@link in.pulseinfotech.printphoto.dto.OrderTrack#proposedDeliveryDate
 *        Proposed Delivery Date},
 *        {@link in.pulseinfotech.printphoto.dto.OrderTrack#shipmentDate
 *        Shipment Date},
 * 
 * @see Order
 * @see OrderStatus
 * @see Address
 */
@Entity
public class OrderTrack {
	private static String FQCN = OrderTrack.class.getName();
	/**
	 * This field holds an id to uniquely identify an {@link Order} and trace
	 * its path.
	 */
	@Id
	private long trackingId;

	/**
	 * This field holds a reference of {@link Order}
	 */
	@OneToOne
	private Order order;

	/**
	 * This field tells the current status of the {@link Order}
	 * 
	 * @see OrderStatus
	 */
	@Enumerated(EnumType.STRING)
	private OrderStatus orderStatus;

	/**
	 * This field holds the date when the {@link Order} was dispatched.
	 */
	@Temporal(TemporalType.DATE)
	private Date shipmentDate;

	/**
	 * This field holds the proposed date when the {@link Order} was supposed to
	 * be dispatched.
	 */
	@Temporal(TemporalType.DATE)
	private Date proposedDeliveryDate;

	/**
	 * This field holds the actual date when the {@link Order} was really
	 * dispatched.
	 */
	@Temporal(TemporalType.DATE)
	private Date actualDeliveryDate;

	/**
	 * This field holds the {@link Address} to where the {@link Order} was
	 * dispatched.
	 */
	@Temporal(TemporalType.DATE)
	private Address deliveryAddress;

	/**
	 * This field holds a reference of {@link Shipper}
	 * 
	 * @since 18 September 2014 <br>
	 *        <p>
	 *        This field is added in version 1.1
	 *        </p>
	 * 
	 */

	@OneToOne
	private Shipper shipper;

	/**
	 * This field holds the comments.
	 */
	private String OrderTrackComment;

	/**
	 * This field holds the trackStatus.
	 */
	private OrderStatus trackStatus;

	/**
	 * 
	 * @return Tracking Id
	 */
	public long getTrackingId() {
		return trackingId;
	}

	/**
	 * 
	 * @param trackingId
	 */
	public void setTrackingId(long trackingId) throws TrackingIDException {
		if (trackingId >= 0) {
			this.trackingId = trackingId;
		} else {
			PrintPhotoLogger.log4j(FQCN, LOG.ERROR, "Negative Tracking ID .",
					new TrackingIDException(" Negative Tracking ID "));
			throw new TrackingIDException(" Negative Tracking ID ");
		}
	}

	/**
	 * 
	 * @return {@link Order}
	 */
	public Order getOrder() {
		return order;
	}

	/**
	 * 
	 * @param order
	 * @see Order
	 */
	public void setOrder(Order order) throws OrderException {
		if (order != null) {
			this.order = order;
		} else {
			PrintPhotoLogger.log4j(FQCN, LOG.ERROR,
					"Null reference received for order.", new OrderException(
							"Null reference received for order."));
			throw new OrderException("Null reference received for order.");
		}
	}

	/**
	 * 
	 * @return {@link OrderStatus}
	 */
	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	/**
	 * 
	 * @param orderStatus
	 * @throws OrderStatusException
	 */
	public void setOrderStatus(OrderStatus orderStatus)
			throws OrderStatusException {

		if (orderStatus != null) {
			if (orderStatus.equals(OrderStatus.CANCELLED)
					|| orderStatus.equals(OrderStatus.CONFIRMED)
					|| orderStatus.equals(OrderStatus.UNCONFIRMED)
					|| orderStatus.equals(OrderStatus.SHIPPED)
					|| orderStatus.equals(OrderStatus.PRINTING)
					|| orderStatus.equals(OrderStatus.PRINTED)
					|| orderStatus.equals(OrderStatus.DELIVERED)
					|| orderStatus.equals(OrderStatus.NEW)) {
				this.orderStatus = orderStatus;
			} else {
				PrintPhotoLogger
						.log4j(FQCN,
								LOG.ERROR,
								"Invalid Order Status received. The value should be one of the following: NEW, DELIVERED, PRINTED, PRINTING, SHIPPED, UNCONFIRMED, CONFIRMED, CANCELLED.",
								new OrderStatusException(
										"Invalid Order Status received. The value should be one of the following: NEW, DELIVERED, PRINTED, PRINTING, SHIPPED, UNCONFIRMED, CONFIRMED, CANCELLED"));
				throw new OrderStatusException(
						"Invalid Order Status received. The value should be one of the following: NEW, DELIVERED, PRINTED, PRINTING, SHIPPED, UNCONFIRMED, CONFIRMED, CANCELLED");
			}
		} else {
			PrintPhotoLogger.log4j(FQCN, LOG.ERROR,
					"Null reference received for Order Status.",
					new OrderStatusException(
							"Null reference received for Order Status."));
			throw new OrderStatusException(
					"Null reference received for Order Status.");
		}

	}

	/**
	 * 
	 * @return Shipement Date
	 */
	public Date getShipmentDate() {
		return shipmentDate;
	}

	/**
	 * 
	 * @param shipmentDate
	 */
	public void setShipmentDate(Date shipmentDate) {
		this.shipmentDate = shipmentDate;
	}

	/**
	 * 
	 * @return Proposed Delivery Date
	 */
	public Date getProposedDeliveryDate() {
		return proposedDeliveryDate;
	}

	/**
	 * 
	 * @param proposedDeliveryDate
	 */
	public void setProposedDeliveryDate(Date proposedDeliveryDate) {
		this.proposedDeliveryDate = proposedDeliveryDate;
	}

	/**
	 * 
	 * @return Actual Delivery Date
	 */
	public Date getActualDeliveryDate() {
		return actualDeliveryDate;
	}

	/**
	 * 
	 * @param actualDeliveryDate
	 */
	public void setActualDeliveryDate(Date actualDeliveryDate) {
		this.actualDeliveryDate = actualDeliveryDate;
	}

	/**
	 * 
	 * @return Delivery Address
	 */
	public Address getDeliveryAddress() {
		return deliveryAddress;
	}

	/**
	 * 
	 * @param deliveryAddress
	 * @throws AddressException
	 */
	public void setDeliveryAddress(Address deliveryAddress)
			throws AddressException {
		if (deliveryAddress != null) {
			this.deliveryAddress = deliveryAddress;
		} else {
			PrintPhotoLogger
					.log4j(FQCN, LOG.ERROR,
							"Null reference recwived for address",
							new AddressException(
									"Null reference recwived for address"));
			throw new AddressException("Null reference recwived for address");
		}
	}

	/**
	 * 
	 * @return OrderTrackComment
	 */
	public String getOrderTrackComment() {
		return OrderTrackComment;
	}

	/**
	 * 
	 * @param OrderTrackcomment
	 */

	public void setOrderTrackComment(String orderTrackComment) {
		this.OrderTrackComment = orderTrackComment;
	}

	/**
	 * 
	 * @return
	 */
	public Shipper getShipper() {
		return shipper;
	}

	/**
	 * 
	 * @param shipper
	 */
	public void setShipper(Shipper shipper) {
		this.shipper = shipper;
	}

	/**
	 * 
	 * @return
	 */
	public OrderStatus getTrackStatus() {
		return trackStatus;
	}

	/**
	 * 
	 * @param trackStatus
	 */
	public void setTrackStatus(OrderStatus trackStatus) {
		this.trackStatus = trackStatus;
	}

}
