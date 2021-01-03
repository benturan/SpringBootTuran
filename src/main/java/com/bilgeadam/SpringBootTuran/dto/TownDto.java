package com.bilgeadam.SpringBootTuran.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


public class TownDto  implements Serializable {
	


	private int id;		
	private String	il;	
	private String	ilce;
	

	public int getId() {
		return id;
	}


	public void setId(int id) {
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

	
	
}