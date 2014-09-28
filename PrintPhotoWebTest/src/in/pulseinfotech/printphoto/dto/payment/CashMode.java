package in.pulseinfotech.printphoto.dto.payment;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 * 
 * This class is a subclass of <code>PaymentMode</code> and holds details for
 * payments made by Cash. It has details like Cash Amount and cash Detail.
 * 
 * @author Rima Das,Gufran Khurshid
 * @version 1.1
 * @since 20 September 2014 <br>
 * <br>
 * <br>
 * 
 *        {@link in.pulseinfotech.printphoto.dto.payment.CashMode#cashAmount
 *        Cash Amount},
 *        {@link in.pulseinfotech.printphoto.dto.payment.CashMode#cashDetail
 *        Cash Detail}
 * 
 * @see PaymentMode
 * @see CashDetail
 * 
 */
@Entity
public class CashMode extends PaymentMode {

	/**
	 * This field holds the amount paid in cash.
	 */
	private double cashAmount;

	/**
	 * This field holds the details of the notes used to pay in cash.
	 * 
	 * @see Note
	 */
	@OneToMany
	private List<Note> cashDetail;

	/**
	 * 
	 * @return The amount of cash
	 */
	public double getCashAmount() {
		return cashAmount;
	}

	/**
	 * 
	 * @param cashAmount
	 */
	public void setCashAmount(double cashAmount) {
		this.cashAmount = cashAmount;
	}

	/**
	 * 
	 * @return List of cash Detail
	 */
	public List<Note> getCashDetail() {
		return cashDetail;
	}

	/**
	 * 
	 * @param cashDetail
	 */
	public void setCashDetail(List<Note> cashDetail) {
		this.cashDetail = cashDetail;
	}

}
