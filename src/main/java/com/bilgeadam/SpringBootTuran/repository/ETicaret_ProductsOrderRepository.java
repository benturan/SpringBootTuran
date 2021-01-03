package com.bilgeadam.SpringBootTuran.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bilgeadam.SpringBootTuran.entity.ETicaret_Products_Order;



public interface ETicaret_ProductsOrderRepository extends JpaRepository<ETicaret_Products_Order, Long> {

	@Query(value = "select eto.* from eticaret_products_order as eto  where eto.UserId=?1", nativeQuery = true)
	List<ETicaret_Products_Order> getMyOrders(int UserId);
	
	@Query(value = "select eto.*,eu.UserName,UserSurName from eticaret_products_order as eto inner join eticaret_users as eu on eu.UserId = eto.UserId", nativeQuery = true)
	List<Object> getAllOrders();
}
