package com.bilgeadam.SpringBootTuran.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bilgeadam.SpringBootTuran.entity.ETicaret_Categories;
import com.bilgeadam.SpringBootTuran.service.impl.ETicaret_CategoriesServiceImpl;
@Controller
public class BizeUlasinViewController {
	
	
private final  ETicaret_CategoriesServiceImpl eTicaret_CategoriesServiceImpl;
	
	public BizeUlasinViewController(ETicaret_CategoriesServiceImpl eTicaret_CategoriesServiceImpl)
	{
		this.eTicaret_CategoriesServiceImpl =  eTicaret_CategoriesServiceImpl; 
	}
	@RequestMapping(value = "/allbizeulasin", method = RequestMethod.GET)
	public ModelAndView getBizeUlasin() {
		List<ETicaret_Categories> anakategori = eTicaret_CategoriesServiceImpl.getParentCategory();
	 	List<ETicaret_Categories> altkategori = eTicaret_CategoriesServiceImpl.getCategory();
		ModelAndView model = new ModelAndView("bizeulasin");
		model.addObject("ana", anakategori);
    	model.addObject("alt", altkategori);
		return model;

	}
	

}
