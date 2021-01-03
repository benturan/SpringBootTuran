package com.bilgeadam.SpringBootTuran.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bilgeadam.SpringBootTuran.entity.ETicaret_Products_Favorite;


public interface ETicaretFavoritesRepository extends JpaRepository<ETicaret_Products_Favorite, Long> {

	@Query(value = "SELECT ep.* FROM eticaret_products_favorite AS ef join eticaret_products AS ep on ep.ProductId = ef.ProductID join eticaret_users AS eu on ef.UserId = eu.UserId  WHERE eu.UserId= ?1 and ef.Status=1", nativeQuery = true)
	List<Object[]> getFavorites(Long userid);
	
	@Query(value = "SELECT ep.* FROM eticaret_products_favorite AS ef join eticaret_products AS ep on ep.ProductId = ef.ProductID join eticaret_users AS eu  on ef.UserId = eu.UserId  WHERE eu.UserId= ?1 and ef.Status=1", nativeQuery = true)
	List<Object> getFavoritesByUserId(int UserId);
	
	

	
	@Query(value = "SELECT * FROM eticaret_products_favorite as em \r\n" + "where em.UserId = ?1 and em.ProductId=?2" + "", nativeQuery = true)
	List<Object> getFavoriteByProductIdAndUserId(int UserId,int ProductId);
	
	@Query(value = "delete FROM eticaret_products_favorite AS ef WHERE ef.UserId=?1 and ef.ProductId=?2", nativeQuery = true)
	void deleteFavoriteByProductIdAndUserId(int UserId, int ProductId);

}