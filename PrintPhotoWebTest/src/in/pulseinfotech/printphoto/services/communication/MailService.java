package in.pulseinfotech.printphoto.services.communication;

import in.pulseinfotech.printphoto.dto.Album;
import in.pulseinfotech.printphoto.dto.Order;
import in.pulseinfotech.printphoto.dto.OrderTrack;
import in.pulseinfotech.printphoto.dto.Photo;
import in.pulseinfotech.printphoto.dto.Poster;
import in.pulseinfotech.printphoto.dto.Product;
import in.pulseinfotech.printphoto.dto.User;
import in.pulseinfotech.printphoto.services.communication.template.OrderCancellationTemplate;
import in.pulseinfotech.printphoto.services.communication.template.OrderConfirmationTemplate;
import in.pulseinfotech.printphoto.services.communication.template.PromotionTemplate;
import in.pulseinfotech.printphoto.services.communication.template.RegistrationCancellationTemplate;
import in.pulseinfotech.printphoto.services.communication.template.RegistrationConfirmationTemplate;
import in.pulseinfotech.printphoto.services.communication.template.ShipmentDeliveredTemplate;
import in.pulseinfotech.printphoto.services.communication.template.ShipmentReachedTemplate;
import in.pulseinfotech.printphoto.services.communication.template.ShipmentShippedTemplate;
import in.pulseinfotech.printphoto.services.communication.template.SimpleMessageTemplate;
import in.pulseinfotech.printphoto.services.communication.template.ThanksTemplate;
import in.pulseinfotech.printphoto.services.logging.PrintPhotoLogger;
import in.pulseinfotech.printphoto.services.logging.PrintPhotoLogger.LOG;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

/**
 * 
 * This class is a sub class of the <code>CommunicationService</code> . It is
 * responsible for handling all communications through mails.
 * 
 * @author Raman Ahuja
 * @version 1.0
 * @since 16 September 2014 <br>
 * <br>
 * @see CommunicationService
 * @see SMSService
 * 
 */

public class MailService extends CommunicationService {
	private static String FQCN = MailService.class.getName();
	/**
	 * static block for logger info.
	 */
	static {
		PrintPhotoLogger.log4j(FQCN, LOG.INFO, " MailService Service Loaded.",
				null);
	}

	List<String> errorsList;

	/**
	 * This method collects all the error and returns them in a list
	 * 
	 * @return
	 */
	public MailService() {
		errorsList = new ArrayList<String>();
	}

	/**
	 * This method sends mail regarding shipment delivery
	 * 
	 * @param orderTrack
	 * @param shipmentDeliveredTemplate
	 * @return
	 */
	public boolean sendDeliveryConfirmationMessage(OrderTrack orderTrack,
			ShipmentDeliveredTemplate shipmentDeliveredTemplate) {
		return false;
	}

	/**
	 * This method sends mail once the order is complete
	 * 
	 * @param order
	 * @param orderConfirmationTemplate
	 * @return
	 */
	public boolean sendOrderConfirmationMessage(Order order,
			OrderConfirmationTemplate orderConfirmationTemplate) {

		String template = orderConfirmationTemplate.getTemplate();

		HtmlEmail email = new HtmlEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(587);
		email.setStartTLSEnabled(true);

		email.setAuthentication("rimad0711@gmail.com", "rima03das");
		email.setSSLOnConnect(true);
		try {
			email.setFrom("rimad0711@gmail.com");
			email.setSubject("Order Confirmation");
			email.setMsg("Just Keeping in Touch... :-)");
			email.addTo("rimad0711@gmail.com");
			// email.attach(new
			// File("C:\\Users\\Public\\Pictures\\Sample Pictures\\Lighthouse.jpg"));

			/*
			 * String id = email.embed(new URL(
			 * "file:C:\\Users\\Public\\Pictures\\Sample Pictures\\Lighthouse.jpg"
			 * ), "Lighthouse.jpg"); System.out.println("ID " + id);
			 */
			template = template.replaceAll("\\$\\{Hello\\}", "Hello "
					+ order.getUser().getName());
			String orderList = "";

			for (Product p : order.getProductList()) {
				if (p instanceof Photo) {
					if (!orderList.equals("")) {
						orderList = orderList + "<br>";
						orderList = orderList + ((Photo) p).getFileName()
								+ ", " + ((Photo) p).getDimension() + ", "
								+ ((Photo) p).getPaperType();
					} else {
						orderList = "Photo - ";
						orderList = orderList + ((Photo) p).getFileName()
								+ ", " + ((Photo) p).getDimension().getLength()
								+ "\" X "
								+ ((Photo) p).getDimension().getWidth()
								+ "\", " + ((Photo) p).getPaperType();
					}
				}
				if (p instanceof Album) {
					if (!orderList.equals("")) {
						orderList = orderList + "<br>";
						orderList = orderList + ((Album) p).getProductId();
					} else {
						orderList = "Album - ";
						orderList = orderList + ((Album) p).getProductId();
					}
				}
				if (p instanceof Poster) {
					if (!orderList.equals("")) {
						orderList = orderList + "<br>";
						orderList = orderList
								+ ((Poster) p).getPhotoPoster().getFileName();
					} else {
						orderList = "Poster - ";
						orderList = orderList
								+ ((Poster) p).getPhotoPoster().getFileName();
					}
				}
			}
			System.out.println("order list " + orderList);
			String message = "Your order has been Confirmed. Please find the below details. <br> Order ID: "
					+ order.getOrderId() + "<br> Order Details: " + orderList;

			template = template.replaceAll("\\$\\{MsgBody\\}", message);

			System.out.println("TEXT: " + template);
			email.setHtmlMsg(template);
			email.send();
			PrintPhotoLogger
					.log4j(FQCN,
							LOG.INFO,
							"Order Confirmation mail has been successfully sent.",
							null);
			return true;
		} catch (EmailException e) {
			e.printStackTrace();
			PrintPhotoLogger
					.log4j(FQCN,
							LOG.ERROR,
							"Email Exception encountered while sending Order Confirmation mail.",
							e);
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			PrintPhotoLogger
					.log4j(FQCN,
							LOG.ERROR,
							"Exception encountered while sending Order Confirmation mail.",
							e);
			return false;
		}
	}

	/**
	 * This method sends mail giving simple informations
	 * 
	 * @param user
	 * @param message
	 * @param simpleMessageTemplate
	 * @return
	 */
	public boolean sendSimpleMessage(User user, String message,
			SimpleMessageTemplate simpleMessageTemplate) {

		String template = simpleMessageTemplate.getTemplate();

		HtmlEmail email = new HtmlEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(587);
		email.setStartTLSEnabled(true);

		email.setAuthentication("rimad0711@gmail.com", "rima03das");
		email.setSSLOnConnect(true);
		try {
			email.setFrom("rimad0711@gmail.com");
			email.setSubject("Just Keeping in Touch...");
			email.setMsg("Just Keeping in Touch... :-)");
			email.addTo("rimad0711@gmail.com");
			// email.attach(new
			// File("C:\\Users\\Public\\Pictures\\Sample Pictures\\Lighthouse.jpg"));

			/*
			 * String id = email.embed(new URL(
			 * "file:C:\\Users\\Public\\Pictures\\Sample Pictures\\Lighthouse.jpg"
			 * ), "Lighthouse.jpg"); System.out.println("ID " + id);
			 */
			template = template.replaceAll("\\$\\{Hello\\}",
					"Hello " + user.getName()
							+ ", <br> Hope we find you in good health");
			template = template.replaceAll("\\$\\{MsgBody\\}", message);

			System.out.println("TEXT: " + template);
			email.setHtmlMsg(template);
			email.send();
			PrintPhotoLogger.log4j(FQCN, LOG.INFO,
					"Simple mail has been successfully sent.", null);
			return true;
		} catch (EmailException e) {
			e.printStackTrace();
			PrintPhotoLogger
					.log4j(FQCN,
							LOG.ERROR,
							"Email Exception encountered while sending Simple mail.",
							e);
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			PrintPhotoLogger.log4j(FQCN, LOG.ERROR,
					"Exception encountered while sending Simple mail.", e);
			return false;
		}
	}

	/**
	 * This method sends mail to inform users about any kinds of promotions
	 * 
	 * @param user
	 * @param promotionalTemplate
	 * @return
	 */
	public boolean sendPromotionMessage(User user,
			PromotionTemplate promotionalTemplate) {

		String template = promotionalTemplate.getTemplate();

		HtmlEmail email = new HtmlEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(587);
		email.setStartTLSEnabled(true);

		email.setAuthentication("rimad0711@gmail.com", "rima03das");
		email.setSSLOnConnect(true);
		try {
			email.setFrom("rimad0711@gmail.com");
			email.setSubject("New exciting offers...");
			email.setMsg("Just Keeping in Touch... :-)");
			email.addTo("rimad0711@gmail.com");
			// email.attach(new
			// File("C:\\Users\\Public\\Pictures\\Sample Pictures\\Lighthouse.jpg"));

			/*
			 * String id = email.embed(new URL(
			 * "file:C:\\Users\\Public\\Pictures\\Sample Pictures\\Lighthouse.jpg"
			 * ), "Lighthouse.jpg"); System.out.println("ID " + id);
			 */
			template = template.replaceAll("\\$\\{Hello\\}",
					"Hello " + user.getName());
			String orderList = "";

			String message = "We have launched a new feature... Please visit out site and be th first to use it to win exciting prizes";

			template = template.replaceAll("\\$\\{MsgBody\\}", message);

			System.out.println("TEXT: " + template);
			email.setHtmlMsg(template);
			email.send();
			PrintPhotoLogger.log4j(FQCN, LOG.INFO,
					"Promotional mail has been successfully sent.", null);
			return true;
		} catch (EmailException e) {
			e.printStackTrace();
			PrintPhotoLogger
					.log4j(FQCN,
							LOG.ERROR,
							"Email Exception encountered while sending Promotional mail.",
							e);
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			PrintPhotoLogger.log4j(FQCN, LOG.ERROR,
					"Exception encountered while sending Promotional mail.", e);
			return false;
		}
	}

	/**
	 * This method sends mail to inform users about registration confirmation
	 * 
	 * @param user
	 * @param registrationConfirmationTemplate
	 * @return
	 */
	public boolean sendRegistrationConfirmationMessage(User user,
			RegistrationConfirmationTemplate registrationConfirmationTemplate) {

		String template = registrationConfirmationTemplate.getTemplate();

		HtmlEmail email = new HtmlEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(587);
		email.setStartTLSEnabled(true);

		email.setAuthentication("rimad0711@gmail.com", "rima03das");
		email.setSSLOnConnect(true);
		try {
			email.setFrom("rimad0711@gmail.com");
			email.setSubject("Registration Confirmation");
			email.setMsg("Just Keeping in Touch... :-)");
			email.addTo("rimad0711@gmail.com");
			// email.attach(new
			// File("C:\\Users\\Public\\Pictures\\Sample Pictures\\Lighthouse.jpg"));

			/*
			 * String id = email.embed(new URL(
			 * "file:C:\\Users\\Public\\Pictures\\Sample Pictures\\Lighthouse.jpg"
			 * ), "Lighthouse.jpg"); System.out.println("ID " + id);
			 */
			template = template.replaceAll("\\$\\{Hello\\}",
					"Hello " + user.getName());
			String orderList = "";

			String message = "We are happy to inform you that your registration had been confirmed. Now you can visit our site and enjoy the hassel free mode printing your photos...";

			template = template.replaceAll("\\$\\{MsgBody\\}", message);

			System.out.println("TEXT: " + template);
			email.setHtmlMsg(template);
			email.send();
			PrintPhotoLogger
					.log4j(FQCN,
							LOG.INFO,
							"Registration Confirmation mail has been successfully sent.",
							null);
			return true;
		} catch (EmailException e) {
			e.printStackTrace();
			PrintPhotoLogger
					.log4j(FQCN,
							LOG.ERROR,
							"Email Exception encountered while sending Registration Confirmation mail.",
							e);
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			PrintPhotoLogger
					.log4j(FQCN,
							LOG.ERROR,
							"Exception encountered while sending Registration Confirmation mail.",
							e);
			return false;
		}
	}

	/**
	 * This method sends mail to thank users
	 * 
	 * @param user
	 * @return
	 */
	public boolean sendThanksMessage(User user, ThanksTemplate thanksTemplate) {

		String template = thanksTemplate.getTemplate();

		HtmlEmail email = new HtmlEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(587);
		email.setStartTLSEnabled(true);

		email.setAuthentication("rimad0711@gmail.com", "rima03das");
		email.setSSLOnConnect(true);
		try {
			email.setFrom("rimad0711@gmail.com");
			email.setSubject("Thank you ...");
			email.setMsg("Just Keeping in Touch... :-)");
			email.addTo("rimad0711@gmail.com");
			// email.attach(new
			// File("C:\\Users\\Public\\Pictures\\Sample Pictures\\Lighthouse.jpg"));

			/*
			 * String id = email.embed(new URL(
			 * "file:C:\\Users\\Public\\Pictures\\Sample Pictures\\Lighthouse.jpg"
			 * ), "Lighthouse.jpg"); System.out.println("ID " + id);
			 */
			template = template.replaceAll("\\$\\{Hello\\}",
					"Hello " + user.getName());
			String message = "Thank you so much for.... ";

			template = template.replaceAll("\\$\\{MsgBody\\}", message);

			System.out.println("TEXT: " + template);
			email.setHtmlMsg(template);
			email.send();
			PrintPhotoLogger.log4j(FQCN, LOG.INFO,
					"Thank you mail has been successfully sent.", null);
			return true;
		} catch (EmailException e) {
			e.printStackTrace();
			PrintPhotoLogger
					.log4j(FQCN,
							LOG.ERROR,
							"Email Exception encountered while sending thank you mail.",
							e);
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			PrintPhotoLogger.log4j(FQCN, LOG.ERROR,
					"Exception encountered while sending thank you mail.", e);
			return false;
		}
	}

	/**
	 * This method sends mail to inform users about their registration
	 * cancellation
	 * 
	 * @param user
	 * @param registrationCancellationTemplate
	 * @return
	 */
	public boolean sendRegistrationCancellationMessage(User user,
			RegistrationCancellationTemplate registrationCancellationTemplate) {

		String template = registrationCancellationTemplate.getTemplate();

		HtmlEmail email = new HtmlEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(587);
		email.setStartTLSEnabled(true);

		email.setAuthentication("rimad0711@gmail.com", "rima03das");
		email.setSSLOnConnect(true);
		try {
			email.setFrom("rimad0711@gmail.com");
			email.setSubject("Registration Cancellation");
			email.setMsg("Just Keeping in Touch... :-)");
			email.addTo("rimad0711@gmail.com");
			// email.attach(new
			// File("C:\\Users\\Public\\Pictures\\Sample Pictures\\Lighthouse.jpg"));

			/*
			 * String id = email.embed(new URL(
			 * "file:C:\\Users\\Public\\Pictures\\Sample Pictures\\Lighthouse.jpg"
			 * ), "Lighthouse.jpg"); System.out.println("ID " + id);
			 */
			template = template.replaceAll("\\$\\{Hello\\}",
					"Hello " + user.getName());
			String message = "We are sorry to inform that your registration has been cancelled. ";

			template = template.replaceAll("\\$\\{MsgBody\\}", message);

			System.out.println("TEXT: " + template);
			email.setHtmlMsg(template);
			email.send();
			PrintPhotoLogger
					.log4j(FQCN,
							LOG.INFO,
							"Registration Cancellation mail has been successfully sent.",
							null);
			return true;
		} catch (EmailException e) {
			e.printStackTrace();
			PrintPhotoLogger
					.log4j(FQCN,
							LOG.ERROR,
							"Email Exception encountered while sending Registration Cancellation mail.",
							e);
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			PrintPhotoLogger
					.log4j(FQCN,
							LOG.ERROR,
							"Exception encountered while sending Registration Cancellation mail.",
							e);
			return false;
		}
	}

	/**
	 * This method sends mail to inform users about their Order cancellation
	 * 
	 * @param order
	 * @param orderCancellatioTemplate
	 * @return
	 */
	public boolean sendOrderCancellationMessage(Order order,
			OrderCancellationTemplate orderCancellatioTemplate) {

		String template = orderCancellatioTemplate.getTemplate();

		HtmlEmail email = new HtmlEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(587);
		email.setStartTLSEnabled(true);

		email.setAuthentication("rimad0711@gmail.com", "rima03das");
		email.setSSLOnConnect(true);
		try {
			email.setFrom("rimad0711@gmail.com");
			email.setSubject("Confirming Order Cancellation");
			email.setMsg("Just Keeping in Touch... :-)");
			email.addTo("rimad0711@gmail.com");
			// email.attach(new
			// File("C:\\Users\\Public\\Pictures\\Sample Pictures\\Lighthouse.jpg"));

			/*
			 * String id = email.embed(new URL(
			 * "file:C:\\Users\\Public\\Pictures\\Sample Pictures\\Lighthouse.jpg"
			 * ), "Lighthouse.jpg"); System.out.println("ID " + id);
			 */
			template = template.replaceAll("\\$\\{Hello\\}", "Hello "
					+ order.getUser().getName());
			String orderList = "";

			for (Product p : order.getProductList()) {
				if (p instanceof Photo) {
					if (!orderList.equals("")) {
						orderList = orderList + "<br>";
						orderList = orderList + ((Photo) p).getFileName()
								+ ", " + ((Photo) p).getDimension() + ", "
								+ ((Photo) p).getPaperType();
					} else {
						orderList = "Photo - ";
						orderList = orderList + ((Photo) p).getFileName()
								+ ", " + ((Photo) p).getDimension().getLength()
								+ "\" X "
								+ ((Photo) p).getDimension().getWidth()
								+ "\", " + ((Photo) p).getPaperType();
					}
				}
				if (p instanceof Album) {
					if (!orderList.equals("")) {
						orderList = orderList + "<br>";
						orderList = orderList + ((Album) p).getProductId();
					} else {
						orderList = "Album - ";
						orderList = orderList + ((Album) p).getProductId();
					}
				}
				if (p instanceof Poster) {
					if (!orderList.equals("")) {
						orderList = orderList + "<br>";
						orderList = orderList
								+ ((Poster) p).getPhotoPoster().getFileName();
					} else {
						orderList = "Poster - ";
						orderList = orderList
								+ ((Poster) p).getPhotoPoster().getFileName();
					}
				}
			}
			System.out.println("order list " + orderList);
			String message = "Your order has been cancelled. Please find the below details. <br> Order ID: "
					+ order.getOrderId() + "<br> Order Details: " + orderList;

			template = template.replaceAll("\\$\\{MsgBody\\}", message);

			System.out.println("TEXT: " + template);
			email.setHtmlMsg(template);
			email.send();
			PrintPhotoLogger
					.log4j(FQCN,
							LOG.INFO,
							"Order Cancellation mail has been successfully sent.",
							null);
			return true;
		} catch (EmailException e) {
			e.printStackTrace();
			PrintPhotoLogger
					.log4j(FQCN,
							LOG.ERROR,
							"Email Exception encountered while sending Order Cancellation mail.",
							e);
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			PrintPhotoLogger
					.log4j(FQCN,
							LOG.ERROR,
							"Exception encountered while sending Order Cancellation mail.",
							e);
			return false;
		}
	}

	/**
	 * This method sends mail to inform users about their shipment
	 * 
	 * @param order
	 * @param shipementShippedTemplate
	 * @return
	 */
	public boolean sendOrderShippedMessage(Order order,
			ShipmentShippedTemplate shipementShippedTemplate) {
		return false;
	}

	/**
	 * This method sends mail to inform users that their shipment has reached
	 * 
	 * @param order
	 * @param shipmentReachedTemplate
	 * @return
	 */
	public boolean sendOrderShipmentReachedTemplate(Order order,
			ShipmentReachedTemplate shipmentReachedTemplate) {
		return false;
	}

	@Override
	protected void finalize() throws Throwable {
		PrintPhotoLogger.log4j(FQCN, LOG.INFO,
				" MailService Service UnLoaded.", null);
	}

}
