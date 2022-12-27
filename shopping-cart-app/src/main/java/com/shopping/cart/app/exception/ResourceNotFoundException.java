package com.shopping.cart.app.exception;

public class ResourceNotFoundException extends Exception {
	
	private static final long serialVersionUID = -7076854111898455591L;

	public ResourceNotFoundException(String message) {
		super(message);
	}
}
