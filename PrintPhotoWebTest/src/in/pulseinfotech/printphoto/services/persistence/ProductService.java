package in.pulseinfotech.printphoto.services.persistence;

import in.pulseinfotech.printphoto.dto.Product;
import in.pulseinfotech.printphoto.services.logging.PrintPhotoLogger;
import in.pulseinfotech.printphoto.services.logging.PrintPhotoLogger.LOG;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * This class is a subclass <code>PersistenceService</code> defining the mail
 * template for Product Services.
 * 
 * @author Raman Ahuja
 * @version 1.0
 * @since 16 September 2014 <br>
 * <br>
 * <br>
 * @see PersistenceService
 * 
 */
public class ProductService extends PersistenceService {

	private static String FQCN = ProductService.class.getName();
	/**
	 * static block for logger info.
	 */
	static {
		PrintPhotoLogger.log4j(FQCN, LOG.INFO, "Product Service Loaded.", null);
	}

	List<String> errorsList;

	/**
	 * This method collects all the error and returns them in a list
	 * 
	 * @return
	 */
	public ProductService() {
		errorsList = new ArrayList<String>();
	}

	/**
	 * 
	 * @param product
	 * @return
	 */
	public boolean addProduct(Product product) {
		return false;
	}

	/**
	 * 
	 * @param product
	 * @return
	 */
	public boolean removeProduct(Product product) {
		return false;
	}

	/**
	 * 
	 * @param productId
	 * @return
	 */
	public boolean removeProduct(long productId) {
		return false;
	}

	/**
	 * 
	 * @param productId
	 * @return
	 */
	public boolean getProduct(long productId) {
		return false;
	}

	@Override
	protected void finalize() throws Throwable {
		PrintPhotoLogger.log4j(FQCN, LOG.INFO, "Product Service UnLoaded.", null);
	}
}
