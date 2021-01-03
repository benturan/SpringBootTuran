package com.bilgeadam.SpringBootTuran.controller;


 
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bilgeadam.SpringBootTuran.dto.ProductDTO;
import com.bilgeadam.SpringBootTuran.entity.ETicaret_Categories;
import com.bilgeadam.SpringBootTuran.entity.ETicaret_Products;
import com.bilgeadam.SpringBootTuran.entity.ETicaret_Products_Media;
import com.bilgeadam.SpringBootTuran.service.impl.ETicaret_CategoriesServiceImpl;
import com.bilgeadam.SpringBootTuran.service.impl.ETicaret_ProductsServiceImpl;
@Controller
public class FiltreleViewController {
	
	private final  ETicaret_CategoriesServiceImpl eTicaret_CategoriesServiceImpl;

	private final ETicaret_ProductsServiceImpl eTicaret_ProductsServiceImpl;
	
	public FiltreleViewController(ETicaret_CategoriesServiceImpl eTicaret_CategoriesServiceImpl
			,ETicaret_ProductsServiceImpl eTicaret_ProductsServiceImpl)
	{
		this.eTicaret_CategoriesServiceImpl =  eTicaret_CategoriesServiceImpl; 
		this.eTicaret_ProductsServiceImpl = eTicaret_ProductsServiceImpl;
	}

	@RequestMapping(value = "/allfiltreles", method = RequestMethod.GET)
	public ModelAndView getFiltreles() {
		List<ETicaret_Categories> anakategori = eTicaret_CategoriesServiceImpl.getParentCategory();
	 	List<ETicaret_Categories> altkategori = eTicaret_CategoriesServiceImpl.getCategory();
	 	List<ETicaret_Products> urunler = eTicaret_ProductsServiceImpl.getAll(); 
		ModelAndView model = new ModelAndView("filtrele");
		model.addObject("ana", anakategori);
    	model.addObject("alt", altkategori);
    	model.addObject("filtreurun",urunler);
		return model;

	}
	
	
	
	

}
