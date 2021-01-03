package com.bilgeadam.SpringBootTuran.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bilgeadam.SpringBootTuran.dto.CartItemDTO;
import com.bilgeadam.SpringBootTuran.service.impl.ETicaret_CategoriesServiceImpl;
import com.bilgeadam.SpringBootTuran.service.impl.ETicaret_ProductsServiceImpl;



@Controller
public class CartDropdownViewController {
    private final ETicaret_ProductsServiceImpl eTicaret_ProductsServiceImpl;
	
	private final ETicaret_CategoriesServiceImpl eTicaret_CategoriesServiceImpl;
	
	Double totalAmount;
	Integer countItems;
	Double totalTax;
	Integer ItemTax;
	Double GeneralTotal;
	private int ara;
	@Autowired
	private HttpSession httpSession;
	

	public CartDropdownViewController(ETicaret_ProductsServiceImpl eTicaret_ProductsServiceImpl,ETicaret_CategoriesServiceImpl eTicaret_CategoriesServiceImpl) {
		super();
		this.eTicaret_ProductsServiceImpl = eTicaret_ProductsServiceImpl;
		this.eTicaret_CategoriesServiceImpl = eTicaret_CategoriesServiceImpl;
		// TODO Auto-generated constructor stub
	}

	@RequestMapping(value = "/allcart", method = RequestMethod.GET)
	public ModelAndView getCart(HttpSession session) {
		ModelAndView model = new ModelAndView("cartDropdown");
		setTotalAmount(0.0);
		session.setAttribute("totalAmount", totalAmount);
		setCountItems(0);
		session.setAttribute("countItems", countItems);
		List<CartItemDTO> cartItemList = (List<CartItemDTO>) session.getAttribute("cartItemList");
		model.addObject("cartItemList", cartItemList);
		return model;
	}

	// Sepete ekle dedğimiz zaman verileri post medoudu ile burya gönderiyoruz.
		@SuppressWarnings("unchecked")
		@RequestMapping(value = "/postCart", method = RequestMethod.POST)
		public String postCart(HttpSession session, HttpServletRequest request, HttpServletResponse response) {

			// Sepetimizdeki ürünleri temsil etmesi için liste oluşturuyoruz içine
			// CartItemDTO tipinde nesne olacak
			List<CartItemDTO> cartItemList = new ArrayList<>();

			if (request.getParameter("action").equals("addCart")) {
				CartItemDTO cartItem = new CartItemDTO();
				cartItem.setProductId(Integer.valueOf(request.getParameter("productID")));
				cartItem.setPrice(Double.valueOf(request.getParameter("productPrice")));
				cartItem.setProductName(request.getParameter("productName"));
				cartItem.setProductQuantity(Integer.valueOf(request.getParameter("productQuantity")));
				cartItem.setImage(request.getParameter("productImage"));
				cartItem.setTax(Integer.valueOf(request.getParameter("productTax")));
				cartItem.setLineTotalAmount(Double.valueOf(request.getParameter("productPrice"))
						* Integer.valueOf(request.getParameter("productQuantity")));

				if (session.getAttribute("cartItemList") == null) {

					cartItemList.add(cartItem);
					setTotalAmount(cartItem.getPrice() * cartItem.getProductQuantity());
					setCountItems(1);
					session.setAttribute("cartItemList", cartItemList);
					session.setAttribute("totalAmount", totalAmount);
					session.setAttribute("countItems", countItems);

				} else {
					// Belirtilen kayıt yoksa yeni ürün eklmek içi if koşuluna girmesi için
					boolean durum = false;

					// benzer urun varsa miktar arttirma yazilacak
					cartItemList = (List<CartItemDTO>) session.getAttribute("cartItemList");

					// Formdan gelen id göre bakılacak ürün varsa miktarı artırlacak yoksa yeni ürün
					// eklenecek
					int id = cartItem.getProductId();

					for (CartItemDTO data : cartItemList) {

						int ara = data.getProductId();

						if (ara == id) {

							int index = cartItemList.indexOf(data);

							int say = (data.getProductQuantity() + cartItem.getProductQuantity());
							cartItem.setProductQuantity(say);
							cartItemList.set(index, cartItem);

							durum = true;
							break;
						}
					}

					if (durum == false) {

						cartItemList.add(cartItem);
					}

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
				}
			} else if (request.getParameter("action").equals("deleteCart")) {
				
				

	/*			cat.jps glen id göre silme işlemi yopıyordu bunu ShoppingCartController'da
	 * 			deletecart medoduna yönledirdik son ürün içindegerleri sıfırlamıyordu.
	 * 
	 * 			cartItemList = (List<CartItemDTO>) session.getAttribute("cartItemList");

				int id = Integer.valueOf(request.getParameter("productID"));

				for (CartItemDTO data : cartItemList) {

					int ara = data.getProductId();

					if (ara == id) {

						int index = cartItemList.indexOf(data);

						cartItemList.remove(index);

						break;
					}

				}

			*/

			}

			return "redirect:/allindex";
		}

		private int indexof(int ara) {
			this.ara = ara;
			return ara;
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
