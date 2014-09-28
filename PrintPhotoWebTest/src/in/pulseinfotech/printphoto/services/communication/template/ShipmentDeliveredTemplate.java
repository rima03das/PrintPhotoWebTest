package in.pulseinfotech.printphoto.services.communication.template;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * 
 * This class is a  subclass <code>TrackingTemplate</code> defining the mail template for Shipping Delivered mails.
 * 
 * @author Raman Ahuja
 * @version 1.0
 * @since 16 September 2014 <br>
 * <br>
 * @see TrackingTemplate
 * 
 */
public class ShipmentDeliveredTemplate extends TrackingTemplate{

	@Override
	protected void loadHTML() {
		File html = new File("src/testpkg/ShipmentDeliveredTemplate.html");
		System.out.println(html.getAbsolutePath());
		String temp;
		String text = "";
		FileReader fileReader;
		try {
			fileReader = new FileReader(html);
			BufferedReader br = new BufferedReader(fileReader);
			while ((temp = br.readLine()) != null) {
				text = text + temp;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		setTemplate(text);

	}

}
