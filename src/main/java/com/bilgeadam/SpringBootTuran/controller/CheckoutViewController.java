package com.bilgeadam.SpringBootTuran.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bilgeadam.SpringBootTuran.dto.CartItemDTO;
import com.bilgeadam.SpringBootTuran.entity.ETicaret_Categories;
import com.bilgeadam.SpringBootTuran.entity.ETicaret_User_Adress;
import com.bilgeadam.SpringBootTuran.service.impl.ETicaret_CategoriesServiceImpl;
import com.bilgeadam.SpringBootTuran.service.impl.ETicaret_ProductsServiceImpl;
import com.bilgeadam.SpringBootTuran.service.impl.ETicaret_User_AdressServiceImpl;

@Controller
public class CheckoutViewController {
	
	Double totalAmount;
	Integer countItems;
	Double totalTax;
	Integer ItemTax;
	Double GeneralTotal;
	
	@Autowired
	private HttpSession httpSession;

	
	@SuppressWarnings("unused")
	private final ETicaret_ProductsServiceImpl eTicaret_ProductsServiceImpl;
	
 
	 

	@SuppressWarnings("unused")
	private final ETicaret_CategoriesServiceImpl eTicaret_CategoriesServiceImpl;
	private final ETicaret_User_AdressServiceImpl eTicaret_User_AdressServiceImpl;

	public CheckoutViewController(ETicaret_ProductsServiceImpl eTicaret_ProductsServiceImpl,
			ETicaret_CategoriesServiceImpl eTicaret_CategoriesServiceImpl,
			ETicaret_User_AdressServiceImpl eTicaret_User_AdressServiceImpl) {
		this.eTicaret_ProductsServiceImpl = eTicaret_ProductsServiceImpl;
		this.eTicaret_CategoriesServiceImpl = eTicaret_CategoriesServiceImpl;
		this.eTicaret_User_AdressServiceImpl = eTicaret_User_AdressServiceImpl;

	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/checkoutAllCart", method = RequestMethod.POST)
	public ModelAndView getCart(HttpSession session) {
		if (session.getAttribute("UserId") != null) {
			Integer userId = Integer.valueOf(httpSession.getAttribute("UserId").toString());

			ModelAndView model = new ModelAndView("checkout");
			List<ETicaret_Categories> altkategori = eTicaret_CategoriesServiceImpl.getCategory();
			List<ETicaret_Categories> anakategori = eTicaret_CategoriesServiceImpl.getParentCategory();
			List<ETicaret_User_Adress> adress = eTicaret_User_AdressServiceImpl.getAllAdress(userId);
			model.addObject("ana", anakategori);
			model.addObject("alt", altkategori);
			model.addObject("adress", adress);

			// KATEGORİLER GÖZÜKMESİ İÇİN KODUN BİTTİĞİ YER.

			List<CartItemDTO> cartItemList = new ArrayList<>();
			cartItemList = (List<CartItemDTO>) session.getAttribute("cartItemList");
			Double tempAmount = 0.0;
			for (CartItemDTO item : cartItemList) {
				setTotalAmount(tempAmount + (item.getPrice() * item.getProductQuantity()));
				tempAmount = getTotalAmount();
				ItemTax = item.getTax();
			}
			totalTax = (totalAmount / 100) * ItemTax;
			GeneralTotal = totalTax + totalAmount;
			setCountItems(cartItemList.size());
			session.setAttribute("cartItemList", cartItemList);
			session.setAttribute("totalAmount", totalAmount);
			session.setAttribute("totalTax", totalTax);
			session.setAttribute("GeneralTotal", GeneralTotal);
			session.setAttribute("countItems", countItems);
			model.addObject("totalAmount", totalAmount);
			model.addObject("totalTax", totalTax);
			model.addObject("GeneralTotal", GeneralTotal);
			return model;

		}

		else {

			ModelAndView model = new ModelAndView("checkout");
			List<ETicaret_Categories> altkategori = eTicaret_CategoriesServiceImpl.getCategory();
			List<ETicaret_Categories> anakategori = eTicaret_CategoriesServiceImpl.getParentCategory();
			model.addObject("ana", anakategori);
			model.addObject("alt", altkategori);

			// KATEGORİLER GÖZÜKMESİ İÇİN KODUN BİTTİĞİ YER.

			List<CartItemDTO> cartItemList = new ArrayList<>();
			cartItemList = (List<CartItemDTO>) session.getAttribute("cartItemList");
			Double tempAmount = 0.0;
			for (CartItemDTO item : cartItemList) {
				setTotalAmount(tempAmount + (item.getPrice() * item.getProductQuantity()));
				tempAmount = getTotalAmount();
				ItemTax = item.getTax();
			}
			totalTax = (totalAmount / 100) * ItemTax;
			GeneralTotal = totalTax + totalAmount;
			setCountItems(cartItemList.size());
			session.setAttribute("cartItemList", cartItemList);
			session.setAttribute("totalAmount", totalAmount);
			session.setAttribute("totalTax", totalTax);
			session.setAttribute("GeneralTotal", GeneralTotal);
			session.setAttribute("countItems", countItems);
			model.addObject("totalAmount", totalAmount);
			model.addObject("totalTax", totalTax);
			model.addObject("GeneralTotal", GeneralTotal);
			return model;

		}
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/checkoutAllCart", method = RequestMethod.GET)
	public ModelAndView getCarts(HttpSession session) {

		if (session.getAttribute("UserId") != null) {
			Integer userId = Integer.valueOf(httpSession.getAttribute("UserId").toString());

			ModelAndView model = new ModelAndView("checkout");
			List<ETicaret_Categories> altkategori = eTicaret_CategoriesServiceImpl.getCategory();
			List<ETicaret_Categories> anakategori = eTicaret_CategoriesServiceImpl.getParentCategory();
			List<ETicaret_User_Adress> adress = eTicaret_User_AdressServiceImpl.getAllAdress(userId);
			model.addObject("ana", anakategori);
			model.addObject("alt", altkategori);
			model.addObject("adress", adress);

			// KATEGORİLER GÖZÜKMESİ İÇİN KODUN BİTTİĞİ YER.

			List<CartItemDTO> cartItemList = new ArrayList<>();
			cartItemList = (List<CartItemDTO>) session.getAttribute("cartItemList");
			Double tempAmount = 0.0;
			for (CartItemDTO item : cartItemList) {
				setTotalAmount(tempAmount + (item.getPrice() * item.getProductQuantity()));
				tempAmount = getTotalAmount();
				ItemTax = item.getTax();
			}
			totalTax = (totalAmount / 100) * ItemTax;
			GeneralTotal = totalTax + totalAmount;
			setCountItems(cartItemList.size());
			session.setAttribute("cartItemList", cartItemList);
			session.setAttribute("totalAmount", totalAmount);
			session.setAttribute("totalTax", totalTax);
			session.setAttribute("GeneralTotal", GeneralTotal);
			session.setAttribute("countItems", countItems);
			model.addObject("totalAmount", totalAmount);
			model.addObject("totalTax", totalTax);
			model.addObject("GeneralTotal", GeneralTotal);
			return model;

		} else {

			ModelAndView model = new ModelAndView("checkout");
			List<ETicaret_Categories> altkategori = eTicaret_CategoriesServiceImpl.getCategory();
			List<ETicaret_Categories> anakategori = eTicaret_CategoriesServiceImpl.getParentCategory();
			model.addObject("ana", anakategori);
			model.addObject("alt", altkategori);

			// KATEGORİLER GÖZÜKMESİ İÇİN KODUN BİTTİĞİ YER.

			List<CartItemDTO> cartItemList = new ArrayList<>();
			cartItemList = (List<CartItemDTO>) session.getAttribute("cartItemList");
			Double tempAmount = 0.0;
			for (CartItemDTO item : cartItemList) {
				setTotalAmount(tempAmount + (item.getPrice() * item.getProductQuantity()));
				tempAmount = getTotalAmount();
				ItemTax = item.getTax();
			}
			totalTax = (totalAmount / 100) * ItemTax;
			GeneralTotal = totalTax + totalAmount;
			setCountItems(cartItemList.size());
			session.setAttribute("cartItemList", cartItemList);
			session.setAttribute("totalAmount", totalAmount);
			session.setAttribute("totalTax", totalTax);
			session.setAttribute("GeneralTotal", GeneralTotal);
			session.setAttribute("countItems", countItems);
			model.addObject("totalAmount", totalAmount);
			model.addObject("totalTax", totalTax);
			model.addObject("GeneralTotal", GeneralTotal);
			return model;

		}
	}

	
	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Integer getCountItems() {
		return countItems;
	}

	public void setCountItems(Integer countItems) {
		this.countItems = countItems;
	}

	public Double getTotalTax() {
		return totalTax;
	}

	public void setTotalTax(Double totalTax) {
		this.totalTax = totalTax;
	}

	public Integer getItemTax() {
		return ItemTax;
	}

	public void setItemTax(Integer itemTax) {
		ItemTax = itemTax;
	}

	public Double getGeneralTotal() {
		return GeneralTotal;
	}

	public void setGeneralTotal(Double generalTotal) {
		GeneralTotal = generalTotal;
	}

}
