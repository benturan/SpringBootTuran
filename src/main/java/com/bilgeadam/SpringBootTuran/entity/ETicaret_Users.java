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
@Table(name = "eticaret_users")
public class ETicaret_Users implements Serializable {
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "UserId")
	private Long userid;
	
	@Column(name = "UserName")
	private String username;
	
	@Column(name = "UserSurName")
	private String usersurname;
	
	@Column(name = "UserEmail")
	private String useremail;
	
	@Column(name = "Telephone")
	private String telephone;
	
	//@Column(name = "twitter_username")
	//private String twitterusername;
	
	
	@Column(name = "UserPassword")
	private String userpassword;
	
	@Column(name = "Gender")
	private String gender;
	
	@Column(name = "Role")
	private String role;
	
	@Column(name = "Status")
	private int status;

	public Long getUserid() {
		return userid;
	}

	public void setUserid(Long userid) {
		this.userid = userid;
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

	public String getUseremail() {
		return useremail;
	}

	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}


	public String getUserpassword() {
		return userpassword;
	}

	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	//public String getTwitterusername() {
		//return twitterusername;
	//}

	//public void setTwitterusername(String twitterusername) {
	//	this.twitterusername = twitterusername;
	//}
	
	
	
	
	
	
	

}
