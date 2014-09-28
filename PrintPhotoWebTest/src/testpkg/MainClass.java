package testpkg;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import in.pulseinfotech.printphoto.dto.Address;
import in.pulseinfotech.printphoto.dto.Album;
import in.pulseinfotech.printphoto.dto.Dimension;
import in.pulseinfotech.printphoto.dto.Frame;
import in.pulseinfotech.printphoto.dto.Laminate;
import in.pulseinfotech.printphoto.dto.Order;
import in.pulseinfotech.printphoto.dto.PaperType;
import in.pulseinfotech.printphoto.dto.Photo;
import in.pulseinfotech.printphoto.dto.Poster;
import in.pulseinfotech.printphoto.dto.Product;
import in.pulseinfotech.printphoto.dto.User;
import in.pulseinfotech.printphoto.dto.UserBlockedStatus;
import in.pulseinfotech.printphoto.dto.UserStatus;
import in.pulseinfotech.printphoto.dto.payment.CardMode;
import in.pulseinfotech.printphoto.dto.payment.CashMode;
import in.pulseinfotech.printphoto.dto.payment.Note;
import in.pulseinfotech.printphoto.dto.payment.NoteValue;
import in.pulseinfotech.printphoto.dto.payment.Payment;
import in.pulseinfotech.printphoto.dto.payment.PaymentDetails;
import in.pulseinfotech.printphoto.dto.payment.PaymentMode;
import in.pulseinfotech.printphoto.dto.payment.PaymentStatus;
import in.pulseinfotech.printphoto.exception.AddressException;
import in.pulseinfotech.printphoto.exception.EmailIDException;
import in.pulseinfotech.printphoto.exception.MobileNumberExcetion;
import in.pulseinfotech.printphoto.exception.OrderIDException;
import in.pulseinfotech.printphoto.exception.PasswordException;
import in.pulseinfotech.printphoto.exception.PaymentModeException;
import in.pulseinfotech.printphoto.exception.PaymentModeIdException;
import in.pulseinfotech.printphoto.exception.PaymentStatusException;
import in.pulseinfotech.printphoto.exception.UserException;
import in.pulseinfotech.printphoto.exception.UserIDException;
import in.pulseinfotech.printphoto.exception.UserStateException;
import in.pulseinfotech.printphoto.exception.UserStatusException;

public class MainClass {
	public static void main(String[] args) {
		addData();
	}

	/*
	 * } catch (UserException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } catch (AddressException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); } catch (OrderIDException
	 * e) { // TODO Auto-generated catch block e.printStackTrace(); } catch
	 * (PaymentStatusException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } catch (Exception e1) { // TODO Auto-generated
	 * catch block e1.printStackTrace(); }
	 */
	/*
	 * 
	 * TestingHibernate t = new TestingHibernate(); t.persistUser();
	 * System.out.println("Data Saved !!!!");
	 */
	public static void addData() {
		try {
			System.out.println("hello world ");
			ArrayList<Product> product = new ArrayList<>();
			Product pro = new Product();
			Dimension d = new Dimension();
			d.setLength(20);
			d.setWidth(10);
			// laminate
			Laminate l = new Laminate();
			Photo piclaminate = new Photo();
			piclaminate.setDimension(d);
			piclaminate.setFileName("laminate pic");
			piclaminate.setPaperType(PaperType.GLOSSY);
			l.setDimension(d);
			l.setLaminatePhoto(piclaminate);
			l.setProductComment("lamination");
			product.add(l);

			Photo pic = new Photo();
			pic.setDimension(d);
			pic.setFileName("hello");
			pic.setPaperType(PaperType.METALLIC);
			pic.setProductComment("hello");
			pro = pic;

			product.add(pic);

			// album making
			ArrayList<Photo> photolist = new ArrayList<>(); // setting data to
			for (int i = 0; i < 12; i++) {
				Photo p = new Photo();
				p.setDimension(d);
				p.setFileName("hello" + i);
				p.setPaperType(PaperType.METALLIC);
				p.setProductComment("");
				photolist.add(p);
			}
			Album a = new Album();
			a.setAlbumPhotos(photolist);
			a.setDimension(d);
			a.setProductComment("album");
			product.add(a);
			/*
			 * Photo test = new Photo(); test.setFileName("printpic");
			 * test.setPaperType(PaperType.MATTE); test.setProductComment("");
			 * Dimension dimen = new Dimension(); dimen.setLength(50);
			 * dimen.setWidth(20); test.setDimension(dimen); Laminate l = new
			 * Laminate(); l.setLaminatePhoto(test); Frame f = new Frame();
			 * f.setFramePhoto(test); Poster pos = new Poster();
			 * pos.setPhotoPoster(test); product.add(l); product.add(f);
			 * product.add(pos);
			 */

			// default Address
			Address defaultAddress = new Address();
			defaultAddress.setCity("Delhi");
			defaultAddress.setLandmark("Kohat Enclave");
			defaultAddress.setPin(110015);
			defaultAddress.setState("New Delhi");
			defaultAddress.setTitle("new delhi");

			// user settings
			User user = new User();
			user.setDefaultAddress(defaultAddress);
			user.setEmailId("ramanahuja188@gmail.com");
			user.setMobileNumber(9811686175L);
			user.setName("MR. Raman");
			user.setPassword("Raman@123");
			user.setUserBlockedStatus(UserBlockedStatus.FREE);
			user.setUserComment("HAVENT USED YET");
			user.setUserStatus(UserStatus.EXPERT);

			// card mode payment
			CardMode card = new CardMode();
			card.setCardExpiryDate(new Date());
			card.setCardNumber(1234567L);
			card.setTransactionId(1234567L);

			// cash mode payment
			CashMode paymentcash = new CashMode();
			paymentcash.setCashAmount(1000L);
			// note making
			Note n1 = new Note();
			n1.setNoteValue(NoteValue.FIVEHUNDRED);
			n1.setNoteSerialNumber("9AC 023456");

			Note n2 = new Note();
			n2.setNoteValue(NoteValue.FIVEHUNDRED);
			n2.setNoteSerialNumber("9BG 056789");

			ArrayList<Note> listOfNotes = new ArrayList<>();
			listOfNotes.add(n1);
			listOfNotes.add(n2);
			// adding list of notes to cash mode payment
			paymentcash.setCashDetail(listOfNotes);

			// payment details

			PaymentDetails pd = new PaymentDetails();
			pd.setPaymentAmount(2000);

			pd.setPaymentDate(new Date());
			pd.setTimeStamp(new Date());

			// payemnt mode
			PaymentMode pm = card;
			// payment table
			Payment payp = new Payment();
			payp.setPaymentComment("paid");
			payp.setPaymentDetails(pd);
			payp.setPaymentMode(pm);
			payp.setPaymentStatus(PaymentStatus.PAID);

			// order sttings
			Order o = new Order();
			o.setUser(user);
			o.setDeliveryAddress(defaultAddress);
			o.setPayment(payp);
			o.setOrderComment("bjv");
			o.setProductList(product);

			/*
			 * Product pro = new Product(); Dimension d = new Dimension();
			 * d.setLength(20); d.setWidth(10); pro.setDimension(d);
			 * pro.setProductComment("jbvjf"); Photo p = new Photo();
			 * p.setDimension(d); p.setFileName("hello");
			 * p.setPaperType(PaperType.LUSTURE); p.setProductComment("pic");
			 * p.setProductId(123456L); pro = p;
			 */
			// saving of order
			SessionFactory sf = new Configuration().configure()
					.buildSessionFactory();
			Session s = sf.openSession();

			s.beginTransaction();
			s.save(pro);
			for (Photo photo : photolist) {
				pro = photo;
				s.save(photo);
			}
			pro = piclaminate;
			s.save(pro);
			pro = l;
			s.save(l);
			pro = a;
			s.save(a);

			// saving card mode
			/*
			 * s.save(card);
			 * 
			 * pm = card; s.save(pm);
			 */

			// saving cash mode payment
			s.save(n1);
			s.save(n2);
			// s.save(paymentcash);
			pm = paymentcash;

			// s.save(pm);
			s.save(card);
			// s.save(paymentcash);
			s.save(payp);
			s.save(user);
			s.save(o);
			// s.save(o);
			s.getTransaction().commit();

			s.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
