package in.pulseinfotech.printphoto.dto;

import javax.persistence.Embeddable;

/**
 * This class defines the format of an Address field used across the project. It
 * takes details like house number, Street Name, C/O, D/O, S/O, Sector Number,
 * Pocket Number, Apartment Name, Flat Number etc, PIN code, City, State and
 * landmark.
 * 
 * @author Rima Das,Gufran Khurshid
 * @version 1.0
 * @since 16 September 2014 <br>
 * <br>
 * <br>
 *        {@link in.pulseinfotech.printphoto.dto.Address#title Title},
 *        {@link in.pulseinfotech.printphoto.dto.Address#pin PIN},
 *        {@link in.pulseinfotech.printphoto.dto.Address#city City},
 *        {@link in.pulseinfotech.printphoto.dto.Address#state State},
 *        {@link in.pulseinfotech.printphoto.dto.Address#landmark Landmark},
 * 
 */

@Embeddable
public class Address {

	/**
	 * Enter the address like house number, Street Name, C/O, D/O, S/O, Sector
	 * Number, Pocket Number, Apartment Name, Flat Number etc
	 */
	private String title;

	/**
	 * This member variable holds the PIN Code of the area
	 */
	private int pin;

	/**
	 * This member variable holds the name of city.
	 */
	private String city;

	/**
	 * This member variable holds the name of the State.
	 */
	private String state;

	/**
	 * This member variable holds the nearest landmark to the address proposed
	 */
	private String landmark;

	/**
	 * 
	 * @return The address like house number, Street Name, C/O, D/O, S/O, Sector
	 *         Number, Pocket Number, Apartment Name, Flat Number etc
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * 
	 * @param title
	 *            The address like house number, Street Name, C/O, D/O, S/O,
	 *            Sector Number, Pocket Number, Apartment Name, Flat Number etc
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * 
	 * @return The PIN Code of the area
	 */
	public int getPin() {
		return pin;
	}

	/**
	 * 
	 * @param pin
	 *            The PIN Code of the area
	 */
	public void setPin(int pin) {
		this.pin = pin;
	}

	/**
	 * 
	 * @return The name of city.
	 */
	public String getCity() {
		return city;
	}

	/**
	 * 
	 * @param city
	 *            The name of city.
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * 
	 * @return The name of the State.
	 */
	public String getState() {
		return state;
	}

	/**
	 * 
	 * @param state
	 *            The name of the State.
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * 
	 * @return The nearest landmark to the address proposed
	 */
	public String getLandmark() {
		return landmark;
	}

	/**
	 * 
	 * @param landmark
	 *            The nearest landmark to the address proposed
	 */
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

}
