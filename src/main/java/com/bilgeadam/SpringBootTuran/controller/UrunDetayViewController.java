package com.bilgeadam.SpringBootTuran.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bilgeadam.SpringBootTuran.dto.CartItemDTO;
import com.bilgeadam.SpringBootTuran.dto.ProductDTO;
import com.bilgeadam.SpringBootTuran.entity.ETicaret_Categories;
import com.bilgeadam.SpringBootTuran.entity.ETicaret_Products;
import com.bilgeadam.SpringBootTuran.entity.ETicaret_Products_Media;
import com.bilgeadam.SpringBootTuran.service.impl.ETicaret_CategoriesServiceImpl;
import com.bilgeadam.SpringBootTuran.service.impl.ETicaret_ProductsServiceImpl;

@Controller
public class UrunDetayViewController {

	
	Double totalAmount;
	Integer countItems;
	Double totalTax;
	Integer ItemTax;
	Double GeneralTotal;
	@SuppressWarnings("unused")
	private final ETicaret_ProductsServiceImpl eTicaret_ProductsServiceImpl;
	private final  ETicaret_CategoriesServiceImpl eTicaret_CategoriesServiceImpl;
//Contructor Injection 
	public UrunDetayViewController(ETicaret_ProductsServiceImpl eTicaret_ProductsServiceImpl,
			ETicaret_CategoriesServiceImpl eTicaret_CategoriesServiceImpl) {
		this.eTicaret_ProductsServiceImpl = eTicaret_ProductsServiceImpl;
		this.eTicaret_CategoriesServiceImpl = eTicaret_CategoriesServiceImpl;

	}



	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/getProductDetail{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	@ResponseBody
	public ModelAndView getProductsDetailByProductId(@PathVariable("id") Long id) {

		List<ETicaret_Categories> anakategori = eTicaret_CategoriesServiceImpl.getParentCategory();
	 	List<ETicaret_Categories> altkategori = eTicaret_CategoriesServiceImpl.getCategory();
		ModelAndView model = new ModelAndView("detay");
		model.addObject("ana", anakategori);
    	model.addObject("alt", altkategori);
		
		int productId =  Math.toIntExact(id);
		
		List<Object> list = eTicaret_ProductsServiceImpl.getProductsDetailByProductId(productId);
		List<Object> mediaList = null;
		//List<Object> liste =  eTicaret_ProductsServiceImpl.getProductsDetailByProductId(productId);

		//model.addObject("detail", liste);
	
		Iterator itr = list.iterator();
		ProductDTO newProductsDTO = new ProductDTO();
		while (itr.hasNext()) {
			Object[] obj = (Object[]) itr.next();
			newProductsDTO.setProductID(Integer.valueOf((obj[0].toString())));
			newProductsDTO.setCategoryid(Integer.valueOf((obj[1].toString())));
			newProductsDTO.setName(obj[3].toString());
			newProductsDTO.setDescription(obj[4].toString());
			newProductsDTO.setCategoryname(obj[19].toString());
			newProductsDTO.setOldPrice(Double.valueOf((String) (obj[5].toString())));
			newProductsDTO.setPrice(Double.valueOf((String) (obj[6].toString())));
			newProductsDTO.setImage(obj[7].toString());
			newProductsDTO.setImgSrc(obj[19].toString());
			newProductsDTO.setTax(Integer.valueOf(obj[17].toString()));
			
			mediaList = eTicaret_ProductsServiceImpl
					.getProducts_Medias(Integer.valueOf((obj[0].toString())));
			List<ETicaret_Products_Media> newMediaList = new ArrayList<ETicaret_Products_Media>();
			List<Object> resultMedia = (List<Object>) mediaList;
			Iterator itrMedia = resultMedia.iterator();
			while (itrMedia.hasNext()) {
				// newMediaList.clear();
				ETicaret_Products_Media newETicaret_Products_Media = new ETicaret_Products_Media();
				Object[] objMedia = (Object[]) itrMedia.next();

				newETicaret_Products_Media.setId(Integer.valueOf((objMedia[0].toString())));
				newETicaret_Products_Media.setMedia_type_id(Integer.valueOf((objMedia[1].toString())));
				newETicaret_Products_Media.setProductId(Integer.valueOf((objMedia[2].toString())));
				newETicaret_Products_Media.setMedia_name(objMedia[3].toString());
				newETicaret_Products_Media.setMedia_url(objMedia[4].toString());
				newMediaList.add(newETicaret_Products_Media);

			}

			newProductsDTO.setProductMedias(newMediaList);

		}

		
		model.addObject("productDetail", newProductsDTO);
		model.addObject("mediaList", mediaList);
		return model;

	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/postCartDetay{id}", method = RequestMethod.POST)
	public ModelAndView postCartDetay(@PathVariable("id") Long id, HttpServletRequest request, HttpSession session) {
		ModelAndView model = new ModelAndView("detay");
		if (request.getParameter("action").equals("addCartDetay")) {

			List<CartItemDTO> cartItemList = new ArrayList<>();

			CartItemDTO cartItem = new CartItemDTO();
			cartItem.setProductId(Integer.valueOf(request.getParameter("productID")));
			cartItem.setPrice(Double.valueOf(request.getParameter("productPrice")));
			cartItem.setProductName(request.getParameter("productName"));
			cartItem.setProductQuantity(Integer.valueOf(request.getParameter("productQuantity")));
			cartItem.setImage(request.getParameter("productImage"));
			cartItem.setLineTotalAmount(Double.valueOf(request.getParameter("productPrice"))
					* Integer.valueOf(request.getParameter("productQuantity")));
			cartItem.setTax(Integer.valueOf(request.getParameter("productTax")));

			if (session.getAttribute("cartItemList") == null) {

				cartItemList.add(cartItem);
				setTotalAmount(cartItem.getPrice() * cartItem.getProductQuantity());
				setCountItems(1);
				session.setAttribute("cartItemList", cartItemList);
				session.setAttribute("totalAmount", totalAmount);
				session.setAttribute("countItems", countItems);
			} else {
				// benzer urun varsa miktar arttirma yazilacak
				cartItemList = (List<CartItemDTO>) session.getAttribute("cartItemList");

				// bakılacak id
				int bak = cartItem.getProductId();

				// Belirtilen kayıt yoksa if girmesi için varsa içerideki sayıyı degiştirip
				// çıkış yapacak
				boolean durum = false;

				for (CartItemDTO data : cartItemList) {

					int ara = data.getProductId();

					if (ara == bak) {

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
		} else if (request.getParameter("action").equals("deleteCartDetay")) {
			System.out.println("deleteCartDetay");
		}
		
		
		
	    int productId =  Math.toIntExact(id);
		
		List<Object> liste = eTicaret_ProductsServiceImpl.getProductsDetailByProductId(productId);
	
		List<Object> mediaList = null;
	
		Iterator itr = liste.iterator();
		ProductDTO newProductsDTO = new ProductDTO();
		while (itr.hasNext()) {
			Object[] obj = (Object[]) itr.next();
			newProductsDTO.setProductID(Integer.valueOf((obj[0].toString())));
			newProductsDTO.setCategoryid(Integer.valueOf((obj[1].toString())));
			newProductsDTO.setName(obj[3].toString());
			newProductsDTO.setDescription(obj[4].toString());
			newProductsDTO.setCategoryname(obj[19].toString());
			newProductsDTO.setOldPrice(Double.valueOf((String) (obj[5].toString())));
			newProductsDTO.setPrice(Double.valueOf((String) (obj[6].toString())));
			newProductsDTO.setImage(obj[7].toString());
			newProductsDTO.setImgSrc(obj[19].toString());
			newProductsDTO.setTax(Integer.valueOf(obj[17].toString()));
			
			mediaList = eTicaret_ProductsServiceImpl
					.getProducts_Medias(Integer.valueOf((obj[0].toString())));
			List<ETicaret_Products_Media> newMediaList = new ArrayList<ETicaret_Products_Media>();
			List<Object> resultMedia = (List<Object>) mediaList;
			Iterator itrMedia = resultMedia.iterator();
			while (itrMedia.hasNext()) {
				// newMediaList.clear();
				ETicaret_Products_Media newETicaret_Products_Media = new ETicaret_Products_Media();
				Object[] objMedia = (Object[]) itrMedia.next();

				newETicaret_Products_Media.setId(Integer.valueOf((objMedia[0].toString())));
				newETicaret_Products_Media.setMedia_type_id(Integer.valueOf((objMedia[1].toString())));
				newETicaret_Products_Media.setProductId(Integer.valueOf((objMedia[2].toString())));
				newETicaret_Products_Media.setMedia_name(objMedia[3].toString());
				newETicaret_Products_Media.setMedia_url(objMedia[4].toString());
				newMediaList.add(newETicaret_Products_Media);

			}

			newProductsDTO.setProductMedias(newMediaList);

		}

		
		model.addObject("productDetail", newProductsDTO);
		model.addObject("mediaList", mediaList);

		model.addObject("detail", liste);

		// KATEGORİLER GÖZÜKMESİ İÇİN KODUN BAŞLADIĞI YER.
		List<ETicaret_Categories> altkategori = eTicaret_CategoriesServiceImpl.getCategory();
		List<ETicaret_Categories> anakategori = eTicaret_CategoriesServiceImpl.getParentCategory();
		model.addObject("ana", anakategori);
		model.addObject("alt", altkategori);
		// KATEGORİLER GÖZÜKMESİ İÇİN KODUN BİTTİĞİ YER.


		List<CartItemDTO> cartItemList = new ArrayList<>();
		if (session.getAttribute("cartItemList") != null) {
			cartItemList = (List<CartItemDTO>) session.getAttribute("cartItemList");
			Double tempAmount = 0.0;
			for (CartItemDTO item : cartItemList) {
				setTotalAmount(tempAmount + (item.getPrice() * item.getProductQuantity()));
				tempAmount = getTotalAmount();
			}
			setCountItems(cartItemList.size());
			session.setAttribute("cartItemList", cartItemList);
			session.setAttribute("totalAmount", totalAmount);
			session.setAttribute("countItems", countItems);

		}

		return model;
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
