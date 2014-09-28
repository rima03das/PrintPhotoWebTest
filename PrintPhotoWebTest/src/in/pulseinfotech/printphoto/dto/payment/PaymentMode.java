package in.pulseinfotech.printphoto.dto.payment;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import in.pulseinfotech.printphoto.exception.PaymentModeIdException;
import in.pulseinfotech.printphoto.services.logging.PrintPhotoLogger;
import in.pulseinfotech.printphoto.services.logging.PrintPhotoLogger.LOG;

/**
 * 
 * This class is the base class for all the modes of payment.
 * 
 * @author Rima Das,Gufran Khurshid
 * @version 1.1
 * @since 20 September 2014 <br>
 * <br>
 * <br>
 * @see CardMode
 * @see DDMode
 * @see CashMode
 * @see OnlineMode
 * @see ChequeMode
 * 
 */
@Entity
public class PaymentMode {
	private static String FQCN = PaymentMode.class.getName();
	/**
	 * This field holds the paymentModeId.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long paymentModeId;

	/**
	 * 
	 * @return
	 */
	public long getPaymentModeId() {
		return paymentModeId;
	}

	/**
	 * 
	 * @param paymentModeId
	 */
	public void setPaymentModeId(long paymentModeId)
			throws PaymentModeIdException {
		if (paymentModeId >= 0) {
			this.paymentModeId = paymentModeId;
		} else {
			PrintPhotoLogger.log4j(FQCN, LOG.ERROR,
					"Negative payment mode ID.", new PaymentModeIdException(
							" Negative payment mode ID "));
			throw new PaymentModeIdException(" Negative payment mode ID ");
		}
	}

}
