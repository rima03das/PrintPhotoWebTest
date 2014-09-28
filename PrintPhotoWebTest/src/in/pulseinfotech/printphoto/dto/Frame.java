package in.pulseinfotech.printphoto.dto;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 * This is class holds the details of a Frame.
 * 
 * @author Raman Ahuja
 * @version 1.0
 * @since 16 September 2014 <br>
 * <br>
 * <br>
 * 
 * 
 */
@Entity
public class Frame extends Product {

	@OneToOne
	private Photo framePhoto;

	public Photo getFramePhoto() {
		return framePhoto;
	}

	public void setFramePhoto(Photo framePhoto) {
		this.framePhoto = framePhoto;
	}

}
