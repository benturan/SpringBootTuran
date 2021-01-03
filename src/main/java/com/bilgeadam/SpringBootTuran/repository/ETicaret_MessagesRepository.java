package com.bilgeadam.SpringBootTuran.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bilgeadam.SpringBootTuran.entity.ETicaret_Messages;


public interface ETicaret_MessagesRepository extends JpaRepository<ETicaret_Messages,Long> {

	

	@Query(
			  value = "SELECT Id FROM eticaret_messages u WHERE u.UserEmail = ?1", 
			  nativeQuery = true)
       Long getUserid(String Id);
	
	@Query(
			  value = "SELECT UserName FROM eticaret_messages u WHERE u.UserEmail= ?1", 
			  nativeQuery = true)
	String getUserName(String name);
	
	@Query(
			  value = "SELECT IsRead FROM eticaret_messages u WHERE u.UserEmail= ?1", 
			  nativeQuery = true)
 String getIsRead(String email);
	
	@Query(
			  value = "SELECT UserMessage FROM eticaret_messages u WHERE u.UserEmail= ?1", 
			  nativeQuery = true)
String getUserMessage(String message);
	


}
