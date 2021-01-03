package com.bilgeadam.SpringBootTuran.dto;

import java.util.List;

public class MainCategoriesDTO {
	

	private int  cat_id;
	private String category_name;
	private String category_image;
	private List<MainCategories_ProductsDTO> products;
	
	public int getCat_id() {
		return cat_id;
	}
	public void setCat_id(int cat_id) {
		this.cat_id = cat_id;
	}
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	public String getCategory_image() {
		return category_image;
	}
	public void setCategory_image(String category_image) {
		this.category_image = category_image;
	}
	public List<MainCategories_ProductsDTO> getProducts() {
		return products;
	}
	public void setProducts(List<MainCategories_ProductsDTO> products) {
		this.products = products;
	}

}
