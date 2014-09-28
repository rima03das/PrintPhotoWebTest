package in.pulseinfotech.printphoto.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 * This is class holds the details of an Album.
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
public class Album extends Product {

	@OneToMany
	private List<Photo> albumPhotos = new ArrayList<>();

	public List<Photo> getAlbumPhotos() {
		return albumPhotos;
	}

	public void setAlbumPhotos(List<Photo> albumPhotos) {
		this.albumPhotos = albumPhotos;
	}

}
