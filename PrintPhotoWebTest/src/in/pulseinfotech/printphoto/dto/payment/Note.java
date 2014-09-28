package in.pulseinfotech.printphoto.dto.payment;

import java.util.regex.Pattern;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import in.pulseinfotech.printphoto.exception.NoteSerialNumberException;
import in.pulseinfotech.printphoto.exception.NoteValueException;
import in.pulseinfotech.printphoto.exception.UserStatusException;
import in.pulseinfotech.printphoto.services.communication.MailService;
import in.pulseinfotech.printphoto.services.logging.PrintPhotoLogger;
import in.pulseinfotech.printphoto.services.logging.PrintPhotoLogger.LOG;

/**
 * 
 * This class holds details for the Note used for paying for the order. It has
 * details like note value and note serial number.
 * 
 * @author Rima Das,Gufran Khurshid
 * @version 1.0
 * @since 20 September 2014 <br>
 * <br>
 * <br>
 * 
 *        {@link in.pulseinfotech.printphoto.dto.payment.Note#noteValue Note
 *        Value},
 *        {@link in.pulseinfotech.printphoto.dto.payment.Note#noteSerialNumber
 *        Note Serial Number}
 * 
 * @see PaymentMode
 */
@Entity
public class Note {
	private static String FQCN = Note.class.getName();

	/**
	 * This field holds note id(This is just to manage note information ).
	 * 
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long noteId;

	/**
	 * This field holds the value of a note.
	 * 
	 * @see NoteValue
	 */

	@Enumerated(EnumType.STRING)
	private NoteValue noteValue;

	/**
	 * This field holds the serial number of a note.
	 */
	private String noteSerialNumber;

	/**
	 * 
	 * @return A reference to {@link NoteValue}
	 */
	public NoteValue getNoteValue() {
		return noteValue;
	}

	/**
	 * 
	 * @param noteValue
	 * @see NoteValue
	 * @throws NoteValueException
	 */
	public void setNoteValue(NoteValue noteValue) throws NoteValueException {
		if (noteValue != null) {
			if (noteValue.equals(NoteValue.THOUSAND)
					|| noteValue.equals(NoteValue.FIVEHUNDRED)
					|| noteValue.equals(NoteValue.HUNDRED)
					|| noteValue.equals(NoteValue.FIFTY)
					|| noteValue.equals(NoteValue.TWENTY)
					|| noteValue.equals(NoteValue.TEN)
					|| noteValue.equals(NoteValue.FIVE)
					|| noteValue.equals(NoteValue.TWO)
					|| noteValue.equals(NoteValue.ONE)) {
				this.noteValue = noteValue;
			} else {
				PrintPhotoLogger
						.log4j(FQCN,
								LOG.ERROR,
								"Invalid note value received. The value should be: THOUSAND, FIVEHUNDRED, HUNDRED, FIFTY, TWENTY, TEN, FIVE, TWO, ONE.",
								new NoteValueException(
										"Invalid note value received. The value should be: THOUSAND, FIVEHUNDRED, HUNDRED, FIFTY, TWENTY, TEN, FIVE, TWO, ONE."));
				throw new NoteValueException(
						"Invalid note value received. The value should be: THOUSAND, FIVEHUNDRED, HUNDRED, FIFTY, TWENTY, TEN, FIVE, TWO, ONE.");
			}
		} else {
			PrintPhotoLogger.log4j(FQCN, LOG.ERROR,
					"Null value received for Note Value.",
					new NoteValueException(
							"Null value received for Note Value."));
			throw new NoteValueException("Null value received for Note Value.");
		}
	}

	/**
	 * 
	 * @return Serial number on the note
	 */
	public String getNoteSerialNumber() {
		return noteSerialNumber;
	}

	/**
	 * 
	 * @return ID of note
	 */
	public long getNoteId() {
		return noteId;
	}

	/**
	 * 
	 * @return set ID of note
	 */

	public void setNoteId(long noteId) {
		this.noteId = noteId;
	}

	/**
	 * 
	 * @param noteSerialNumber
	 * @throws NoteSerialNumberException
	 * @throws NoteValueException
	 */
	public void setNoteSerialNumber(String noteSerialNumber)
			throws NoteSerialNumberException, NoteValueException {
		/* FOR DENOMINATIONS OF FIVE, TEN and TWENTY */
		String serialTypeOne = "^[0-9]{2}[^i,I,j,J,o,O,x,X,y,Y,z,Z,0-9]{1}\\s[0-9]{6}$";
		String serialTypeTwo = "^[0-9]{2}[^i,I,j,J,o,O,x,X,y,Y,z,Z,0-9]{1}\\s1000000$";

		/* FOR DENOMINATIONS OF FIFTY, HUNDRED, FIVEHUNDRED and THOUSAND */
		String serialTypeThree = "^[0-9]{1}[^i,I,j,J,o,O,x,X,y,Y,z,Z,0-9]{2}\\s0[0-9]{5}$";
		String serialTypeFour = "^[0-9]{1}[^i,I,j,J,o,O,x,X,y,Y,z,Z,0-9]{2}\\s100000$";

		if (noteSerialNumber != "" && noteSerialNumber != null) {
			if (noteValue.equals(NoteValue.ONE)
					|| noteValue.equals(NoteValue.TWO)
					|| noteValue.equals(NoteValue.FIVE)
					|| noteValue.equals(NoteValue.TEN)
					|| noteValue.equals(NoteValue.TWENTY)) {
				if (Pattern.matches(serialTypeOne, noteSerialNumber)
						|| Pattern.matches(serialTypeTwo, noteSerialNumber)) {
					this.noteSerialNumber = noteSerialNumber;
				} else {
					PrintPhotoLogger.log4j(FQCN, LOG.ERROR,
							"In valid serial number received.",
							new NoteSerialNumberException(
									"In valid serial number received"));
					throw new NoteSerialNumberException(
							"In valid serial number received");
				}
			} else if (noteValue.equals(NoteValue.FIFTY)
					|| noteValue.equals(NoteValue.HUNDRED)
					|| noteValue.equals(NoteValue.FIVEHUNDRED)
					|| noteValue.equals(NoteValue.THOUSAND)) {
				if (Pattern.matches(serialTypeThree, noteSerialNumber)
						|| Pattern.matches(serialTypeFour, noteSerialNumber)) {
					this.noteSerialNumber = noteSerialNumber;
				} else {
					PrintPhotoLogger.log4j(FQCN, LOG.ERROR,
							"In valid serial number received",
							new NoteSerialNumberException(
									"In valid serial number received"));
					throw new NoteSerialNumberException(
							"In valid serial number received");
				}
			} else {
				PrintPhotoLogger
						.log4j(FQCN,
								LOG.ERROR,
								"Invalid note value received. The value should be: THOUSAND, FIVEHUNDRED, HUNDRED, FIFTY, TWENTY, TEN, FIVE, TWO, ONE.",
								new NoteValueException(
										"Invalid note value received. The value should be: THOUSAND, FIVEHUNDRED, HUNDRED, FIFTY, TWENTY, TEN, FIVE, TWO, ONE."));
				throw new NoteValueException(
						"Invalid note value received. The value should be: THOUSAND, FIVEHUNDRED, HUNDRED, FIFTY, TWENTY, TEN, FIVE, TWO, ONE.");
			}
		} else {
			PrintPhotoLogger.log4j(FQCN, LOG.ERROR,
					"Null value received for serial number.",
					new NoteSerialNumberException(
							"Null value received for serial number"));
			throw new NoteSerialNumberException(
					"Null value received for serial number");
		}

	}
}
