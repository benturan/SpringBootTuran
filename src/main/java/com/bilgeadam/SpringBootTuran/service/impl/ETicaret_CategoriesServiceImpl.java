package com.bilgeadam.SpringBootTuran.service.impl;

import com.bilgeadam.SpringBootTuran.entity.ETicaret_Categories;
import com.bilgeadam.SpringBootTuran.repository.ETicaret_CategoriesRepository;
import com.bilgeadam.SpringBootTuran.service.ETicaret_CategoriesService;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ETicaret_CategoriesServiceImpl implements ETicaret_CategoriesService {

	private final ETicaret_CategoriesRepository eTicaret_CategoriesRepository;

	public ETicaret_CategoriesServiceImpl(ETicaret_CategoriesRepository eTicaret_CategoriesRepository) {
		this.eTicaret_CategoriesRepository = eTicaret_CategoriesRepository;

	}

	public List<ETicaret_Categories> getParentCategory() {
		List<ETicaret_Categories> data = eTicaret_CategoriesRepository.getParentCategory();
		return data;
	}

	public List<ETicaret_Categories> getCategory() {
		List<ETicaret_Categories> data = eTicaret_CategoriesRepository.getCategory();
		return data;
	}

	public List<ETicaret_Categories> getCategory(long id) {
		List<ETicaret_Categories> data = eTicaret_CategoriesRepository.getCategory(id);
		return data;
	}

	public List<ETicaret_Categories> getParentIdAllCategories(long parentId) {
		List<ETicaret_Categories> data = eTicaret_CategoriesRepository.getParentIdAllCategories(parentId);
		return data;
	}

	@Override
	public ETicaret_Categories getById(Long id) {
		ETicaret_Categories p = eTicaret_CategoriesRepository.getOne(id);
		return p;
	}

	@Override
	public Long getCategoryid(String categoryname) {
		Long id = eTicaret_CategoriesRepository.getCategoryid(categoryname);
		return id;
	}

	public int findParentIdByCategoryId(long CategoryId) {
		int ParentID = eTicaret_CategoriesRepository.findParentIdByCategoryId(CategoryId);
		return ParentID;
	}

	public List<Object> getMainCategories_Products_Medias(int productId) {
		List<Object> list = eTicaret_CategoriesRepository.getMainCategories_Products_Medias(productId);
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Object> getCategories_ProductsByCategoryId(int CategoryId) {
		List<Object> list = eTicaret_CategoriesRepository.getMainCategories_ProductsByCategoryId(CategoryId);
		return list;
	}

	// En alt Kategorinin Parent Id sine göre Alt Kategorinin Parent Id sini bulur
	public int subCategorysFindParentIdByParentId(long EnAltKategoriParentId) {
		int ParentID = eTicaret_CategoriesRepository.subCategorysFindParentIdByParentId(EnAltKategoriParentId);
		return ParentID;
	}
	
	@SuppressWarnings("unchecked")
	public List<Object> getProductsDetailByProductId(int ProductId) {
		List<Object> list = eTicaret_CategoriesRepository.getProductsDetailByProductId(ProductId);
		return list;
	}
	

}