package com.bilgeadam.SpringBootTuran.dto;

public class CartItemDTO{

	private int productId;
	private String productName;
	private double price;
	private Integer productQuantity;
	private double lineTotalAmount;
	private String image;
	private int tax;
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Integer getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(Integer productQuantity) {
		this.productQuantity = productQuantity;
	}
	public double getLineTotalAmount() {
		return lineTotalAmount;
	}
	public void setLineTotalAmount(double lineTotalAmount) {
		this.lineTotalAmount = lineTotalAmount;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getTax() {
		return tax;
	}
	public void setTax(int tax) {
		this.tax = tax;
	}

}


