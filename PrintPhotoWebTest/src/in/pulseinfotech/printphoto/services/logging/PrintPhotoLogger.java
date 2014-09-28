package in.pulseinfotech.printphoto.services.logging;

import org.apache.log4j.Logger;

public class PrintPhotoLogger extends Logger {

	protected PrintPhotoLogger(String name) {
		super(name);
	}

	private static Logger log = Logger.getLogger(Logger.class.getClass());

	public enum LOG {
		DEBUG, WARN, ERROR, INFO;
	};

	public static void log4j(String FQCN, LOG type, String message,
			Throwable throwable) {
		if (type.equals(LOG.DEBUG)) {
			if (throwable == null) {
				log.debug(FQCN + ": " + message);
			} else {
				log.debug(FQCN + ": " + message, throwable);
			}
		} else if (type.equals(LOG.ERROR)) {
			if (throwable == null) {
				log.error(FQCN + ": " + message);
			} else {
				log.error(FQCN + ": " + message, throwable);
			}
		} else if (type.equals(LOG.INFO)) {
			if (throwable == null) {
				log.info(FQCN + ": " + message);
			} else {
				log.info(FQCN + ": " + message, throwable);
			}
		} else if (type.equals(LOG.WARN)) {
			if (throwable == null) {
				log.warn(FQCN + ": " + message);
			} else {
				log.warn(FQCN + ": " + message, throwable);
			}
		} else {
			log.warn("NO LOG TYPE RECEIVED... MUST ONE OF THE FOLLOWING... WARN, DEBUG, INFO or ERROR");
		}
	}

}
