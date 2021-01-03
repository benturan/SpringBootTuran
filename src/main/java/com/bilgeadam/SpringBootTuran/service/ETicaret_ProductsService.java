package com.bilgeadam.SpringBootTuran.service;


import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.bilgeadam.SpringBootTuran.entity.ETicaret_Products;

public interface ETicaret_ProductsService {

    List<ETicaret_Products> getAll();

    ETicaret_Products getById(Long id);

    ETicaret_Products save(ETicaret_Products eTicaret_Products);
    
   
    ETicaret_Products update(ETicaret_Products eTicaret_Products);
    
    List<ETicaret_Products> encoksatan(int a);
    List<ETicaret_Products> encoksatanAll();
    
    List<ETicaret_Products> indirimdekiurunler(int a);
    List<ETicaret_Products> indirimdekiurunlerAll();
    
  
    List<ETicaret_Products> getFiltrele(double fiyat1,double fiyat2);
    
    List<ETicaret_Products> get50below();

    Boolean delete(Long id);
    
    List<ETicaret_Products> getClose4();
    
    List<ETicaret_Products> getAllPCategory(Long id);
    
    Long getProductID(String productname);
    
    List<ETicaret_Products> get12Products();
  
    List<ETicaret_Products> ürüngetir(Long id);
    
    List<Object[]> alldataProduct(Long id); 

    
    
}
