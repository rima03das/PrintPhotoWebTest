package in.pulseinfotech.printphoto.dto.payment;

import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * This class holds details for payments made. It has details like Payment date,
 * amount paid and the time.
 * 
 * @author Rima Das
 * @version 1.0
 * @since 20 September 2014 <br>
 * <br>
 * <br>
 * 
 *        {@link in.pulseinfotech.printphoto.dto.payment.PaymentDetails#paymentDate
 *        Payment Date},
 *        {@link in.pulseinfotech.printphoto.dto.payment.PaymentDetails#paymentAmount
 *        Payment Amount},
 *        {@link in.pulseinfotech.printphoto.dto.payment.PaymentDetails#timeStamp
 *        TimeStamp}
 * 
 */
@Embeddable
public class PaymentDetails {

	/**
	 * This field holds the date on which the payment was made
	 */
	@Temporal(TemporalType.DATE)
	private Date paymentDate;

	/**
	 * This field holds the payment amount
	 */
	private double paymentAmount;

	/**
	 * This field holds the time of payment.
	 */
	@Temporal(TemporalType.DATE)
	private Date timeStamp;

	/**
	 * 
	 * @return
	 */
	public Date getPaymentDate() {
		return paymentDate;
	}

	/**
	 * 
	 * @param paymentDate
	 */
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	/**
	 * 
	 * @return
	 */
	public double getPaymentAmount() {
		return paymentAmount;
	}

	/**
	 * 
	 * @param paymentAmount
	 */
	public void setPaymentAmount(double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	/**
	 * 
	 * @return
	 */
	public Date getTimeStamp() {
		return timeStamp;
	}

	/**
	 * 
	 * @param timeStamp
	 */
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

}
