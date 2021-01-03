package com.bilgeadam.SpringBootTuran.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bilgeadam.SpringBootTuran.entity.ETicaret_Products_Details;

 

public interface ETicaret_ProductsDetailsRepository extends JpaRepository<ETicaret_Products_Details,Long> {
	
	@Query(
		     value = "SELECT ep.ProductID,ep.Name,ep.Price,epd.Detail,ep.Image FROM eticaret_products_detail as epd join eticaret_products ep on epd.ProductID = ep.ProductID where epd.ProductID = ?1",
		     nativeQuery = true)
		 List<Object[]> getDetail(Long id);
		 
		 @Query(
			     value = "SELECT Id FROM eticaret_products_detail u  where u.ProductID = ?1",
			     nativeQuery = true)
			 Long idyakalaproductidile(Long pid);
		 
		 @Query(
				 value = "UPDATE eticaret_products_detail u  SET u.Detail= ?1 where u.Id = ?2",
				 nativeQuery=true)
		 void updateproductdetail(String detail,Long pid);
		 
		 
		

}


