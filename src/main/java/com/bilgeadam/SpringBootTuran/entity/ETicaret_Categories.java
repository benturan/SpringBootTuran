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
@Table(name = "eticaret_category")
public class ETicaret_Categories implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CategoryId")
	private Long categoryid;
	
	@Column(name = "CategoryName")
	private String categoryname;
	
	@Column(name = "ImgSrc")
	private String imgsrc;
	
	@Column(name = "ParentCategoryId")
	private Long parentcategoryid;

	@Column(name = "IsActive")
	private int isactive;
	
	@Column(name = "CreatedDate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createddate;
	
	
	

	public Long getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(Long categoryid) {
		this.categoryid = categoryid;
	}

	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

	public String getImgsrc() {
		return imgsrc;
	}

	public void setImgsrc(String imgsrc) {
		this.imgsrc = imgsrc;
	}

	public Long getParentcategoryid() {
		return parentcategoryid;
	}

	public void setParentcategoryid(Long parentcategoryid) {
		this.parentcategoryid = parentcategoryid;
	}

	public int getIsactive() {
		return isactive;
	}

	public void setIsactive(int isactive) {
		this.isactive = isactive;
	}

	public Date getCreateddate() {
		return createddate;
	}

	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}
	
	

	@Override
	public String toString() {
		return "ETicaret_Categories [categoryid=" + categoryid + ", categoryname=" + categoryname + ", imgsrc=" + imgsrc
				+ ", parentcategoryid=" + parentcategoryid + ", isactive=" + isactive + ", createddate=" + createddate
				+ "]";
	}





}