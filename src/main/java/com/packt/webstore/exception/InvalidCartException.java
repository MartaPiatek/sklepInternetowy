package com.packt.webstore.exception;

public class InvalidCartException extends RuntimeException{

	private static final long serialVersionUID=6350930334140807514L;
	private String cartId;
	
	public InvalidCartException(String cartId) {
		this.cartId = cartId;
	}

	public String getCartId() {
		return cartId;
	}
	
	
	
	
}
