package testpkg;

import in.pulseinfotech.printphoto.dto.Address;
import in.pulseinfotech.printphoto.dto.Album;
import in.pulseinfotech.printphoto.dto.Dimension;
import in.pulseinfotech.printphoto.dto.Order;
import in.pulseinfotech.printphoto.dto.PaperType;
import in.pulseinfotech.printphoto.dto.Photo;
import in.pulseinfotech.printphoto.dto.Product;
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
import in.pulseinfotech.printphoto.services.communication.template.OrderCancellationTemplate;
import in.pulseinfotech.printphoto.services.communication.template.OrderConfirmationTemplate;

import java.util.ArrayList;

public class TestOrderConfirmationTemplateMail {

	void testOrderConf() {
		User user = new User();
		Address defaultAddress = new Address();
		Dimension dimension = new Dimension();
		Order order = new Order();
		try {

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

			dimension.setLength(5);
			dimension.setWidth(2);

			Photo photo = new Photo();
			photo.setProductId(9865);
			photo.setDimension(dimension);
			photo.setFileName("Photo1");
			photo.setPaperType(PaperType.LUSTURE);

			Album photo1 = new Album();
			photo1.setProductId(3365);
			// photo1.setDimension(dimension);
			// photo1.setFileName("Photo2");
			// photo1.setPaperType(PaperType.GLOSSY);

			ArrayList<Product> productList = new ArrayList<Product>();
			productList.add(photo);
			productList.add(photo1);

			order.setDeliveryAddress(defaultAddress);
			order.setOrderComment("CALCEL ORDER");
			order.setOrderId(58965);
			order.setProductList(productList);
			order.setUser(user);

		} catch (Exception e) {
			e.printStackTrace();
		}

		// String message =
		// "We have been missing you.... Please visit us for exciting offers...";
		OrderConfirmationTemplate oct = new OrderConfirmationTemplate();
		MailService ms = new MailService();

		ms.sendOrderConfirmationMessage(order, oct);

		System.out.println("DONE");
	}
}
