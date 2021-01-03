package com.bilgeadam.SpringBootTuran.entity;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
@Table(name = "eticaret_products")
public class ETicaret_Products implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ProductID")
	private Long productID;
	
	@Column(name = "Name")
	private String name;
	
	@Column(name = "Description")
	private String description;
	
	@Column(name = "OldPrice")
	private double oldPrice;
	
	@Column(name = "Price")
	private double price;
	
	@Column(name = "Image")
	private String image;
	
	@Column(name = "Sales")
	private int sales;
	
	@Column(name = "CategoryId")
	private Long categoryid;
	
	@Column(name = "Dates")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dates;
	
	
	@Column(name = "Limit")
	private double limit;
	
	@Column(name = "Stock")
	private int stock;
	
	@Column(name = "Tax")
	private int tax;
	
	@Column(name = "Status")
	private int status;


	public ETicaret_Products(long l, String string, double d, String string2, int i, long m, Date date, int j) {
		// TODO Auto-generated constructor stub
	}


	public ETicaret_Products() {
		// TODO Auto-generated constructor stub
	}


	public Long getProductID() {
		return productID;
	}


	public void setProductID(Long productID) {
		this.productID = productID;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public int getSales() {
		return sales;
	}


	public void setSales(int sales) {
		this.sales = sales;
	}


	public Date getDates() {
		return dates;
	}


	public void setDates(Date dates) {
		this.dates = dates;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public long getCategoryid() {
		return categoryid;
	}


	public void setCategoryid(long categoryid) {
		this.categoryid = categoryid;
	}


	public void setCategoryid(Long categoryid) {
		this.categoryid = categoryid;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public double getOldPrice() {
		return oldPrice;
	}


	public void setOldPrice(double oldPrice) {
		this.oldPrice = oldPrice;
	}





	public int getStock() {
		return stock;
	}


	public void setStock(int stock) {
		this.stock = stock;
	}


	public double getLimit() {
		return limit;
	}


	public void setLimit(double limit) {
		this.limit = limit;
	}


	public int getTax() {
		return tax;
	}


	public void setTax(int tax) {
		this.tax = tax;
	}


}

