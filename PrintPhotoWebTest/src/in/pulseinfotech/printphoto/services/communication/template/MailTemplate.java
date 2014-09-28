package in.pulseinfotech.printphoto.services.communication.template;

/**
 * 
 * This class is an abstract class defining the various mail templates.
 * The name of the .html files should correspond to the name of the template class it is made for.
 * 
 * @author Raman Ahuja
 * @version 1.0
 * @since 16 September 2014 <br>
 * <br>
 * @see MessageTemplate
 * @see OrderTemplate
 * @see RegistrationTemplate
 * @see TrackingTemplate
 * 
 */
public abstract class MailTemplate {

	public MailTemplate() {
		loadHTML();
	}

	private String template;

	abstract protected void loadHTML();

	public String getTemplate() {
		return template;
	}

	protected void setTemplate(String temp) {
		template = temp;
	}

}
