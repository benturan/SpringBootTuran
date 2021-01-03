package com.bilgeadam.SpringBootTuran.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bilgeadam.SpringBootTuran.entity.Turkiye_Adress;



public interface Turkiye_AdressRepository extends JpaRepository<Turkiye_Adress, Long> {

	// il
	@Query(value = "SELECT DISTINCT il FROM turkiye_adress_list ", nativeQuery = true)
	List<Object> AllCity();

	// ilce
	@Query(value = "SELECT DISTINCT ilce FROM turkiye_adress_list u WHERE u.il= ?1", nativeQuery = true)
	List<Object> getAllTown(String city);

	// Semt
	@Query(value = "SELECT DISTINCT semt_bucak_belde FROM turkiye_adress_list u WHERE u.ilce= ?1", nativeQuery = true)
	List<Object> getAllDistrict(String town);

	// Mahalle
	@Query(value = "SELECT DISTINCT mahalle FROM turkiye_adress_list u WHERE u.semt_bucak_belde = ?1", nativeQuery = true)
	List<Object> getAllNeighborhoods(String district);

	// Posta kodu
	@Query(value = "SELECT DISTINCT pk FROM turkiye_adress_list u WHERE u.semt_bucak_belde = ?1 and u.mahalle=?2 ", nativeQuery = true)
	Object getZipCode(String district, String neighborhoods);
	
	
	
	
	
	
}
