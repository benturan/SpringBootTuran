package com.bilgeadam.SpringBootTuran.admin;

 


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.bilgeadam.SpringBootTuran.entity.ETicaret_Categories;
import com.bilgeadam.SpringBootTuran.entity.ETicaret_Products;
import com.bilgeadam.SpringBootTuran.entity.ETicaret_Users;
import com.bilgeadam.SpringBootTuran.service.impl.ETicaret_CategoriesServiceImpl;
import com.bilgeadam.SpringBootTuran.service.impl.ETicaret_ProductsServiceImpl;
import com.bilgeadam.SpringBootTuran.service.impl.ETicaret_UsersServiceImpl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class AdminUserViewController {
	private final ETicaret_ProductsServiceImpl eTicaret_ProductsServiceImpl;
	private final  ETicaret_CategoriesServiceImpl eTicaret_CategoriesServiceImpl;
	private final ETicaret_UsersServiceImpl eTicaret_UsersServiceImpl;

    //Constructor Dependency Injection
    public AdminUserViewController(ETicaret_CategoriesServiceImpl eTicaret_CategoriesServiceImpl,
    		ETicaret_ProductsServiceImpl eTicaret_ProductsServiceImpl,ETicaret_UsersServiceImpl eTicaret_UsersServiceImpl ) {
 	        this.eTicaret_ProductsServiceImpl = eTicaret_ProductsServiceImpl;
 	        this.eTicaret_CategoriesServiceImpl = eTicaret_CategoriesServiceImpl;
 	        this.eTicaret_UsersServiceImpl = eTicaret_UsersServiceImpl;
 	        
 	    }
   
    @RequestMapping(value =  {"/Admin/adminallusers","/Admin/adminallusers/{userid}"}, method = RequestMethod.GET)
    public ModelAndView getUsers(@PathVariable(value = "userid", required = false)Long UserId) {
    	 List<ETicaret_Products> adminproductlists = eTicaret_ProductsServiceImpl.getAll();
    	 List<ETicaret_Categories> admincategories = eTicaret_CategoriesServiceImpl.getParentCategory();
    	List<ETicaret_Categories> altkategori = eTicaret_CategoriesServiceImpl.getCategory();
    	
    	List<ETicaret_Users> adminuserlists = eTicaret_UsersServiceImpl.getAllUsers();
    	ETicaret_Users user = null;
    	
    	if(!(UserId == null))
    	{
    	
    	user = eTicaret_UsersServiceImpl.userProfile(UserId);
    	}
    	
        ModelAndView model = new ModelAndView("Admin/adminusers");
        
        model.addObject("adminuserlists", adminuserlists);
        model.addObject("user", user);
        model.addObject("adminproductlists", adminproductlists);
        model.addObject("parentcategory",admincategories);
        model.addObject("altkategori",altkategori);
        return model;

    }
    
    
    
    @SuppressWarnings("null")
	@RequestMapping(value = "/Admin/adminuserupdate/{userid}/{status}", method = RequestMethod.GET)
    public ModelAndView userUpdate(@PathVariable(value = "userid", required = false)Long UserId, 
    		@PathVariable(value = "status", required = false)Integer Status) {
    
    	
    	List<ETicaret_Users> adminuserlists = eTicaret_UsersServiceImpl.getAllUsers();
    	ETicaret_Users user = eTicaret_UsersServiceImpl.userProfile(UserId);
    	ModelAndView model = new ModelAndView("Admin/adminusers");
         
        model.addObject("adminuserlists", adminuserlists);
        model.addObject("user", user);
    	
    	
    	
    	if(!(UserId == null))
    	{
    	if(Status == 0)
    	{
    		user.setStatus(0);
    	}
    	if(Status == 1)
    	{
    		user.setStatus(1);
    	}
    	user = eTicaret_UsersServiceImpl.updateProfile(user);
    	}
    	
   
   

     //   return new ModelAndView("redirect:Admin/adminallusers/");
    	return new ModelAndView("redirect:/Admin/adminallusers");
    	 //return model;

    }
    
    @RequestMapping(value= "/Admin/adminallusers", method= RequestMethod.POST)
    public String addUser() {
    	

    	return "return:/adminallusers";
    	
    }
    
   

}