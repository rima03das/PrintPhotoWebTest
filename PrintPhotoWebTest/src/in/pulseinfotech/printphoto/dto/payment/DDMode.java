package in.pulseinfotech.printphoto.dto.payment;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * This class is a subclass of <code>PaymentMode</code> and holds details for
 * payments made by Demand Drafts. It has details like DD number, bank name,
 * issue date and DD expiry date.
 * 
 * @author Rima Das
 * @version 1.0
 * @since 20 September 2014 <br>
 * <br>
 * <br>
 * 
 *        {@link in.pulseinfotech.printphoto.dto.payment.DDMode#bankName Bank
 *        Name},
 *        {@link in.pulseinfotech.printphoto.dto.payment.DDMode#ddExpiryDate DD
 *        Expiry Date},
 *        {@link in.pulseinfotech.printphoto.dto.payment.DDMode#DDNumber DD
 *        Number},
 *        {@link in.pulseinfotech.printphoto.dto.payment.DDMode#issueDate Issue
 *        Date}
 * 
 * @see PaymentMode
 */
public class DDMode extends PaymentMode {

	/**
	 * This field holds the DD number.
	 */
	private long DDNumber;

	/**
	 * This field holds the name of the bank.
	 */
	private String bankName;

	/**
	 * This field holds the DD's issue date.
	 */
	@Temporal(TemporalType.DATE)
	private Date issueDate;

	/**
	 * This field holds the DD's expiry date.
	 */
	@Temporal(TemporalType.DATE)
	private Date ddExpiryDate;

	/**
	 * 
	 * @return DDNumber
	 */
	public long getDDNumber() {
		return DDNumber;
	}

	/**
	 * 
	 * @param dDNumber
	 */
	public void setDDNumber(long dDNumber) {
		DDNumber = dDNumber;
	}

	/**
	 * 
	 * @return Name of the bank
	 */
	public String getBankName() {
		return bankName;
	}

	/**
	 * 
	 * @param bankName
	 */
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	/**
	 * 
	 * @return issue Date
	 */
	public Date getIssueDate() {
		return issueDate;
	}

	/**
	 * 
	 * @param issueDate
	 */
	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	/**
	 * 
	 * @return DD's Expiry date
	 */
	public Date getDdExpiryDate() {
		return ddExpiryDate;
	}

	/**
	 * 
	 * @param ddExpiryDate
	 */
	public void setDdExpiryDate(Date ddExpiryDate) {
		this.ddExpiryDate = ddExpiryDate;
	}

}
