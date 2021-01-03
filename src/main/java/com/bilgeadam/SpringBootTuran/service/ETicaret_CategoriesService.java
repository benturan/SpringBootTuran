package com.bilgeadam.SpringBootTuran.service;
import java.util.List;

import com.bilgeadam.SpringBootTuran.entity.ETicaret_Categories;

public interface ETicaret_CategoriesService {

	List<ETicaret_Categories> getParentCategory();
	
	List<ETicaret_Categories> getCategory();
	
	ETicaret_Categories getById(Long id);
	
	Long getCategoryid(String categoryname);
	
}
