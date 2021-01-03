package com.bilgeadam.SpringBootTuran.service;

import java.util.List;

import com.bilgeadam.SpringBootTuran.entity.ETicaret_Products_Details;

 


public interface ETicaret_ProductsDetailsService {
	
	public List<Object[]> getDetail(Long id);

	ETicaret_Products_Details save(ETicaret_Products_Details eTicaret_Products_Details);
	
	 ETicaret_Products_Details getById(Long id);
	 
	 Long idyakalaproductidile(Long pid);
	 
	 void updateproductdetail(String detail,Long pid);

}
