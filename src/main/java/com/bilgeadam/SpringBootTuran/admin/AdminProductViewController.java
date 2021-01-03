package com.bilgeadam.SpringBootTuran.admin;

 


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.bilgeadam.SpringBootTuran.entity.ETicaret_Categories;
import com.bilgeadam.SpringBootTuran.entity.ETicaret_Products;
import com.bilgeadam.SpringBootTuran.service.impl.ETicaret_CategoriesServiceImpl;
import com.bilgeadam.SpringBootTuran.service.impl.ETicaret_ProductsServiceImpl;

import java.util.Date;
import java.util.List;

@Controller
public class AdminProductViewController {
	private final ETicaret_ProductsServiceImpl eTicaret_ProductsServiceImpl;
	private final  ETicaret_CategoriesServiceImpl eTicaret_CategoriesServiceImpl;

    //Constructor Dependency Injection
    public AdminProductViewController(ETicaret_CategoriesServiceImpl eTicaret_CategoriesServiceImpl,ETicaret_ProductsServiceImpl eTicaret_ProductsServiceImpl) {
 	        this.eTicaret_ProductsServiceImpl = eTicaret_ProductsServiceImpl;
 	        this.eTicaret_CategoriesServiceImpl = eTicaret_CategoriesServiceImpl;
 	    }
   
    @RequestMapping(value = "/Admin/adminallproducts", method = RequestMethod.GET)
    public ModelAndView getdata() {
    	 List<ETicaret_Products> adminproductlists = eTicaret_ProductsServiceImpl.getAll();
    	 List<ETicaret_Categories> admincategories = eTicaret_CategoriesServiceImpl.getParentCategory();
    		List<ETicaret_Categories> altkategori = eTicaret_CategoriesServiceImpl.getCategory();
        ModelAndView model = new ModelAndView("Admin/adminproducts");
        model.addObject("adminproductlists", adminproductlists);
        model.addObject("parentcategory",admincategories);
        model.addObject("altkategori",altkategori);
        return model;

    }
    
}