package com.bilgeadam.SpringBootTuran.entity;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
@Table(name = "eticaret_products_media")
public class ETicaret_Products_Media implements Serializable {
	//{1, 1, 13, El Çantası Ürün 1 Ön, http://springboot-ecommerce.herokuapp.com/resources/img/catalog/1.png, Çanta Ön, 2001-01-20 20:00:00.0, 1}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	private int Id;

	@Column(name = "media_type_id")
	private int media_type_id;

	@Column(name = "productId")
	private int productId;

	@Column(name = "media_name")
	private String media_name;

	@Column(name = "media_url")
	private String media_url;

	@Column(name = "media_description")
	private String media_description;

	@Column(name = "insert_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date insert_date;

	@Column(name = "status")
	private int status;

	public int getId() {
		return Id;
	}

	public void setId(int Id) {
		this.Id = Id;
	}

	public int getMedia_type_id() {
		return media_type_id;
	}

	public void setMedia_type_id(int media_type_id) {
		this.media_type_id = media_type_id;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getMedia_name() {
		return media_name;
	}

	public void setMedia_name(String media_name) {
		this.media_name = media_name;
	}

	public String getMedia_url() {
		return media_url;
	}

	public void setMedia_url(String media_url) {
		this.media_url = media_url;
	}

	public String getMedia_description() {
		return media_description;
	}

	public void setMedia_description(String media_description) {
		this.media_description = media_description;
	}

	public Date getInsert_date() {
		return insert_date;
	}

	public void setInsert_date(Date insert_date) {
		this.insert_date = insert_date;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}