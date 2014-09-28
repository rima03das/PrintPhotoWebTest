package in.pulseinfotech.printphoto.dto;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 * This is class holds the details of a poster.
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
public class Poster extends Product {

	@OneToOne
	private Photo photoPoster;

	public Photo getPhotoPoster() {
		return photoPoster;
	}

	public void setPhotoPoster(Photo photoPoster) {
		this.photoPoster = photoPoster;
	}
}
