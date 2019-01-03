package com.savaleks.website.exception;

import java.io.Serializable;

public class ProductNotFound extends Exception implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	
	public String getMessage() {
		return message;
	}

	public ProductNotFound() {
		this("Product is not available.");
	}
	
	public ProductNotFound(String message) {
		this.message = System.currentTimeMillis() + ": " + message;
	}
}
