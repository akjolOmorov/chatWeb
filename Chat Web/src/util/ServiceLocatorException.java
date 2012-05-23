package util;

/***
 * 
 * @author dolphin
 *
 */

public class ServiceLocatorException extends Exception {

	private static final long serialVersionUID = -4397314211412388701L;
	private String message = null;
	
	public ServiceLocatorException() {}
	
	public ServiceLocatorException(String message) {
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return message;
	}
	

}
