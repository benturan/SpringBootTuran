package com.bilgeadam.SpringBootTuran.controller;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bilgeadam.SpringBootTuran.dto.ProductDTO;
import com.bilgeadam.SpringBootTuran.entity.ETicaret_Products;
import com.bilgeadam.SpringBootTuran.entity.ETicaret_Products_Media;
import com.bilgeadam.SpringBootTuran.service.impl.ETicaret_CategoriesServiceImpl;
import com.bilgeadam.SpringBootTuran.service.impl.ETicaret_ProductsServiceImpl;
@SuppressWarnings("serial")
@Controller
public class SearchViewController implements Serializable {
	
        @SuppressWarnings("unused")
		private final  ETicaret_CategoriesServiceImpl eTicaret_CategoriesServiceImpl;
    	private final ETicaret_ProductsServiceImpl eTicaret_ProductsServiceImpl;
	
	public SearchViewController(ETicaret_CategoriesServiceImpl eTicaret_CategoriesServiceImpl,
			ETicaret_ProductsServiceImpl eTicaret_ProductsServiceImpl) {
		
                this.eTicaret_CategoriesServiceImpl = eTicaret_CategoriesServiceImpl;
                this.eTicaret_ProductsServiceImpl = eTicaret_ProductsServiceImpl;
	}
	
	
	
	@RequestMapping(value = "/search/", method = RequestMethod.POST,headers = "Accept=application/json")
	@ResponseBody
	public List<ETicaret_Products> ara(@RequestParam("categoryname") String categoryname) {
		//Long id = eTicaret_CategoriesServiceImpl.getCategoryid2(categoryname);
		//List<ETicaret_Products> liste = eTicaret_ProductsServiceImpl.getAllPCategory(1);
                return null;
            
		
	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/SearchAllProducts2", method = RequestMethod.GET, headers = "Accept=application/json")
	@ResponseBody
	public ModelAndView mobileSearch2(String sorgu) {
		ModelAndView model = new ModelAndView("filtrele");

		List<ProductDTO>  productDTOList = new ArrayList<ProductDTO>();
		//List<ETicaret_Products> list = eTicaret_ProductsServiceImpl.mobileSearch(sorgu);
		List<Object> list = eTicaret_ProductsServiceImpl.mobileSearch2(sorgu);
		//List<Object> list = eTicaret_CategoriesServiceImpl.getCategories_ProductsByCategoryId(GelenId);
		List<Object> mediaList;

		List<Object> result = (List<Object>) list;
		Iterator itr = result.iterator();
	
		while (itr.hasNext()) {
			Object[] obj = (Object[]) itr.next();
			ProductDTO newProductsDTO = new ProductDTO();
			newProductsDTO.setProductID(Integer.valueOf((obj[0].toString())));
			newProductsDTO.setCategoryid(Integer.valueOf((obj[1].toString())));
			newProductsDTO.setName(obj[3].toString());
			newProductsDTO.setCategoryname(obj[18].toString());
			newProductsDTO.setDescription(obj[4].toString());
			newProductsDTO.setOldPrice(Double.valueOf((String) (obj[5].toString())));
			newProductsDTO.setPrice(Double.valueOf((String) (obj[6].toString())));
			newProductsDTO.setImage(obj[7].toString());
			newProductsDTO.setImgSrc(obj[19].toString());
			newProductsDTO.setSales(Integer.valueOf((obj[8].toString())));
			newProductsDTO.setStock(Integer.valueOf((obj[16].toString())));
			//newProductsDTO.setQuantity(Double.valueOf(obj[8].toString()));
			// newMainCategories_ProductsDTO.setDates(obj[9].toString());
			newProductsDTO.setTax(Integer.valueOf((obj[17].toString())));
			newProductsDTO.setStatus(Integer.valueOf((obj[18].toString())));
			mediaList = eTicaret_CategoriesServiceImpl
					.getMainCategories_Products_Medias(Integer.valueOf((obj[0].toString())));
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
			
			productDTOList.add(newProductsDTO);
		
		}
		

		return model.addObject("filtreurun", productDTOList);

	}
	
	



}

