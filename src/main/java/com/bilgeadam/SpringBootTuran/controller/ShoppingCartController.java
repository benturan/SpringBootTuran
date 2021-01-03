package com.bilgeadam.SpringBootTuran.controller;
import java.util.ArrayList;
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
import com.bilgeadam.SpringBootTuran.service.impl.ETicaret_CategoriesServiceImpl;

@Controller
public class ShoppingCartController {
	
	Double totalAmount;
	Integer countItems;
	Double totalTax;
	Integer ItemTax;
	Double GeneralTotal;
	@Autowired
	private HttpSession httpSession;

	private final ETicaret_CategoriesServiceImpl eTicaret_CategoriesServiceImpl;

	
	public ShoppingCartController(ETicaret_CategoriesServiceImpl eTicaret_CategoriesServiceImpl) {

		this.eTicaret_CategoriesServiceImpl = eTicaret_CategoriesServiceImpl;

	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/getShoppingCart", method = RequestMethod.GET)
	public ModelAndView getShoppingCart(HttpSession session) {
		ModelAndView model = new ModelAndView("shoppingCart");
		// KATEGORİLER GÖZÜKMESİ İÇİN KODUN BAŞLADIĞI YER.
		List<ETicaret_Categories> altkategori = eTicaret_CategoriesServiceImpl.getCategory();
		List<ETicaret_Categories> anakategori = eTicaret_CategoriesServiceImpl.getParentCategory();
		model.addObject("ana", anakategori);
		model.addObject("alt", altkategori);
		// KATEGORİLER GÖZÜKMESİ İÇİN KODUN BİTTİĞİ YER.
		
	
		List<CartItemDTO> cartItemList = new ArrayList<>();
		if(session.getAttribute("cartItemList")!=null)
		{
		cartItemList = (List<CartItemDTO>) session.getAttribute("cartItemList");
		Double tempAmount = 0.0;
		for (CartItemDTO item : cartItemList) {
			setTotalAmount(tempAmount + (item.getPrice() * item.getProductQuantity()));
			tempAmount = getTotalAmount();
			ItemTax = item.getTax();
		}
		totalTax = (totalAmount / 100) * ItemTax; 
		GeneralTotal = totalTax +totalAmount;
		setCountItems(cartItemList.size());
		session.setAttribute("cartItemList", cartItemList);
		session.setAttribute("totalAmount", totalAmount);
		session.setAttribute("totalTax", totalTax);
		session.setAttribute("GeneralTotal", GeneralTotal);
		session.setAttribute("countItems", countItems);
		}
		model.addObject("totalAmount", totalAmount);
		model.addObject("totalTax", totalTax);
		model.addObject("GeneralTotal", GeneralTotal);
		return model;

	}
	

	@SuppressWarnings({ "unchecked", "unlikely-arg-type" })
	@RequestMapping(value = "/updateCartIncrease", method = RequestMethod.POST)
	@ResponseBody
	public void updateCartIncrease(String product_id, String quantity, String price, String productName,
			String productImage, String productTax) {
    
		List<CartItemDTO> cartItemList = new ArrayList<>();

		int ProductId = Integer.valueOf(product_id);
		int productQuantity = Integer.valueOf(quantity);
		int pTax = Integer.valueOf(productTax);
		double productPrice = Double.valueOf(price);
		CartItemDTO cartItem = new CartItemDTO();
		cartItem.setProductId(ProductId);
		cartItem.setPrice(productPrice);
		cartItem.setProductName(productName);
		cartItem.setProductQuantity(productQuantity);
		cartItem.setImage(productImage);
		cartItem.setTax(pTax);

		Double tempAmount = 0.0;
		cartItemList = (List<CartItemDTO>) httpSession.getAttribute("cartItemList");

		for (CartItemDTO data : cartItemList) {

			int ara = data.getProductId();

			if (ara == ProductId) {

				int index = cartItemList.indexOf(data);
				int say = (data.getProductQuantity() + productQuantity);
				
				
				// "deleteCartIncrease" formunda bu metodu cagırararak işlem yapıyoruz
				 // gelen veriye göre ürün degerlerini sıfırlıyoruz
				// Son deger kaldığıda sepetteki degerler Genel toplam Septe alt toplamı kdv gibi..
				
				if(productQuantity==0) {
					
					say = 0;
				
					cartItem.setProductQuantity(say);
					cartItem.setLineTotalAmount(say);
					cartItemList.set(index, cartItem);				
					
				}
				
				

				else if (say < 0) {

					say = 0;

					cartItem.setProductQuantity(say);
					cartItem.setLineTotalAmount(productPrice * say);
					cartItemList.set(index, cartItem);

				}

				else {

					cartItem.setProductQuantity(say);
					cartItem.setLineTotalAmount(productPrice * say);
					cartItemList.set(index, cartItem);

				}

				break;

			}
		}

		for (CartItemDTO item : cartItemList) {
			setTotalAmount(tempAmount + (item.getPrice() * item.getProductQuantity()));
			tempAmount = getTotalAmount();
			ItemTax = item.getTax();
		}
		totalTax = (totalAmount / 100) * ItemTax;
		GeneralTotal = totalTax + totalAmount;
		setCountItems(cartItemList.size());
		httpSession.setAttribute("cartItemList", cartItemList);
		httpSession.setAttribute("totalAmount", totalAmount);
		httpSession.setAttribute("totalTax", totalTax);
		httpSession.setAttribute("GeneralTotal", GeneralTotal);
		httpSession.setAttribute("countItems", countItems);

	}

//************************************************************************************
	@RequestMapping(value = "/deleteCart", method = RequestMethod.POST)
	@ResponseBody
	public void deleteCartIncrease(String product_id) {
	  
		   String quantity = "0";
		   String price ="0";
		   String productName = "";
		   String productImage ="";
		   String productTax = "0";
		
		 // gelen veriye göre ürün degerlerini sıfırlıyoruz
		// Son deger kaldığıda sepetteki degerler Genel toplam Septe alt toplamı kdv gibi. görünüyor 
		// Bu şekilde cözmeye çalıştım
		//Yukarıdaki  updateCartIncrease medodu çağırdım
		updateCartIncrease(product_id, quantity, price, productName, productImage, productTax);

		List<CartItemDTO> cartItemList = new ArrayList<>();

		int id = Integer.valueOf(product_id);
		CartItemDTO cartItem = new CartItemDTO();

		Double tempAmount = 0.0;
		cartItemList = (List<CartItemDTO>) httpSession.getAttribute("cartItemList");
			

			for (CartItemDTO data : cartItemList) {

				int ara = data.getProductId();

				if (ara == id) {

					int index = cartItemList.indexOf(data);

					cartItemList.remove(index);

					break;	}

			}
		
	

	}



//************************************************************************************	



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
