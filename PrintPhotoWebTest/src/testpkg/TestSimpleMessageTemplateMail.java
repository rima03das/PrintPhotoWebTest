package testpkg;

import in.pulseinfotech.printphoto.dto.Address;
import in.pulseinfotech.printphoto.dto.User;
import in.pulseinfotech.printphoto.dto.UserBlockedStatus;
import in.pulseinfotech.printphoto.dto.UserStatus;
import in.pulseinfotech.printphoto.exception.AddressException;
import in.pulseinfotech.printphoto.exception.EmailIDException;
import in.pulseinfotech.printphoto.exception.MobileNumberExcetion;
import in.pulseinfotech.printphoto.exception.PasswordException;
import in.pulseinfotech.printphoto.exception.UserIDException;
import in.pulseinfotech.printphoto.exception.UserStateException;
import in.pulseinfotech.printphoto.exception.UserStatusException;
import in.pulseinfotech.printphoto.services.communication.MailService;
import in.pulseinfotech.printphoto.services.communication.template.SimpleMessageTemplate;

public class TestSimpleMessageTemplateMail {

	void testSimplemsg() {
		User user = new User();
		Address defaultAddress = new Address();

		defaultAddress.setCity("Bombay");
		defaultAddress.setLandmark("Taj");
		defaultAddress.setPin(596332);
		defaultAddress.setState("Maharastra");
		defaultAddress.setTitle("56 nai");

		try {
			user.setDefaultAddress(defaultAddress);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			user.setEmailId("rims@yahoo.com");
		} catch (EmailIDException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			user.setMobileNumber(6597567890L);
		} catch (MobileNumberExcetion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		user.setName("MR. GOGO");
		try {
			user.setPassword("aaaY38@er");
		} catch (PasswordException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			user.setUserBlockedStatus(UserBlockedStatus.FREE);
		} catch (UserStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		user.setUserComment("HAVENT USED YET");

		try {
			user.setUserId(6656);
		} catch (UserIDException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			user.setUserStatus(UserStatus.EXPERT);
		} catch (UserStatusException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String message = "We have been missing you.... Please visit us for exciting offers...";
		SimpleMessageTemplate smt = new SimpleMessageTemplate();
		MailService ms = new MailService();

		ms.sendSimpleMessage(user, message, smt);

		System.out.println("DONE");
	}

}
