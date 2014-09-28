package in.pulseinfotech.printphoto.dto.payment;

import in.pulseinfotech.printphoto.exception.NoteSerialNumberException;
import in.pulseinfotech.printphoto.exception.TrackingIDException;
import in.pulseinfotech.printphoto.services.communication.MailService;
import in.pulseinfotech.printphoto.services.logging.PrintPhotoLogger;
import in.pulseinfotech.printphoto.services.logging.PrintPhotoLogger.LOG;

/**
 * 
 * This class is a subclass of <code>PaymentMode</code> and holds details for
 * payments made Online. It has details like transaction id and receipt number.
 * 
 * @author Rima Das
 * @version 1.0
 * @since 20 September 2014 <br>
 * <br>
 * <br>
 * 
 *        {@link in.pulseinfotech.printphoto.dto.payment.OnlineMode#receiptNumber
 *        Receipt Number},
 *        {@link in.pulseinfotech.printphoto.dto.payment.OnlineMode#transactionId
 *        Transaction Id}
 * 
 * @see PaymentMode
 * 
 */
public class OnlineMode extends PaymentMode {
	private static String FQCN = OnlineMode.class.getName();
	/**
	 * This field holds the online transaction id.
	 */
	private long transactionId;

	/**
	 * This field holds the receipt number.
	 */
	private long receiptNumber;

	/**
	 * 
	 * @return
	 */
	public long getTransactionId() {
		return transactionId;
	}

	/**
	 * 
	 * @param transactionId
	 */
	public void setTransactionId(long transactionId) throws TrackingIDException {
		if (transactionId >= 0) {
			this.transactionId = transactionId;
		} else {
			PrintPhotoLogger.log4j(FQCN, LOG.ERROR, "Negative transaction ID.",
					new TrackingIDException(" Negative transaction ID "));
			throw new TrackingIDException(" Negative transaction ID ");
		}
	}

	/**
	 * 
	 * @return receipt Number
	 */
	public long getReceiptNumber() {
		return receiptNumber;
	}

	/**
	 * 
	 * @param receiptNumber
	 */
	public void setReceiptNumber(long receiptNumber) {
		this.receiptNumber = receiptNumber;
	}

}
