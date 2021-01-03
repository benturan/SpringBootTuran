package com.bilgeadam.SpringBootTuran.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bilgeadam.SpringBootTuran.dto.CartItemDTO;
import com.bilgeadam.SpringBootTuran.entity.ETicaret_Categories;
import com.bilgeadam.SpringBootTuran.entity.ETicaret_Messages;
import com.bilgeadam.SpringBootTuran.entity.ETicaret_Products;
import com.bilgeadam.SpringBootTuran.entity.ETicaret_Products_Order;
import com.bilgeadam.SpringBootTuran.entity.ETicaret_Products_Order_Detail;
import com.bilgeadam.SpringBootTuran.entity.ETicaret_Users;
import com.bilgeadam.SpringBootTuran.service.ETicaret_MessagesService;
import com.bilgeadam.SpringBootTuran.service.impl.ETicaret_CategoriesServiceImpl;
import com.bilgeadam.SpringBootTuran.service.impl.ETicaret_ProductsOrderDetailServiceImpl;
import com.bilgeadam.SpringBootTuran.service.impl.ETicaret_ProductsOrderServiceImpl;
import com.bilgeadam.SpringBootTuran.service.impl.ETicaret_ProductsServiceImpl;
import com.bilgeadam.SpringBootTuran.service.impl.ETicaret_UsersServiceImpl;

@Controller
public class MessagesViewController {
	@SuppressWarnings("unused")
	@Autowired
	private HttpSession httpSession;
	private final ETicaret_MessagesService eTicaret_MessagesServiceImpl;
	private final ETicaret_UsersServiceImpl eTicaret_UsersServiceImpl;
	private final ETicaret_ProductsOrderServiceImpl eTicaret_ProductsOrderServiceImpl;
	private final ETicaret_ProductsOrderDetailServiceImpl eTicaret_ProductsOrderDetailServiceImpl;
	private final ETicaret_ProductsServiceImpl eTicaret_ProductsServiceImpl;
	private final ETicaret_CategoriesServiceImpl eTicaret_CategoriesServiceImpl;
	
	public MessagesViewController(ETicaret_MessagesService eTicaret_MessagesServiceImpl,
			ETicaret_UsersServiceImpl eTicaret_UsersServiceImpl,
			ETicaret_ProductsOrderServiceImpl eTicaret_ProductsOrderServiceImpl,
			ETicaret_ProductsOrderDetailServiceImpl eTicaret_ProductsOrderDetailServiceImpl,
			ETicaret_ProductsServiceImpl eTicaret_ProductsServiceImpl,
			ETicaret_CategoriesServiceImpl eTicaret_CategoriesServiceImpl
			)
	{
		this.eTicaret_UsersServiceImpl = eTicaret_UsersServiceImpl;
		this.eTicaret_ProductsOrderServiceImpl = eTicaret_ProductsOrderServiceImpl;
		this.eTicaret_ProductsOrderDetailServiceImpl = eTicaret_ProductsOrderDetailServiceImpl;
		this.eTicaret_ProductsServiceImpl = eTicaret_ProductsServiceImpl;
		this.eTicaret_CategoriesServiceImpl = eTicaret_CategoriesServiceImpl;
		this.eTicaret_MessagesServiceImpl = eTicaret_MessagesServiceImpl;
	}
	

	@SuppressWarnings({ "unchecked", "unlikely-arg-type" })
	@RequestMapping(value = "/mesaj", method =  RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public ModelAndView  kaydet(String name, String usermessage,String email) throws ParseException {
		
		 
	     
		
		 SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
		 Date date = new Date();  
		 String date2=(formatter.format(date)); 
		 Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(date2); 
		
		ETicaret_Messages message  = new ETicaret_Messages();
    	message.setUsername(name);
    	message.setUseremail(email);
    	message.setUsermessage(usermessage);
    	message.setInsertdate(date1);
    	message.setIsread(0);
    	eTicaret_MessagesServiceImpl.save(message); 
		
    	return new ModelAndView("redirect:/allindex");
    	
	}
}
