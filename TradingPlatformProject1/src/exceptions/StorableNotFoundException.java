package exceptions;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class StorableNotFoundException extends Exception{
	public StorableNotFoundException(String message) {
		super(message);
		PropertyConfigurator.configure("log4j.properties");
		log.error(message);
	}
	
	public StorableNotFoundException(Throwable Cause){
		super(Cause);
	}
	
	static Logger log = 
			Logger.getLogger(StorableNotFoundException.class);
}
