package in.pulseinfotech.printphoto.dto;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 * This is class holds the details of a laminate.
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
public class Laminate extends Product {

	@OneToOne
	private Photo laminatePhoto;

	public Photo getLaminatePhoto() {
		return laminatePhoto;
	}

	public void setLaminatePhoto(Photo laminatePhoto) {
		this.laminatePhoto = laminatePhoto;
	}
}
