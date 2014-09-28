package in.pulseinfotech.printphoto.dto;

/**
 * This is an enumeration defining the the various types of papers to be used for printing.
 * 
 * @author Rima Das
 * @version 1.0
 * @since 16 September 2014 <br>
 * <br>
 * <br>
 * 
 * {@link in.pulseinfotech.printphoto.dto.PaperType#GLOSSY GLOSSY},
 * {@link in.pulseinfotech.printphoto.dto.PaperType#METALLIC METALLIC},
 * {@link in.pulseinfotech.printphoto.dto.PaperType#MATTE MATTE},
 *  {@link in.pulseinfotech.printphoto.dto.PaperType#LUSTURE LUSTURE}
 */

public enum PaperType {

	/**
	 * METALLIC: The photo will have Metallic finish. 
	 */
	METALLIC("metallic"), 
	
	/**
	 * GLOSSY: The photo will have Glossy finish.
	 */
	GLOSSY("glossy"), 
	
	/**
	 * MATTE: The photo will have Matte finish.
	 */
	MATTE("matte"),
	
	/**
	 * LUSTURE: The photo will have LUSTURE finish.
	 */
	LUSTURE("lusture");

	private String paperType;

	private PaperType(String type) {
		paperType = type;
	}

	public String getPaperType() {
		return paperType;
	}

}
