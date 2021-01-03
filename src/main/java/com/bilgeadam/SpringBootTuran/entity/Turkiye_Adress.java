package com.bilgeadam.SpringBootTuran.entity;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="turkiye_adress_list")
public class Turkiye_Adress implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Id")
	private Long id;
	
	@Column(name="il")
	private String	il;
	
	@Column(name="ilce")
	private String	ilce;
	
	@Column(name="semt_bucak_belde")
	private String	semt;
	
	@Column(name="mahalle")
	private String	mahalle;
	
	@Column(name="pk")
	private String	postakodu;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIl() {
		return il;
	}

	public void setIl(String il) {
		this.il = il;
	}

	public String getIlce() {
		return ilce;
	}

	public void setIlce(String ilce) {
		this.ilce = ilce;
	}

	public String getSemt() {
		return semt;
	}

	public void setSemt(String semt) {
		this.semt = semt;
	}

	public String getMahalle() {
		return mahalle;
	}

	public void setMahalle(String mahalle) {
		this.mahalle = mahalle;
	}

	public String getPostakodu() {
		return postakodu;
	}

	public void setPostakodu(String postakodu) {
		this.postakodu = postakodu;
	}
	
}
