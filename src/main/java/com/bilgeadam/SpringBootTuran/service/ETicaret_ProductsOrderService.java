package com.bilgeadam.SpringBootTuran.service;

import java.util.List;

import com.bilgeadam.SpringBootTuran.entity.ETicaret_Products_Order;



public interface ETicaret_ProductsOrderService {

	List<ETicaret_Products_Order> getAll();

	ETicaret_Products_Order getById(Long id);

	ETicaret_Products_Order save(ETicaret_Products_Order eTicaret_Products_Order);

	ETicaret_Products_Order update(ETicaret_Products_Order eTicaret_Products_Order);

}
