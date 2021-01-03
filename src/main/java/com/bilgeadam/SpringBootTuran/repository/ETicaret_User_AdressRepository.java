package com.bilgeadam.SpringBootTuran.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bilgeadam.SpringBootTuran.entity.ETicaret_User_Adress;

 



public interface ETicaret_User_AdressRepository  extends JpaRepository<ETicaret_User_Adress, Long>{

	
	
@Query(value = "SELECT * FROM eticaret_user_adress u WHERE u.UserId = ?1 and u.Status=1", nativeQuery = true)
List<ETicaret_User_Adress> getAllAdress(int usurId );


@Query(value = " SELECT * FROM eticaret_user_adress u WHERE u.userId = ?1 and u.Id=?2 ", nativeQuery = true)
ETicaret_User_Adress adresDelete(int userId,int adresId);


@Query(value = "select * from eticaret_user_adress u where u.Status=0 LIMIT 0,1", nativeQuery = true)
ETicaret_User_Adress controlSave();

/*
@Query(value = "select * from eticaret_user_adress u where u.UserId=?1 and u.Status=0 LIMIT 0,1", nativeQuery = true)
ETicaret_User_Adress controlSave(int userId);

*/



}



