package com.bilgeadam.SpringBootTuran.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bilgeadam.SpringBootTuran.entity.ETicaret_Products_Order_Detail;


public interface ETicaret_ProductsOrderDetailRepository  extends JpaRepository<ETicaret_Products_Order_Detail, Long> {
	
	@Query(value = "select etod.* from eticaret_products_order_detail as etod  where etod.OrderId=?1", nativeQuery = true)
	List<ETicaret_Products_Order_Detail> getOrderDetailsByOrderId(int OrderId);

}
