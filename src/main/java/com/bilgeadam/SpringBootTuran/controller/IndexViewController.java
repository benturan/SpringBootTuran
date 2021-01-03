package com.bilgeadam.SpringBootTuran.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bilgeadam.SpringBootTuran.entity.ETicaret_Categories;
import com.bilgeadam.SpringBootTuran.entity.ETicaret_Manset;
import com.bilgeadam.SpringBootTuran.entity.ETicaret_Products;
import com.bilgeadam.SpringBootTuran.entity.ETicaret_Users;
import com.bilgeadam.SpringBootTuran.service.impl.ETicaret_CategoriesServiceImpl;
import com.bilgeadam.SpringBootTuran.service.impl.ETicaret_MansetsServiceImpl;
import com.bilgeadam.SpringBootTuran.service.impl.ETicaret_ProductsServiceImpl;
import com.bilgeadam.SpringBootTuran.service.impl.ETicaret_UsersServiceImpl;

@Controller
public class IndexViewController {

	@Autowired
	private HttpSession httpSession;
	@SuppressWarnings("unused")
	private final ETicaret_ProductsServiceImpl eTicaret_ProductsServiceImpl;
	private final ETicaret_CategoriesServiceImpl eTicaret_CategoriesServiceImpl;
	private final ETicaret_UsersServiceImpl eTicaret_UsersServiceImpl;
	private final ETicaret_MansetsServiceImpl eTicaret_MansetsServiceImpl;

	public IndexViewController(ETicaret_ProductsServiceImpl eTicaret_ProductsServiceImpl,
			ETicaret_CategoriesServiceImpl eTicaret_CategoriesServiceImpl,
			ETicaret_UsersServiceImpl eTicaret_UsersServiceImpl,
			ETicaret_MansetsServiceImpl eTicaret_MansetsServiceImpl) {
		this.eTicaret_ProductsServiceImpl = eTicaret_ProductsServiceImpl;
		this.eTicaret_CategoriesServiceImpl = eTicaret_CategoriesServiceImpl;
		this.eTicaret_UsersServiceImpl = eTicaret_UsersServiceImpl;
		this.eTicaret_MansetsServiceImpl = eTicaret_MansetsServiceImpl;
	}

	@RequestMapping(value = "/allindex", method = RequestMethod.GET, headers = "Accept=application/json")
	public ModelAndView getsayfa() {
		ModelAndView model = new ModelAndView("index");
		//dataAllProducts();

		List<ETicaret_Categories> anakategori = eTicaret_CategoriesServiceImpl.getParentCategory();
		List<ETicaret_Categories> altkategori = eTicaret_CategoriesServiceImpl.getCategory();
		//List<ETicaret_Products> urunler = eTicaret_ProductsServiceImpl.getAll();
		List<ETicaret_Manset> mansetList = eTicaret_MansetsServiceImpl.getAllOrderBySira();
		 model.addObject("ana", anakategori);
		 model.addObject("alt", altkategori);
		//model.addObject("urunler", urunler);
		 List<ETicaret_Products> encoksatan = eTicaret_ProductsServiceImpl.encoksatan(8);

		// İndirimdeki 4 ürünü getirir
		 List<ETicaret_Products> indirimdekiurunler = eTicaret_ProductsServiceImpl.indirimdekiurunler(4);

		 model.addObject("mansetList", mansetList);
		 model.addObject("encoksatan",encoksatan);
		 model.addObject("indirimUrun",indirimdekiurunler);
		return model;

	}

	@RequestMapping(value = "/allindex", method = RequestMethod.POST)
	public String logincontrol(String email, String password, HttpServletRequest request) {
		String realpwd = "";
		String role = "";
		String userName="";
		long userId = 0;
		try {

			userId = eTicaret_UsersServiceImpl.getUserid(email);
			realpwd = eTicaret_UsersServiceImpl.getPassword(email);
			role = eTicaret_UsersServiceImpl.getRole(email);
			 ETicaret_Users user = eTicaret_UsersServiceImpl.userProfile(userId);
			
			userName = eTicaret_UsersServiceImpl.getUserName(email);
			 httpSession.setAttribute("realpwd", user.getUserpassword());
			 httpSession.setAttribute("UserId", user.getUserid().toString());
			 httpSession.setAttribute("UserName", user.getUsername());
			
			// httpSession.setAttribute("realpwd", realpwd);
			// httpSession.setAttribute("UserId", userId);
			// httpSession.setAttribute("UserName", userName);

		} catch (Exception ex) {
			// emaile ait kullanıcı yok
			ex.getMessage();
		}

		if (realpwd.equals(password)) {

			if (role.equals("Admin")) {
				return "redirect:/Admin/adminallindex";
			} else {
				return "redirect:/allindex";
			}
		} else {
			return "redirect:/pwdyanlis";
			// kullanıcıya ait şifre yanlış
		}

	}
	
	 @RequestMapping(value = "/getAllProducts/", method = RequestMethod.GET, headers = "Accept=application/json")
	 @ResponseBody
	 public List<ETicaret_Products> dataAllProducts() {
		  List<ETicaret_Products> list=  eTicaret_ProductsServiceImpl.getAll();
		  return list;

	 }
	 
	 
	 @RequestMapping(value = "/getMainCategories/", method = RequestMethod.GET, headers = "Accept=application/json")
	 @ResponseBody
	 public List<ETicaret_Categories> getMainCategories() {
			List<ETicaret_Categories> anakategori = eTicaret_CategoriesServiceImpl.getParentCategory();
		  return anakategori;

	 }
	 
	 @RequestMapping(value = "/getMainSubCategories/", method = RequestMethod.GET, headers = "Accept=application/json")
	 @ResponseBody
	 public List<ETicaret_Categories> getMainSubCategories() {
			List<ETicaret_Categories> altkategori = eTicaret_CategoriesServiceImpl.getCategory();
		  return altkategori;

	 }
	 
	 @SuppressWarnings("unchecked")
		@RequestMapping(value = "/getAllMansets/", method = RequestMethod.GET, headers = "Accept=application/json")
		@ResponseBody
		public  List<ETicaret_Manset> getAllMansetList() {
			 	List<ETicaret_Manset>  mansetlists = (List<ETicaret_Manset>) eTicaret_MansetsServiceImpl.getAll();
			 	return mansetlists;

		}
	
	
	

}
