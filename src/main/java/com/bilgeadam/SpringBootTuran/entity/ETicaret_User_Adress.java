package com.bilgeadam.SpringBootTuran.entity;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="eticaret_user_adress")
public class ETicaret_User_Adress implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Id")
	private Long id;
	
	@Column(name="UserId")
	private int	userId;

	@Column(name="Companyname")
	private String	companyname;
	
	@Column(name="UserAdresName")
	private String	useradresname;
	
	@Column(name="UserName")
	private String	username;
	
	@Column(name="UserSurName")
	private String	usersurname;	

	@Column(name="City")
	private String	city;
	
	@Column(name="Town")
	private String	town;	
	
	@Column(name="District")
	private String	district;	
	
	@Column(name="Neighborhoods")
	private String	neighborhoods;		

	@Column(name="Adress")
	private String	Adress;		
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public String getUseradresname() {
		return useradresname;
	}

	public void setUseradresname(String useradresname) {
		this.useradresname = useradresname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsersurname() {
		return usersurname;
	}

	public void setUsersurname(String usersurname) {
		this.usersurname = usersurname;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getNeighborhoods() {
		return neighborhoods;
	}

	public void setNeighborhoods(String neighborhoods) {
		this.neighborhoods = neighborhoods;
	}

	public String getAdress() {
		return Adress;
	}

	public void setAdress(String adress) {
		Adress = adress;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getOrdernote() {
		return ordernote;
	}

	public void setOrdernote(String ordernote) {
		this.ordernote = ordernote;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Column(name="Postcode")
	private String	postcode;
	
	@Column(name="Phone")
	private String	phone;
	
	@Column(name="OrderNote")
	private String	ordernote;
	
	@Column(name="Status")
	private int	status;

	

	

}
