package in.pulseinfotech.printphoto.dto.payment;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * This class is a subclass of <code>PaymentMode</code> and holds details for
 * payments made by Cards. It has details like Card number, transaction id and
 * card expiry date.
 * 
 * @author Rima Das
 * @version 1.0
 * @since 20 September 2014 <br>
 * <br>
 * <br>
 * 
 *        {@link in.pulseinfotech.printphoto.dto.payment.CardMode#cardExpiryDate
 *        Card Expiry Date},
 *        {@link in.pulseinfotech.printphoto.dto.payment.CardMode#cardNumber
 *        Card Number},
 *        {@link in.pulseinfotech.printphoto.dto.payment.CardMode#transactionId
 *        Transaction Id}
 * 
 * @see PaymentMode
 */
@Entity
public class CardMode extends PaymentMode {

	/**
	 * This field holds the card number.
	 */
	private long cardNumber;

	/**
	 * This field holds the transaction id.
	 */
	private long transactionId;

	/**
	 * This field holds the card's Expiry Date.
	 */
	@Temporal(TemporalType.DATE)
	private Date cardExpiryDate;

	/**
	 * 
	 * @return cardNumber
	 */
	public long getCardNumber() {
		return cardNumber;
	}

	/**
	 * 
	 * @param cardNumber
	 */
	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}

	/**
	 * 
	 * @return transactionId
	 */
	public long getTransactionId() {
		return transactionId;
	}

	/**
	 * 
	 * @param transactionId
	 */
	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}

	/**
	 * 
	 * @return cardExpiryDate
	 */
	public Date getCardExpiryDate() {
		return cardExpiryDate;
	}

	/**
	 * 
	 * @param cardExpiryDate
	 */
	public void setCardExpiryDate(Date cardExpiryDate) {
		this.cardExpiryDate = cardExpiryDate;
	}

}
