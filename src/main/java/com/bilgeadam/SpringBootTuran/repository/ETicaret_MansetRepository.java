package com.bilgeadam.SpringBootTuran.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bilgeadam.SpringBootTuran.entity.ETicaret_Manset;
import com.bilgeadam.SpringBootTuran.entity.ETicaret_Products;
 

public interface ETicaret_MansetRepository extends JpaRepository<ETicaret_Manset, Long> {
	@Query(value = "SELECT * FROM eticaret_products u WHERE u.Price between ?1 and ?2", nativeQuery = true)
	List<ETicaret_Products> getFiltrele(double fiyat1, double fiyat2);

	@Query(value = "SELECT * FROM eticaret_products u WHERE u.Price < 50", nativeQuery = true)
	List<ETicaret_Products> get50below();

	@Query(value = "select * from eticaret_products u order by  u.Dates desc limit 4 ", nativeQuery = true)
	List<ETicaret_Products> getClose4();

	@Query(value = "SELECT * FROM eticaret_products u WHERE u.CategoryId=?1", nativeQuery = true)
	List<ETicaret_Products> getAllPCategory(Long id);

	@Query(value = "SELECT * FROM eticaret_manset as em \r\n" + "where em.Id = ?1" + "", nativeQuery = true)
	List<Object[]> allMansetdataProduct(int mansetid);

	@Query(value = "SELECT * FROM eticaret_manset as em \r\n" + "where em.Id = ?1" + "", nativeQuery = true)
	ETicaret_Manset mansetById(int mansetid);
	
	@Query(value = "SELECT * FROM eticaret_manset em order by em.Sira desc ", nativeQuery = true)
	List<ETicaret_Manset> getAllMansetOrderBySira();
	
	
}
