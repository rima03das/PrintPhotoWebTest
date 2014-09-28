package in.pulseinfotech.printphoto.dto;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import in.pulseinfotech.printphoto.exception.DimensionException;
import in.pulseinfotech.printphoto.exception.PaperTypeException;
import in.pulseinfotech.printphoto.exception.ProductIdException;
import in.pulseinfotech.printphoto.services.communication.MailService;
import in.pulseinfotech.printphoto.services.logging.PrintPhotoLogger;
import in.pulseinfotech.printphoto.services.logging.PrintPhotoLogger.LOG;

/**
 * This is a base class for every kind of product.
 * 
 * @author Rima Das
 * @version 1.0
 * @since 16 September 2014 <br>
 * <br>
 * <br>
 */
@Entity
public class Product {
	private static String FQCN = Product.class.getName();
	/**
	 * This field holds the product id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long productId;

	/**
	 * This field holds the comment
	 */
	private String productComment;

	/**
	 * This field holds the reference of the {@link Dimension} class which
	 * defines the length and width of the image.
	 */
	@Embedded
	private Dimension dimension;

	/**
	 * 
	 * @return product id
	 */
	public long getProductId() {
		return productId;
	}

	/**
	 * 
	 * @param productId
	 */
	public void setProductId(long productId) throws ProductIdException {
		if (productId >= 0) {
			this.productId = productId;
		} else {

			PrintPhotoLogger.log4j(FQCN, LOG.ERROR, "Negative Product ID",
					new ProductIdException(" Negative Product ID "));
			throw new ProductIdException(" Negative Product ID ");
		}
	}

	/**
	 * 
	 * @return productComment
	 */
	public String getProductComment() {
		return productComment;
	}

	/**
	 * 
	 * @param comment
	 */
	public void setProductComment(String productComment) {
		this.productComment = productComment;
	}

	/**
	 * 
	 * @return reference to {@link Dimension}
	 */
	public Dimension getDimension() {
		return dimension;
	}

	/**
	 * 
	 * @param dimension
	 * @see Dimension
	 * @throws DimensionException
	 */
	public void setDimension(Dimension dimension) throws DimensionException {
		if (dimension != null) {
			this.dimension = dimension;
		} else {
			PrintPhotoLogger.log4j(FQCN, LOG.ERROR,
					"Null reference received for dimension",
					new DimensionException(
							"Null reference received for dimension"));
			throw new DimensionException(
					"Null reference received for dimension");
		}
	}

}
