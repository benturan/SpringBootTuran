package com.bilgeadam.SpringBootTuran.service;

import java.util.List;

import com.bilgeadam.SpringBootTuran.entity.ETicaret_Products_Order_Detail;



public interface ETicaret_ProductsOrderDetailService {

	List<ETicaret_Products_Order_Detail> getAll();

	ETicaret_Products_Order_Detail getById(Long id);

	void save(ETicaret_Products_Order_Detail eTicaret_Products_Order_Detail);

	ETicaret_Products_Order_Detail update(ETicaret_Products_Order_Detail eTicaret_Products_Order_Detail);
}
