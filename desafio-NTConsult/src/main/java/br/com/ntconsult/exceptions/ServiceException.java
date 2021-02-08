package br.com.ntconsult.exceptions;

public class ServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ServiceException() {	
	}
	
	public ServiceException(String message) {
		super(message);
	}
	

}
