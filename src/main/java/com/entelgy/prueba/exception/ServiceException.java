package com.entelgy.prueba.exception;

import lombok.Getter;
import lombok.ToString;

/**
 * 
 * @author Jhonatan A.
 *
 */
@Getter
@ToString
public class ServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8959940393784849258L;
	
	private final String message;
	
	public ServiceException(String message) {
		super(message);
		this.message=message;
	}
	
}
