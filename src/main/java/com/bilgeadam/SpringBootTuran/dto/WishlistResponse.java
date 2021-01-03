package com.bilgeadam.SpringBootTuran.dto;

import java.util.List;

public class WishlistResponse {

	private String success;
	private String message;
	private List<ProductDTO> product = null;
	
	public String getSuccess() {
		return success;
	}
	public void setSuccess(String success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<ProductDTO> getProduct() {
		return product;
	}
	public void setProduct(List<ProductDTO> product) {
		this.product = product;
	}

}
