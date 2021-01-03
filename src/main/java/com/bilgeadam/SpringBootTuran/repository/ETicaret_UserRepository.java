package com.bilgeadam.SpringBootTuran.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bilgeadam.SpringBootTuran.entity.ETicaret_Users;

public interface ETicaret_UserRepository extends JpaRepository<ETicaret_Users, Long> {

	@Query(value = "SELECT UserId FROM eticaret_users u WHERE u.UserEmail = ?1", nativeQuery = true)
	Long getUserid(String email);

	@Query(value = "SELECT UserId FROM eticaret_users u WHERE u.twitter_username= ?1", nativeQuery = true)
	Long getUserid2(String twitterusername);

	@Query(value = "SELECT UserPassword FROM eticaret_users u WHERE u.UserEmail= ?1", nativeQuery = true)
	String getPassword(String email);

	@Query(value = "SELECT Role FROM eticaret_users u WHERE u.UserEmail= ?1", nativeQuery = true)
	String getRole(String email);
	
	
	@Query(value = "SELECT UserName FROM eticaret_users u WHERE u.UserEmail= ?1", nativeQuery = true)
	String getUserName(String email);

	@Query(value = "SELECT * FROM eticaret_users u WHERE u.UserEmail= ?1 and u.UserPassword=?2", nativeQuery = true)
	int mobileLogin(String email, String password);

	@Query(value = "SELECT UserPassword FROM eticaret_users u WHERE u.UserEmail= ?1", nativeQuery = true)
	String forgotPassword(String email);

	@Query(value = "SELECT * FROM eticaret_users u WHERE u.useremail = ?1", nativeQuery = true)
	ETicaret_Users findByUseremail(String useremail);

}
