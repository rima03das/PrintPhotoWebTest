package in.pulseinfotech.printphoto.dto;

import in.pulseinfotech.printphoto.exception.AddressException;
import in.pulseinfotech.printphoto.exception.EmailIDException;
import in.pulseinfotech.printphoto.exception.MobileNumberExcetion;
import in.pulseinfotech.printphoto.exception.PasswordException;
import in.pulseinfotech.printphoto.exception.UserIDException;
import in.pulseinfotech.printphoto.exception.UserStateException;
import in.pulseinfotech.printphoto.exception.UserStatusException;
import in.pulseinfotech.printphoto.services.logging.PrintPhotoLogger;
import in.pulseinfotech.printphoto.services.logging.PrintPhotoLogger.LOG;

import java.util.regex.Pattern;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
 * @author Rima Das,Gufran Khurshid
 * @version 1.1
 * @since 16 September 2014 <br>
 * <br>
 * <br>
 * 
 */
@Entity
public class User {
	private static String FQCN = User.class.getName();
	/**
	 * This field holds the id to uniquely identify the user.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
	private Address defaultAddress;

	/**
	 * This field holds {@link UserStatus}.
	 */
	@Enumerated(EnumType.STRING)
	private UserStatus userStatus;

	/**
	 * This field holds {@link UserBlockedStatus}.
	 */
	@Enumerated(EnumType.STRING)
	private UserBlockedStatus userBlockedStatus;

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
			PrintPhotoLogger.log4j(FQCN, LOG.ERROR, " Negative User ID .",
					new UserIDException(" Negative User ID "));
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
			PrintPhotoLogger
					.log4j(FQCN,
							LOG.ERROR,
							"Number exceeds allowed limits. Length of a mobile number should be within 10 digits.",
							new MobileNumberExcetion(
									"Number exceeds allowed limits. Length of a mobile number should be within 10 digits"));
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
				PrintPhotoLogger
						.log4j(FQCN,
								LOG.ERROR,
								"The email received does not match the defiend format.",
								new EmailIDException(
										"The email received does not match the defiend format"));
				throw new EmailIDException(
						"The email received does not match the defiend format");
			}
		} else {
			PrintPhotoLogger.log4j(FQCN, LOG.ERROR, "Null email received.",
					new EmailIDException("Null email received"));
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
			PrintPhotoLogger
					.log4j(FQCN,
							LOG.ERROR,
							"Password does not follow the required convension. Required: \n A digit must occur at least once. \n A lower case letter must occur at least once. \n An upper case letter must occur at least once. \n A special character must occur at least once. \n No whitespace allowed in the entire string. \n The password should be at least 8 characters to at most 18 characters long.",
							new PasswordException(
									"Password does not follow the required convension. Required: \n A digit must occur at least once. \n A lower case letter must occur at least once. \n An upper case letter must occur at least once. \n A special character must occur at least once. \n No whitespace allowed in the entire string. \n The password should be at least 8 characters to at most 18 characters long."));
			throw new PasswordException(
					"Password does not follow the required convension. Required: \n A digit must occur at least once. \n A lower case letter must occur at least once. \n An upper case letter must occur at least once. \n A special character must occur at least once. \n No whitespace allowed in the entire string. \n The password should be at least 8 characters to at most 18 characters long.");
		}
	}

	/**
	 * 
	 * @return Default Address
	 */
	public Address getDefaultAddress() {
		return defaultAddress;
	}

	/**
	 * 
	 * @param defaultAddress
	 */
	public void setDefaultAddress(Address defaultAddress)
			throws AddressException {
		if (defaultAddress != null) {
			this.defaultAddress = defaultAddress;
		} else {
			PrintPhotoLogger
					.log4j(FQCN, LOG.ERROR,
							"Null reference received for address.",
							new AddressException(
									"Null reference received for address"));
			throw new AddressException("Null reference received for address");
		}
	}

	/**
	 * 
	 * @return {@link UserStatus}
	 */
	public UserStatus getUserStatus() {
		return userStatus;
	}

	/**
	 * 
	 * @param userStatus
	 * @throws UserStatusException
	 */
	public void setUserStatus(UserStatus userStatus) throws UserStatusException {
		if (userStatus != null) {
			if (userStatus.equals(UserStatus.BEGINNER)
					|| userStatus.equals(UserStatus.CHAMPION)
					|| userStatus.equals(UserStatus.PRO)
					|| userStatus.equals(UserStatus.EXPERT)) {
				this.userStatus = userStatus;
			} else {
				PrintPhotoLogger
						.log4j(FQCN,
								LOG.ERROR,
								"Invalid user status received. The value should be one of the following: PRO, BEGINNER, CHAMPION, EXPERT.",
								new UserStatusException(
										"Invalid user status received. The value should be one of the following: PRO, BEGINNER, CHAMPION, EXPERT"));
				throw new UserStatusException(
						"Invalid user status received. The value should be one of the following: PRO, BEGINNER, CHAMPION, EXPERT");
			}
		} else {
			PrintPhotoLogger.log4j(FQCN, LOG.ERROR,
					"Null value received for user status.",
					new UserStatusException(
							"Null value received for user status"));
			throw new UserStatusException("Null value received for user status");
		}

	}

	/**
	 * 
	 * @return {@link UserBlockedStatus}
	 */
	public UserBlockedStatus getUserBlockedStatus() {
		return userBlockedStatus;
	}

	/**
	 * 
	 * @param userBlockedStatus
	 * @see UserBlockedStatus
	 */
	public void setUserBlockedStatus(UserBlockedStatus userBlockedStatus)
			throws UserStateException {

		if (userBlockedStatus != null) {
			if (userBlockedStatus.equals(UserBlockedStatus.BLOCKED)
					|| userBlockedStatus.equals(UserBlockedStatus.FREE)) {
				this.userBlockedStatus = userBlockedStatus;
			} else {
				PrintPhotoLogger
						.log4j(FQCN,
								LOG.ERROR,
								"Invalid user state received. The value should be one of the following: BLOCKED or FREE.",
								new UserStateException(
										"Invalid user state received. The value should be one of the following: BLOCKED or FREE"));
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
