package in.pulseinfotech.printphoto.dto;

import javax.persistence.Embeddable;

import in.pulseinfotech.printphoto.exception.DimensionException;
import in.pulseinfotech.printphoto.services.PhotoPrintManager;
import in.pulseinfotech.printphoto.services.logging.PrintPhotoLogger;
import in.pulseinfotech.printphoto.services.logging.PrintPhotoLogger.LOG;

/**
 * This class defines the dimensions of a product. It holds the length and width
 * of an image, album, posters and other products
 * 
 * @author Rima Das
 * @version 1.0
 * @since 16 September 2014 <br>
 * <br>
 * <br>
 * 
 *        {@link in.pulseinfotech.printphoto.dto.Dimension#length Length},
 *        {@link in.pulseinfotech.printphoto.dto.Dimension#width Width}
 * 
 */
@Embeddable
public class Dimension {

	private static String FQCN = Dimension.class.getName();
	/**
	 * Holds the length of the product in inches.
	 */
	private int length;

	/**
	 * Holds the width of the product in inches.
	 */
	private int width;

	/**
	 * 
	 * @return The length of the product.
	 */
	public int getLength() {
		return length;
	}

	/**
	 * 
	 * @param length
	 *            Sets the length of the product.
	 * @throws DimensionException
	 */
	public void setLength(int length) throws DimensionException {
		if (length > 0 && length <= 100) {
			this.length = length;
		} else {
			PrintPhotoLogger
					.log4j(FQCN,
							LOG.ERROR,
							"Exception encountered while exceeding length dimension.",
							new DimensionException(
									"Length exceeded the limits. Value should be within 1 inch to 100 inches. Value received "
											+ length));
			throw new DimensionException(
					"Length exceeded the limits. Value should be within 1 inch to 100 inches. Value received "
							+ length);
		}
	}

	/**
	 * 
	 * @return The length of the product.
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * 
	 * @param width
	 *            Sets the length of the product.
	 * @throws DimensionException
	 */
	public void setWidth(int width) throws DimensionException {
		if (width > 0 && width <= 100) {
			this.width = width;
		} else {
			PrintPhotoLogger
					.log4j(FQCN,
							LOG.ERROR,
							"Exception encountered while exceeding width dimension.",
							new DimensionException(
									"Width exceeded the limits. Value should be within 1 inch to 100 inches. Value received "
											+ width));
			throw new DimensionException(
					"Width exceeded the limits. Value should be within 1 inch to 100 inches. Value received "
							+ width);
		}
	}

}
