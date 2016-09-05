package com.packt.webstore.exception;



public class ProductNotFoundException extends RuntimeException {

	private static final long serialVersionUID=-69435492032299587L;
	private String productId;
	
	public ProductNotFoundException(String productId) {
		super();
		this.productId = productId;
	}
	public String getProductId() {
		return productId;
	}
	
	
	
	
}// koniec klasy
