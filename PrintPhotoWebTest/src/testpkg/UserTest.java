package testpkg;



import in.pulseinfotech.printphoto.dto.Address;
import in.pulseinfotech.printphoto.dto.UserBlockedStatus;
import in.pulseinfotech.printphoto.dto.UserStatus;
import in.pulseinfotech.printphoto.exception.AddressException;
import in.pulseinfotech.printphoto.exception.EmailIDException;
import in.pulseinfotech.printphoto.exception.MobileNumberExcetion;
import in.pulseinfotech.printphoto.exception.PasswordException;
import in.pulseinfotech.printphoto.exception.UserIDException;
import in.pulseinfotech.printphoto.exception.UserStateException;
import in.pulseinfotech.printphoto.exception.UserStatusException;

import java.util.regex.Pattern;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 
 * This class holds details about every user who registers into the system. It
 * stores user's personal details like User name, mobile number, email id,
 * password, address. Along with that it also stores <code> UserStatus </code>
 * and <code>UserBlockedStatus </code>
 * 
 * @see UserStatus
 * @see UserBlockedStatus
 * 
 * @author Rima Das
 * @version 1.0
 * @since 16 September 2014 <br>
 * <br>
 * <br>
 * 
 */
@Entity
public class UserTest {

	/**
	 * This field holds the id to uniquely identify the user.
	 */
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long userId;

	/**
	 * This field holds user's name.
	 */
	private String name;

	/**
	 * This field holds user's mobile number.
	 */
	private long mobileNumber;

	/**
	 * This field holds user's email id.
	 */
	private String emailId;

	/**
	 * This field holds user's password.
	 */
	private String password;

	/**
	 * This field holds user's {@link Address}.
	 */
	@Embedded
	private AddressTest defaultAddress;

	/**
	 * This field holds {@link UserStatus}.
	 */
	@Column(columnDefinition = "enum('BEGINNER','PRO','CHAMPION','EXPERT')")
	@Enumerated(EnumType.STRING)
	private UserStatusTest userStatus;

	/**
	 * This field holds {@link UserBlockedStatus}.
	 */
	@Column(columnDefinition = "enum('FREE','BLOCKED')")
	@Enumerated(EnumType.STRING)
	private UserBlockedStatusTest userBlockedStatus;

	/**
	 * This field holds user's Comments.
	 */
	private String userComment;

	/**
	 * 
	 * @return userid
	 */
	public long getUserId() {
		return userId;
	}

	/**
	 * 
	 * @param userId
	 * @throws UserIDException
	 */
	public void setUserId(long userId) throws UserIDException {
		if (userId >= 0) {
			this.userId = userId;
		} else {
			throw new UserIDException(" Negative User ID ");
		}
	}

	/**
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @return Mobile Number
	 */
	public long getMobileNumber() {
		return mobileNumber;
	}

	/**
	 * 
	 * @param mobileNumber
	 * @throws MobileNumberExcetion
	 */
	public void setMobileNumber(long mobileNumber) throws MobileNumberExcetion {
		if (String.valueOf(mobileNumber).length() > 0
				&& String.valueOf(mobileNumber).length() <= 10) {
			this.mobileNumber = mobileNumber;
		} else {
			throw new MobileNumberExcetion(
					"Number exceeds allowed limits. Length of a mobile number should be within 10 digits");
		}
	}

	/**
	 * 
	 * @return Email Id
	 */
	public String getEmailId() {
		return emailId;
	}

	/**
	 * 
	 * @param emailId
	 * @throws EmailIDException
	 */
	public void setEmailId(String emailId) throws EmailIDException {
		String emailRegEx = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*[\\.[A-Za-z]{2,}]$";

		if (emailId != "") {
			if (Pattern.matches(emailRegEx, emailId)) {
				this.emailId = emailId;
			} else {
				throw new EmailIDException("The email received does not match the defiend format");
			}
		} else {
			throw new EmailIDException("Null email received");
		}
	}

	/**
	 * 
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 
	 * @param password
	 * @throws PasswordException
	 */
	public void setPassword(String password) throws PasswordException {
		String passRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,18}$";
		if (Pattern.matches(passRegex, password)) {
			this.password = password;
		} else {
			throw new PasswordException(
					"Password does not follow the required convension. Required: \n A digit must occur at least once. \n A lower case letter must occur at least once. \n An upper case letter must occur at least once. \n A special character must occur at least once. \n No whitespace allowed in the entire string. \n The password should be at least 8 characters to at most 18 characters long.");
		}
	}

	/**
	 * 
	 * @return Default Address
	 */
	public AddressTest getDefaultAddress() {
		return defaultAddress;
	}

	/**
	 * 
	 * @param defaultAddress
	 */
	public void setDefaultAddress(AddressTest defaultAddress)
			throws AddressException {
		if (defaultAddress != null) {
			this.defaultAddress = defaultAddress;
		} else {
			throw new AddressException("Null reference received for address");
		}
	}

	/**
	 * 
	 * @return {@link UserStatus}
	 */
	public UserStatusTest getUserStatus() {
		return userStatus;
	}

	/**
	 * 
	 * @param userStatus
	 * @throws UserStatusException
	 */
	public void setUserStatus(UserStatusTest userStatus) throws UserStatusException {
		if (userStatus != null) {
			if (userStatus.equals(UserStatusTest.BEGINNER)
					|| userStatus.equals(UserStatusTest.CHAMPION)
					|| userStatus.equals(UserStatusTest.PRO)
					|| userStatus.equals(UserStatusTest.EXPERT)) {
				this.userStatus = userStatus;
			} else {
				throw new UserStatusException(
						"Invalid user status received. The value should be one of the following: PRO, BEGINNER, CHAMPION, EXPERT");
			}
		} else {
			throw new UserStatusException("Null value received for user status");
		}

	}

	/**
	 * 
	 * @return {@link UserBlockedStatus}
	 */
	public UserBlockedStatusTest getUserBlockedStatus() {
		return userBlockedStatus;
	}

	/**
	 * 
	 * @param userBlockedStatus
	 * @see UserBlockedStatus
	 */
	public void setUserBlockedStatus(UserBlockedStatusTest userBlockedStatus) throws UserStateException{
		
		if (userBlockedStatus != null) {
			if (userBlockedStatus.equals(UserBlockedStatusTest.BLOCKED)
					|| userBlockedStatus.equals(UserBlockedStatusTest.FREE)) {
				this.userBlockedStatus = userBlockedStatus;
			} else {
				throw new UserStateException(
						"Invalid user state received. The value should be one of the following: BLOCKED or FREE");
			}
		} else {
			throw new UserStateException("Null value received for user state");
		}

	}

	/**
	 * 
	 * @return comments
	 */
	public String getUserComment() {
		return userComment;
	}

	/**
	 * 
	 * @param comment
	 */

	public void setUserComment(String userComment) {
		this.userComment = userComment;
	}

}
