package com.bilgeadam.SpringBootTuran.dto;

public class ZipcodeDto {
	

	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	private String	semt;
	private String	mahalle;
	private String	postakodu;
	

}
