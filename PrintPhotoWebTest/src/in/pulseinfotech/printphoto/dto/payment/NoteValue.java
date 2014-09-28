package in.pulseinfotech.printphoto.dto.payment;


/**
 * This is an enumeration defining the values of a Note. A note can be of one of
 * the following: THOUSAND, FIVEHUNDRED, HUNDRED, FIFTY, TWENTY, TEN, FIVE, TWO
 * or ONE.
 * 
 * @author Rima Das
 * @version 1.0
 * @since 16 September 2014 <br>
 * <br>
 * 
 *        {@link in.pulseinfotech.printphoto.dto.payment.NoteValue#THOUSAND THOUSAND},
 *        {@link in.pulseinfotech.printphoto.dto.payment.NoteValue#FIVEHUNDRED FIVEHUNDRED},
 *        {@link in.pulseinfotech.printphoto.dto.payment.NoteValue#HUNDRED HUNDRED},
 *        {@link in.pulseinfotech.printphoto.dto.payment.NoteValue#FIFTY FIFTY},
 *        {@link in.pulseinfotech.printphoto.dto.payment.NoteValue#TWENTY TWENTY},
 *        {@link in.pulseinfotech.printphoto.dto.payment.NoteValue#TEN TEN},
 *        {@link in.pulseinfotech.printphoto.dto.payment.NoteValue#FIVE FIVE},
 *        {@link in.pulseinfotech.printphoto.dto.payment.NoteValue#TWO TWO},
 *        {@link in.pulseinfotech.printphoto.dto.payment.NoteValue#ONE ONE}
 *        
 * 
 * @see Note
 */
public enum NoteValue {

	/**
	 * THOUSAND: Thousand Rupees.
	 */
	THOUSAND("thousand"),
	/**
	 * FIVEHUNDRED: Five Hundred Rupees.
	 */
	FIVEHUNDRED("fivehundred"),
	/**
	 * HUNDRED: Hundred Rupees.
	 */
	HUNDRED("hundred"),
	/**
	 * FIFTY: Fifty Rupees.
	 */
	FIFTY("fifty"),
	/**
	 * TWENTY: Twenty Rupees.
	 */
	TWENTY("twenty"),
	/**
	 * TEN: Ten Rupees.
	 */
	TEN("ten"),
	/**
	 * FIVE: Five rupees.
	 */
	FIVE("five"),
	/**
	 * TWO: Two rupees
	 */
	TWO("two"),
	/**
	 * ONE: One Rupee.
	 */
	ONE("one");

	private String statusCode;

	private NoteValue(String statusCode) {
		this.statusCode = statusCode;
	}

	/**
	 * 
	 * @return Status Code.
	 */
	public String getNoteValueCode() {
		return statusCode;
	}

}
