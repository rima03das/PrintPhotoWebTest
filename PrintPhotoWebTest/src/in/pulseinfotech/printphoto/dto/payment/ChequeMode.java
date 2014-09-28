package in.pulseinfotech.printphoto.dto.payment;

import java.util.Date;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * This class is a subclass of <code>PaymentMode</code> and holds details for
 * payments made by Cheque. It has details like cheque number, bank name, issue
 * date, expiry date and cheque status.
 * 
 * @author Rima Das,Gufran Khurshid
 * @version 1.0
 * @since 20 September 2014 <br>
 * <br>
 * <br>
 * 
 *        {@link in.pulseinfotech.printphoto.dto.payment.ChequeMode#bankName
 *        Bank Name},
 *        {@link in.pulseinfotech.printphoto.dto.payment.ChequeMode#chequeNumber
 *        Cheque Number},
 *        {@link in.pulseinfotech.printphoto.dto.payment.ChequeMode#chequeStatus
 *        Cheque Status},
 *        {@link in.pulseinfotech.printphoto.dto.payment.ChequeMode#expiryDate
 *        Expiry Date},
 *        {@link in.pulseinfotech.printphoto.dto.payment.ChequeMode#issueDate
 *        Issue Date},
 * 
 * @see PaymentMode
 * @see ChequeStatus
 * 
 */
public class ChequeMode extends PaymentMode {

	/**
	 * This field holds the cheque number.
	 */
	private long chequeNumber;

	/**
	 * This field holds the name of the bank.
	 */
	private String bankName;

	/**
	 * This field holds the date of issue.
	 */
	@Temporal(TemporalType.DATE)
	private Date issueDate;

	/**
	 * This field holds the date of expiry.
	 */
	@Temporal(TemporalType.DATE)
	private Date expiryDate;

	/**
	 * This field holds the cheque status.
	 */
	@Enumerated(EnumType.STRING)
	private ChequeStatus chequeStatus;

	/**
	 * 
	 * @return Cheque Number
	 */
	public long getChequeNumber() {
		return chequeNumber;
	}

	/**
	 * 
	 * @param chequeNumber
	 */
	public void setChequeNumber(long chequeNumber) {
		this.chequeNumber = chequeNumber;
	}

	/**
	 * 
	 * @return The name of the bank
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
	 * @return Date of issue
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
	 * @return Date of expiry
	 */
	public Date getExpiryDate() {
		return expiryDate;
	}

	/**
	 * 
	 * @param expiryDate
	 */
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	/**
	 * 
	 * @return Cheque Status
	 * @see ChequeStatus
	 */
	public ChequeStatus getChequeStatus() {
		return chequeStatus;
	}

	/**
	 * 
	 * @param chequeStatus
	 */
	public void setChequeStatus(ChequeStatus chequeStatus) {
		this.chequeStatus = chequeStatus;
	}

}
