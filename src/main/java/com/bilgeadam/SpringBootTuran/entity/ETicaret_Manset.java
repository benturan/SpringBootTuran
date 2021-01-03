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
@Table(name = "eticaret_manset")
public class ETicaret_Manset implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	private Long id;

	@Column(name = "Image")
	private String image;

	@Column(name = "Baslik")
	private String baslik;

	@Column(name = "Detay")
	private String detay;

	@Column(name = "Sira")
	private int sira;

	@Column(name = "CategoryId")
	private int categoryId;

	@Column(name = "Statu")
	private int statu;
	
	
	



	public ETicaret_Manset() {
		// TODO Auto-generated constructor stub
	}


	public ETicaret_Manset(Long id, String image, String baslik, String detay, int sira, int categoryId, int statu) {
		super();
		this.id = id;
		this.image = image;
		this.baslik = baslik;
		this.detay = detay;
		this.sira = sira;
		this.categoryId = categoryId;
		this.statu = statu;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public String getBaslik() {
		return baslik;
	}


	public void setBaslik(String baslik) {
		this.baslik = baslik;
	}


	public String getDetay() {
		return detay;
	}


	public void setDetay(String detay) {
		this.detay = detay;
	}


	public int getSira() {
		return sira;
	}


	public void setSira(int sira) {
		this.sira = sira;
	}


	public int getCategoryId() {
		return categoryId;
	}


	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}


	public int getStatu() {
		return statu;
	}


	public void setStatu(int statu) {
		this.statu = statu;
	}


	

}

