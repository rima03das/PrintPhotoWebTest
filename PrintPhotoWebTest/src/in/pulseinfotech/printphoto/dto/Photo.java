package in.pulseinfotech.printphoto.dto;

import in.pulseinfotech.printphoto.exception.PaperTypeException;
import in.pulseinfotech.printphoto.services.logging.PrintPhotoLogger;
import in.pulseinfotech.printphoto.services.logging.PrintPhotoLogger.LOG;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * This is class holds the details of a photo. It is a subclass of
 * {@link Product}. It take details like Dimension, Paper Type, File Name.
 * 
 * @author Rima Das
 * @version 1.0
 * @since 16 September 2014 <br>
 * <br>
 * <br>
 * 
 * 
 *        {@link in.pulseinfotech.printphoto.dto.Photo#dimension Dimension},
 *        {@link in.pulseinfotech.printphoto.dto.Photo#paperType Paper Type},
 *        {@link in.pulseinfotech.printphoto.dto.Photo#fileName File Name}
 * 
 * @see Dimension
 * @see PaperType
 * 
 */
@Entity
public class Photo extends Product {
	private static String FQCN = Photo.class.getName();
	/**
	 * This field holds the name of the image uploaded.
	 */
	private String fileName;

	/**
	 * This field holds the {@link PaperType}.
	 */
	@Enumerated(EnumType.STRING)
	private PaperType paperType;

	/**
	 * 
	 * @return filename The name of the file
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * 
	 * @param fileName
	 *            The name of the file
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * 
	 * @return {@link PaperType}
	 */
	public PaperType getPaperType() {
		return paperType;
	}

	/**
	 * 
	 * @param paperType
	 * @throws PaperTypeException
	 */
	public void setPaperType(PaperType paperType) throws PaperTypeException {
		if (paperType != null) {
			if (paperType.equals(PaperType.GLOSSY)
					|| paperType.equals(PaperType.MATTE)
					|| paperType.equals(PaperType.METALLIC)
					|| paperType.equals(PaperType.LUSTURE)) {
				this.paperType = paperType;
			} else {
				PrintPhotoLogger
						.log4j(FQCN,
								LOG.ERROR,
								"Invalid papertype specified. Paper Type can only be th following: GLOSSY, MATTE, LUSTURE or METALLIC",
								new PaperTypeException(
										"Invalid papertype specified. Paper Type can only be th following: GLOSSY, MATTE, LUSTURE or METALLIC"));
				throw new PaperTypeException(
						"Invalid papertype specified. Paper Type can only be th following: GLOSSY, MATTE, LUSTURE or METALLIC");
			}
		} else {
			PrintPhotoLogger.log4j(FQCN, LOG.ERROR,
					"Null reference for papertyper recieved",
					new PaperTypeException(
							"Null reference for papertyper recieved"));
			throw new PaperTypeException(
					"Null reference for papertyper recieved");
		}
	}

}
