package exceptions;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class UsernamePasswordMismatchException extends Exception {
	
	public UsernamePasswordMismatchException(String message) {
		super(message);
		PropertyConfigurator.configure("log4j.properties");
		log.error(message);
	}
	
	public UsernamePasswordMismatchException(Throwable Cause){
		super(Cause);
	}
	
	static Logger log = 
			Logger.getLogger(NoUserException.class);
}
