package com.bilgeadam.SpringBootTuran.service;

import java.util.List;

import com.bilgeadam.SpringBootTuran.entity.ETicaret_Manset;
 
public interface ETicaret_MansetService {
	
    List<ETicaret_Manset> getAll();

    ETicaret_Manset getById(Long id);

    ETicaret_Manset save(ETicaret_Manset eTicaret_Manset);

    ETicaret_Manset update(ETicaret_Manset eTicaret_Manset);
    
    List<Object[]> allMansetdataProduct(int id); 
    
    ETicaret_Manset mansetById(int id);
    
    Boolean delete(Long id);


}
