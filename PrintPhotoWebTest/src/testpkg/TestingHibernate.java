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
import in.pulseinfotech.printphoto.services.communication.MailService;
import in.pulseinfotech.printphoto.services.communication.template.SimpleMessageTemplate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestingHibernate {

	public void persistUser() {

		UserTest user = new UserTest();
		AddressTest defaultAddress = new AddressTest();

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
			user.setEmailId("rimsnhnh@yahoo.com");
		} catch (EmailIDException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			user.setMobileNumber(6578567890L);
		} catch (MobileNumberExcetion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		user.setName("MR. aman");
		try {
			user.setPassword("aaaY38@er");
		} catch (PasswordException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			user.setUserBlockedStatus(UserBlockedStatusTest.FREE);
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
			user.setUserStatus(UserStatusTest.EXPERT);
		} catch (UserStatusException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		SessionFactory sf = new Configuration().configure()
				.buildSessionFactory();
		Session s = sf.openSession();

		s.beginTransaction();
		s.save(user);

		s.getTransaction().commit();

		s.close();
	}

}
