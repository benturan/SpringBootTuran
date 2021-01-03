package com.bilgeadam.SpringBootTuran.admin;

 
import com.bilgeadam.SpringBootTuran.dto.OrderDTO;
import com.bilgeadam.SpringBootTuran.entity.ETicaret_Categories;
import com.bilgeadam.SpringBootTuran.entity.ETicaret_Products;
import com.bilgeadam.SpringBootTuran.entity.ETicaret_Products_Order;
import com.bilgeadam.SpringBootTuran.service.impl.ETicaret_CategoriesServiceImpl;
import com.bilgeadam.SpringBootTuran.service.impl.ETicaret_ProductsOrderServiceImpl;
import com.bilgeadam.SpringBootTuran.service.impl.ETicaret_ProductsServiceImpl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Controller
public class AdminOrderViewController {
	private final ETicaret_ProductsServiceImpl eTicaret_ProductsServiceImpl;
	private final ETicaret_CategoriesServiceImpl eTicaret_CategoriesServiceImpl;
	@SuppressWarnings("unused")
	private final ETicaret_ProductsOrderServiceImpl eTicaret_ProductsOrderServiceImpl;

	// Constructor Dependency Injection
	public AdminOrderViewController(ETicaret_CategoriesServiceImpl eTicaret_CategoriesServiceImpl,
			ETicaret_ProductsServiceImpl eTicaret_ProductsServiceImpl,
			ETicaret_ProductsOrderServiceImpl eTicaret_ProductsOrderServiceImpl) {
		this.eTicaret_ProductsServiceImpl = eTicaret_ProductsServiceImpl;
		this.eTicaret_CategoriesServiceImpl = eTicaret_CategoriesServiceImpl;
		this.eTicaret_ProductsOrderServiceImpl = eTicaret_ProductsOrderServiceImpl;
	}

	@RequestMapping(value = "/Admin/adminallorders", method = RequestMethod.GET)
	public ModelAndView getdata() {
		List<ETicaret_Products> adminproductlists = eTicaret_ProductsServiceImpl.getAll();
		List<ETicaret_Categories> admincategories = eTicaret_CategoriesServiceImpl.getParentCategory();
		List<ETicaret_Categories> altkategori = eTicaret_CategoriesServiceImpl.getCategory();
		List<ETicaret_Products_Order> adminorderlists = eTicaret_ProductsOrderServiceImpl.getAll();
		ModelAndView model = new ModelAndView("Admin/adminorders");
		model.addObject("adminproductlists", adminproductlists);
		model.addObject("parentcategory", admincategories);
		model.addObject("altkategori", altkategori);
		model.addObject("adminorderlists", getAllOrderList());
		return model;

	}

	public List<OrderDTO> getAllOrderList() {

		List<Object> orderList = eTicaret_ProductsOrderServiceImpl.getAllOrders();
		List<OrderDTO> newOrderList = new ArrayList<OrderDTO>();
		List<Object> result = (List<Object>) orderList;
		Iterator itr = result.iterator();
		while (itr.hasNext()) {
			Object[] obj = (Object[]) itr.next();
			OrderDTO newOrderDTO = new OrderDTO();
			Date date1;
			try {
				// java.text.ParseException: Unparseable date: "2020-05-21 20:16:22.0"
				//date1 = new SimpleDateFormat("yyyy-MM-dd").parse(obj[3].toString());
				//newOrderDTO.setDate(date1);
				newOrderDTO.setUserNameSurname(obj[9].toString() + " " + obj[10].toString());

				newOrderList.add(newOrderDTO);
			} catch ( Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return newOrderList;

	}

}
