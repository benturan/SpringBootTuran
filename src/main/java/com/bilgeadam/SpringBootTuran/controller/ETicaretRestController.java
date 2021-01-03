package com.bilgeadam.SpringBootTuran.controller;

import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bilgeadam.SpringBootTuran.dto.MainCategoriesDTO;
import com.bilgeadam.SpringBootTuran.dto.MainCategories_ProductsDTO;
import com.bilgeadam.SpringBootTuran.dto.ProductDTO;
import com.bilgeadam.SpringBootTuran.entity.ETicaret_Categories;
import com.bilgeadam.SpringBootTuran.entity.ETicaret_Products;
import com.bilgeadam.SpringBootTuran.entity.ETicaret_Products_Details;
import com.bilgeadam.SpringBootTuran.entity.ETicaret_Products_Media;
import com.bilgeadam.SpringBootTuran.service.impl.ETicaret_CategoriesServiceImpl;
import com.bilgeadam.SpringBootTuran.service.impl.ETicaret_ProductsDetailsServiceImpl;
import com.bilgeadam.SpringBootTuran.service.impl.ETicaret_ProductsServiceImpl;

@SuppressWarnings("serial")
@RestController
public class ETicaretRestController implements Serializable {

	private final ETicaret_CategoriesServiceImpl eTicaret_CategoriesServiceImpl;
	private final ETicaret_ProductsServiceImpl eTicaret_ProductsServiceImpl;
	private final ETicaret_ProductsDetailsServiceImpl eTicaret_ProductsDetailsServiceImpl;

	public ETicaretRestController(ETicaret_ProductsDetailsServiceImpl eTicaret_ProductsDetailsServiceImpl,
			ETicaret_ProductsServiceImpl eTicaret_ProductsServiceImpl,
			ETicaret_CategoriesServiceImpl eTicaret_CategoriesServiceImpl) {
		this.eTicaret_CategoriesServiceImpl = eTicaret_CategoriesServiceImpl;
		this.eTicaret_ProductsServiceImpl = eTicaret_ProductsServiceImpl;
		this.eTicaret_ProductsDetailsServiceImpl = eTicaret_ProductsDetailsServiceImpl;

	}

	@RequestMapping(value = "/getCategory/{categoryname}", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<ETicaret_Categories> getCategoriesbyId(@PathVariable String categoryname) {

		Long id = null;
		if (categoryname.equalsIgnoreCase("Alt Kategori")) {
			id = null;
		} else if (categoryname.equalsIgnoreCase("Ana Kategori")) {
			id = null;
		}

		id = eTicaret_CategoriesServiceImpl.getCategoryid(categoryname);
		return eTicaret_CategoriesServiceImpl.getCategory(id);

	}

	@RequestMapping(value = "/getAllMainCategories/", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<ETicaret_Categories> getAllMainCategories() {

		List<ETicaret_Categories> liste = eTicaret_CategoriesServiceImpl.getParentCategory();
		return liste;
	}

	@RequestMapping(value = "/getParentIdAllCategories/{EnAltKategoriParentId}", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<ETicaret_Categories> getCategoriesbyId(@PathVariable int EnAltKategoriParentId) {

		List<ETicaret_Categories> liste = eTicaret_CategoriesServiceImpl.getCategory(EnAltKategoriParentId);
		return liste;
	}

	// En alt Kategorinin ParentId sini bulur
	@RequestMapping(value = "/getParentId/{seciliKategori}", method = RequestMethod.GET, headers = "Accept=application/json")
	public int findParentIdByCategoryId(@PathVariable int seciliKategori) {
		int ParentId = eTicaret_CategoriesServiceImpl.findParentIdByCategoryId(seciliKategori);
		return ParentId;
	}

	// En alt kategorinin parent id sinin parent id sini bulur
	@RequestMapping(value = "/subCategorysFindParentIdByParentId/{EnAltKategoriParentId}", method = RequestMethod.GET, headers = "Accept=application/json")
	public int findParentIdByParentId(@PathVariable int EnAltKategoriParentId) {
		int ParentId = eTicaret_CategoriesServiceImpl.subCategorysFindParentIdByParentId(EnAltKategoriParentId);
		return ParentId;
	}

	@RequestMapping(value = "/getProduct/{productid}", method = RequestMethod.GET, headers = "Accept=application/json")
	@ResponseBody
	public List<Object[]> dataProduct(@PathVariable Long productid) {
		return eTicaret_ProductsServiceImpl.alldataProduct(productid);

	}

	@RequestMapping(value = "/updateProduct", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView updateProduct(@RequestParam String name2, @RequestParam Long categoryid,
			@RequestParam Double price, @RequestParam String comment, @RequestParam int sales,
			@RequestParam(required = false) MultipartFile file,
			@RequestParam(value = "cbox", required = false) String cbox) {
		Long productid = eTicaret_ProductsServiceImpl.getProductID(name2);
		ETicaret_Products product = eTicaret_ProductsServiceImpl.getById(productid);

		if (cbox != null) {
			try {
				byte[] bytes = file.getBytes();
				Path path = Paths.get(System.getProperty("user.dir") + "//src//main//webapp//resources//img//catalog//"
						+ file.getOriginalFilename());
				Files.write(path, bytes);
				product.setImage(file.getOriginalFilename());
			} catch (IOException e) {
				product.setImage("Resim alınamadı.");
			}
		}

		product.setCategoryid(categoryid);
		product.setName(name2);
		product.setPrice(price);
		product.setSales(sales);
		product.setStatus(1);

		eTicaret_ProductsServiceImpl.update(product);

		Long productdetailid = eTicaret_ProductsDetailsServiceImpl.idyakalaproductidile(productid);

		ETicaret_Products_Details pdetail = eTicaret_ProductsDetailsServiceImpl.getById(productdetailid);

		pdetail.setDetail(comment);

		eTicaret_ProductsDetailsServiceImpl.save(pdetail);

		return new ModelAndView("redirect:/Admin/adminallproducts");
	}

	@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView addProduct(@RequestParam String name2, @RequestParam Long categoryid,
			@RequestParam Double price, @RequestParam String comment, @RequestParam int sales,
			@RequestParam MultipartFile file) {
		ETicaret_Products product = new ETicaret_Products();
		ETicaret_Products_Details pdetail = new ETicaret_Products_Details();

		product.setCategoryid(categoryid);
		product.setName(name2);
		product.setPrice(price);
		product.setSales(sales);
		product.setStatus(1);

		try {
			byte[] bytes = file.getBytes();
			Path path = Paths.get(System.getProperty("user.dir") + "//src//main//webapp//resources//img//catalog//"
					+ file.getOriginalFilename());
			Files.write(path, bytes);
			product.setImage(file.getOriginalFilename());
		} catch (IOException e) {
			product.setImage("Resim alınamadı.");
		}

		LocalDateTime now = LocalDateTime.now();
		Date date = Date.from(now.atZone(ZoneId.systemDefault()).toInstant());
		product.setDates(date);

		eTicaret_ProductsServiceImpl.save(product);

		Long productid = eTicaret_ProductsServiceImpl.getProductID(name2);

		pdetail.setProid(productid);
		pdetail.setDetail(comment);

		eTicaret_ProductsDetailsServiceImpl.save(pdetail);

		return new ModelAndView("redirect:/Admin/adminallproducts");

	}

	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/getMainCategories_Products/", method = RequestMethod.GET, headers = "Accept=application/json")
	@ResponseBody
	public List<MainCategoriesDTO> getMainCategories_Products() {
		List<MainCategoriesDTO> mainCategoriesDTOList = new ArrayList<MainCategoriesDTO>();

		List<ETicaret_Categories> mainCategoryList = eTicaret_CategoriesServiceImpl.getParentCategory();

		List<MainCategories_ProductsDTO> newList;
		for (ETicaret_Categories str : mainCategoryList) {
			// içinde ürünleri barındıran ana liste elemanları
			MainCategoriesDTO newMainCategoriesDTO = new MainCategoriesDTO();
			newMainCategoriesDTO.setCategory_name(str.getCategoryname());
			newMainCategoriesDTO.setCat_id(Integer.valueOf(str.getCategoryid().toString()));
			newMainCategoriesDTO.setCategory_image(str.getImgsrc());

			List<Object> productList = eTicaret_CategoriesServiceImpl
					.getCategories_ProductsByCategoryId(Integer.valueOf(str.getCategoryid().toString()));
			newList = new ArrayList<MainCategories_ProductsDTO>();
			List<Object> result = (List<Object>) productList;
			Iterator itr = result.iterator();
			while (itr.hasNext()) {
				Object[] obj = (Object[]) itr.next();
				MainCategories_ProductsDTO newMainCategories_ProductsDTO = new MainCategories_ProductsDTO();

				if (Integer.valueOf((obj[1].toString())) == Integer.valueOf(str.getCategoryid().toString())) {
					newMainCategories_ProductsDTO.setProductID(Integer.valueOf((obj[0].toString())));
					newMainCategories_ProductsDTO.setCategoryid(Integer.valueOf((obj[1].toString())));
					newMainCategories_ProductsDTO.setName(obj[3].toString());
					newMainCategories_ProductsDTO.setDescription(obj[4].toString());
					newMainCategories_ProductsDTO.setCategoryname(obj[18].toString());
					newMainCategories_ProductsDTO.setOldPrice(Double.valueOf((String) (obj[5].toString())));
					newMainCategories_ProductsDTO.setPrice(Double.valueOf((String) (obj[6].toString())));
					newMainCategories_ProductsDTO.setImage(obj[7].toString());
					newMainCategories_ProductsDTO.setImgSrc(obj[19].toString());
					newMainCategories_ProductsDTO.setSales(Integer.valueOf((obj[8].toString())));
					// newMainCategories_ProductsDTO.setDates(obj[9].toString());
					newMainCategories_ProductsDTO.setLimit(Double.valueOf((obj[10].toString())));
					newMainCategories_ProductsDTO.setStock(Integer.valueOf((obj[16].toString())));
					newMainCategories_ProductsDTO.setTax(Integer.valueOf((obj[17].toString())));
					newMainCategories_ProductsDTO.setStatus(Integer.valueOf((obj[18].toString())));
					List<Object> mediaList = eTicaret_CategoriesServiceImpl
							.getMainCategories_Products_Medias(Integer.valueOf((obj[0].toString())));
					List<ETicaret_Products_Media> newMediaList = new ArrayList<ETicaret_Products_Media>();
					List<Object> resultMedia = (List<Object>) mediaList;
					Iterator itrMedia = resultMedia.iterator();
					while (itrMedia.hasNext()) {
						ETicaret_Products_Media newETicaret_Products_Media = new ETicaret_Products_Media();
						Object[] objMedia = (Object[]) itrMedia.next();

						newETicaret_Products_Media.setId(Integer.valueOf((objMedia[0].toString())));
						newETicaret_Products_Media.setMedia_type_id(Integer.valueOf((objMedia[1].toString())));
						newETicaret_Products_Media.setProductId(Integer.valueOf((objMedia[2].toString())));
						newETicaret_Products_Media.setMedia_name(objMedia[3].toString());
						newETicaret_Products_Media.setMedia_url(objMedia[4].toString());
						newMediaList.add(newETicaret_Products_Media);

					}
					newMainCategories_ProductsDTO.setProductMedias(newMediaList);

				}
				newList.add(newMainCategories_ProductsDTO);

			}
			newMainCategoriesDTO.setProducts(newList);

			mainCategoriesDTOList.add(newMainCategoriesDTO);
		}

		return mainCategoriesDTOList;

	}

	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/getProductsDetailByProductId", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public ProductDTO getProductsDetailByProductId(String ProductId) {

		int GelenId = Integer.valueOf(ProductId);
		List<Object> list = eTicaret_CategoriesServiceImpl.getProductsDetailByProductId(GelenId);
		List<Object> mediaList;

		List<Object> result = (List<Object>) list;
		Iterator itr = result.iterator();
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
			newProductsDTO.setLimit(Double.valueOf((obj[10].toString())));
			newProductsDTO.setStock(Integer.valueOf((obj[16].toString())));
			newProductsDTO.setImgSrc(obj[19].toString());
			newProductsDTO.setSales(Integer.valueOf((obj[8].toString())));
			// newMainCategories_ProductsDTO.setDates(obj[9].toString());
			newProductsDTO.setStatus(Integer.valueOf((obj[17].toString())));
			newProductsDTO.setQuantity(Double.valueOf((obj[10].toString())));
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

		}

		return newProductsDTO;

	}

	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/SearchAllProducts", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public List<ETicaret_Products> mobileSearch(String sorgu) {

		List<ETicaret_Products> list = eTicaret_ProductsServiceImpl.mobileSearch(sorgu);

		return list;

	}

	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/SearchAllProducts2", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public List<ProductDTO> mobileSearch2(String sorgu) {

		List<ProductDTO> productDTOList = new ArrayList<ProductDTO>();
		// List<ETicaret_Products> list =
		// eTicaret_ProductsServiceImpl.mobileSearch(sorgu);
		List<Object> list = eTicaret_ProductsServiceImpl.mobileSearch2(sorgu);
		// List<Object> list =
		// eTicaret_CategoriesServiceImpl.getCategories_ProductsByCategoryId(GelenId);
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
			// newProductsDTO.setQuantity(Double.valueOf(obj[8].toString()));
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

		return productDTOList;

	}

}
