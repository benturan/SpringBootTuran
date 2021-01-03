package com.bilgeadam.SpringBootTuran.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class OrderDTO {
	
	
	private Long orderid;
	private int userid;
	private String userNameSurname;
	private int paymentmode;
	
	private Date date;
	private double price;
	private double tax;
	private double total;
	private int orderTrackingId;
	private int status;
	private List<ProductDTO> ordredproduct;

	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	

	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getTax() {
		return tax;
	}
	public void setTax(double tax) {
		this.tax = tax;
	}

	public int getOrderTrackingId() {
		return orderTrackingId;
	}
	public void setOrderTrackingId(int orderTrackingId) {
		this.orderTrackingId = orderTrackingId;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public List<ProductDTO> getOrdredproduct() {
		return ordredproduct;
	}
	public void setOrdredproduct(List<ProductDTO> ordredproduct) {
		this.ordredproduct = ordredproduct;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Long getOrderid() {
		return orderid;
	}
	public void setOrderid(Long orderid) {
		this.orderid = orderid;
	}
	public int getPaymentmode() {
		return paymentmode;
	}
	public void setPaymentmode(int paymentmode) {
		this.paymentmode = paymentmode;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public String getUserNameSurname() {
		return userNameSurname;
	}
	public void setUserNameSurname(String userNameSurname) {
		this.userNameSurname = userNameSurname;
	}


}
