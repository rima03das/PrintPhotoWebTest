package in.pulseinfotech.printphoto.dto.payment;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import in.pulseinfotech.printphoto.exception.PaymentDetailsException;
import in.pulseinfotech.printphoto.exception.PaymentIdException;
import in.pulseinfotech.printphoto.exception.PaymentModeException;
import in.pulseinfotech.printphoto.exception.PaymentStatusException;
import in.pulseinfotech.printphoto.exception.TrackingIDException;
import in.pulseinfotech.printphoto.services.communication.MailService;
import in.pulseinfotech.printphoto.services.logging.PrintPhotoLogger;
import in.pulseinfotech.printphoto.services.logging.PrintPhotoLogger.LOG;

/**
 * 
 * This class holds details for payments made. It has details like Payment id,
 * payment status, payment details and payment mode.
 * 
 * @author Rima Das,Gufran Khurshid
 * @version 1.1
 * @since 20 September 2014 <br>
 * <br>
 * <br>
 * 
 *        {@link in.pulseinfotech.printphoto.dto.payment.Payment#paymentId
 *        PaymentId},
 *        {@link in.pulseinfotech.printphoto.dto.payment.Payment#paymentDetails
 *        Payment Details},
 *        {@link in.pulseinfotech.printphoto.dto.payment.Payment#paymentComment
 *        Payment Comment},
 *        {@link in.pulseinfotech.printphoto.dto.payment.Payment#paymentMode
 *        Payment Mode},
 *        {@link in.pulseinfotech.printphoto.dto.payment.Payment#paymentStatus
 *        Payment Status}
 * 
 */

@Entity
public class Payment {
	private static String FQCN = Payment.class.getName();
	/**
	 * This fields uniquely identifies one payment
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long paymentId;

	/**
	 * This field holds the payment status for a particular payment.
	 * 
	 * @see PaymentStatus
	 */
	@Enumerated(EnumType.STRING)
	private PaymentStatus paymentStatus;

	/**
	 * This fields holds any comment about the payment
	 */
	private String paymentComment;

	/**
	 * This fields holds all the details about the payment
	 */
	@Embedded
	private PaymentDetails paymentDetails;

	/**
	 * This fields holds mode used for payment
	 */
	@OneToOne
	private PaymentMode paymentMode;

	/**
	 * 
	 * @return payment id
	 */
	public long getPaymentId() {
		return paymentId;
	}

	/**
	 * 
	 * @param paymentId
	 * @throws PaymentIdException
	 */
	public void setPaymentId(long paymentId) throws PaymentIdException {
		if (paymentId >= 0) {
			this.paymentId = paymentId;
		} else {
			PrintPhotoLogger.log4j(FQCN, LOG.ERROR, "Negative payment ID.",
					new PaymentIdException(" Negative payment ID "));
			throw new PaymentIdException(" Negative payment ID ");
		}
	}

	/**
	 * 
	 * @return payment status
	 */
	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}

	/**
	 * 
	 * @param paymentStatus
	 * @throws PaymentStatusException
	 */
	public void setPaymentStatus(PaymentStatus paymentStatus)
			throws PaymentStatusException {

		if (paymentStatus != null) {
			if (paymentStatus.equals(paymentStatus.PAID)
					|| paymentStatus.equals(paymentStatus.UNPAID)) {
				this.paymentStatus = paymentStatus;
			} else {
				PrintPhotoLogger
						.log4j(FQCN,
								LOG.ERROR,
								"Invalid payment status received. The valude should be either PAID or UNPAID.",
								new PaymentStatusException(
										"Invalid payment status received. The valude should be either PAID or UNPAID."));
				throw new PaymentStatusException(
						"Invalid payment status received. The valude should be either PAID or UNPAID.");
			}
		} else {
			PrintPhotoLogger.log4j(FQCN, LOG.ERROR,
					"Null value received for payment status.",
					new PaymentStatusException(
							"Null value received for payment status"));
			throw new PaymentStatusException(
					"Null value received for payment status");
		}
	}

	/**
	 * 
	 * @return payment comment
	 */
	public String getPaymentComment() {
		return paymentComment;
	}

	/**
	 * 
	 * @param paymentComment
	 */
	public void setPaymentComment(String paymentComment) {
		this.paymentComment = paymentComment;
	}

	/**
	 * 
	 * @return A reference of {@link PaymentDetails}
	 */
	public PaymentDetails getPaymentDetails() {
		return paymentDetails;
	}

	/**
	 * 
	 * @param paymentDetails
	 * @see PaymentDetails
	 * @throws PaymentDetailsException
	 */
	public void setPaymentDetails(PaymentDetails paymentDetails)
			throws PaymentDetailsException {
		if (paymentDetails != null) {
			this.paymentDetails = paymentDetails;
		} else {
			PrintPhotoLogger.log4j(FQCN, LOG.ERROR,
					"Null value received for PaymentDetails.",
					new PaymentDetailsException(
							"Null value received for PaymentDetails"));
			throw new PaymentDetailsException(
					"Null value received for PaymentDetails");
		}
	}

	/**
	 * 
	 * @return A reference of {@link PaymentMode}
	 */
	public PaymentMode getPaymentMode() {
		return paymentMode;
	}

	/**
	 * 
	 * @param paymentMode
	 * @throws PaymentModeException
	 * 
	 * @see PaymentMode
	 */
	public void setPaymentMode(PaymentMode paymentMode)
			throws PaymentModeException {
		if (paymentMode != null) {
			if (paymentMode instanceof PaymentMode) {
				this.paymentMode = paymentMode;
			} else {
				PrintPhotoLogger.log4j(FQCN, LOG.ERROR,
						"Null value received for payment Mode.",
						new PaymentModeException(
								"Null value received for payment Mode."));
				throw new PaymentModeException(
						"Null value received for payment Mode.");
			}
		} else {
			PrintPhotoLogger
					.log4j(FQCN,
							LOG.ERROR,
							"Invalid mode of payment set. The mode should be one of the following: CardMode, DDMode, CashMode, OnineMode or ChequeMode.",
							new PaymentModeException(
									"Invalid mode of payment set. The mode should be one of the following: CardMode, DDMode, CashMode, OnineMode or ChequeMode"));
			throw new PaymentModeException(
					"Invalid mode of payment set. The mode should be one of the following: CardMode, DDMode, CashMode, OnineMode or ChequeMode");
		}
	}

}
