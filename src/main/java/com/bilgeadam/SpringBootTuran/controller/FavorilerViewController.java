package com.bilgeadam.SpringBootTuran.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bilgeadam.SpringBootTuran.dto.AddToWishlistResponse;
import com.bilgeadam.SpringBootTuran.dto.ProductDTO;
import com.bilgeadam.SpringBootTuran.dto.WishlistResponse;
import com.bilgeadam.SpringBootTuran.entity.ETicaret_Categories;
import com.bilgeadam.SpringBootTuran.entity.ETicaret_Products_Favorite;
import com.bilgeadam.SpringBootTuran.entity.ETicaret_Products_Media;
import com.bilgeadam.SpringBootTuran.service.impl.ETicaret_CategoriesServiceImpl;
import com.bilgeadam.SpringBootTuran.service.impl.ETicaret_FavoritesServiceImpl;
import com.bilgeadam.SpringBootTuran.service.impl.ETicaret_UsersServiceImpl;
@Controller
public class FavorilerViewController {
	@Autowired
	private HttpSession httpSession;
	@SuppressWarnings("unused")
	private final ETicaret_UsersServiceImpl eTicaret_UsersServiceImpl;

	private final ETicaret_FavoritesServiceImpl eTicaret_FavoritesServiceImpl;

	private final ETicaret_CategoriesServiceImpl eTicaret_CategoriesServiceImpl;

	public FavorilerViewController(ETicaret_CategoriesServiceImpl eTicaret_CategoriesServiceImpl,
			ETicaret_FavoritesServiceImpl eTicaret_FavoritesServiceImpl,
			ETicaret_UsersServiceImpl eTicaret_UsersServiceImpl) {

		this.eTicaret_UsersServiceImpl = eTicaret_UsersServiceImpl;
		this.eTicaret_FavoritesServiceImpl = eTicaret_FavoritesServiceImpl;
		this.eTicaret_CategoriesServiceImpl = eTicaret_CategoriesServiceImpl;
	}

	@RequestMapping(value = "/allfavorites", method = RequestMethod.GET)
	public ModelAndView getFavoriler2(HttpServletRequest request) {

		// Long id = eTicaret_UsersServiceImpl.getUserid(email);
		Long userID=null;
		List<Object[]> data=null;
		if (httpSession.getAttribute("UserId")!=null) {
			 userID = Long.valueOf(httpSession.getAttribute("UserId").toString());
			 data = eTicaret_FavoritesServiceImpl.getFavorites(userID);
		}

		 

		ModelAndView model = new ModelAndView("favoriler");
		List<ETicaret_Categories> altkategori = eTicaret_CategoriesServiceImpl.getCategory();
		List<ETicaret_Categories> anakategori = eTicaret_CategoriesServiceImpl.getParentCategory();
		model.addObject("ana", anakategori);
		model.addObject("alt", altkategori);
		model.addObject("favories", data);

		return model;

	}

	@RequestMapping(value = "/allfavorites2", method = RequestMethod.GET)
	public ModelAndView getFavoriler2() {

		ModelAndView model = new ModelAndView("favoriler");
		// KATEGORİLER GÖZÜKMESİ İÇİN KODUN BAŞLADIĞI YER.
		List<ETicaret_Categories> altkategori = eTicaret_CategoriesServiceImpl.getCategory();
		List<ETicaret_Categories> anakategori = eTicaret_CategoriesServiceImpl.getParentCategory();
		model.addObject("ana", anakategori);
		model.addObject("alt", altkategori);
		// KATEGORİLER GÖZÜKMESİ İÇİN KODUN BİTTİĞİ YER.

		return model;

	}

	@SuppressWarnings({ "rawtypes", "unused" })
	@RequestMapping(value = "/addFavorite", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public AddToWishlistResponse addFavorite(String product_id, String user_id) {

		AddToWishlistResponse addToWishlistResponse = new AddToWishlistResponse();
		long ProductId = Long.valueOf(product_id);
		long UserId = Long.valueOf(user_id);

		List<Object> list = eTicaret_FavoritesServiceImpl.getFavoriteByProductIdAndUserId(Math.toIntExact(UserId),
				Math.toIntExact(ProductId));

		ETicaret_Products_Favorite existsFavorite = null;

		List<Object> result = (List<Object>) list;
		Iterator itr = result.iterator();

		while (itr.hasNext()) {
			Object[] obj = (Object[]) itr.next();
			existsFavorite = new ETicaret_Products_Favorite();
			existsFavorite.setId(Long.valueOf((obj[0].toString())));
			existsFavorite.setProductid(Long.valueOf((obj[1].toString())));
			existsFavorite.setUserid(Long.valueOf((obj[2].toString())));
			existsFavorite.setStatus(Integer.valueOf((obj[3].toString())));

		}
		// daha önce favariye eklenmiş sonra favorilerden çıkarılmış
		// ancak tekrar favorilere eklenmek istenen ürünü tekrar favarilere eklemek için
		if (existsFavorite != null) {
			if (existsFavorite.getStatus() == 0) {
				ETicaret_Products_Favorite favorite = new ETicaret_Products_Favorite();
				favorite.setId(existsFavorite.getId());
				favorite.setProductid(existsFavorite.getProductid());
				favorite.setUserid(existsFavorite.getUserid());
				favorite.setStatus(1);
				ETicaret_Products_Favorite newfavorite = eTicaret_FavoritesServiceImpl.updateFavorite(favorite);
				addToWishlistResponse.setSuccess("true");
				addToWishlistResponse.setMessage("Başarılı");
			} else {
				addToWishlistResponse.setSuccess("true");
				addToWishlistResponse.setMessage("Başarılı");
			}
		} else {
			ETicaret_Products_Favorite favorite = new ETicaret_Products_Favorite();
			favorite.setProductid(ProductId);
			favorite.setUserid(UserId);
			favorite.setStatus(1);
			ETicaret_Products_Favorite newfavorite = eTicaret_FavoritesServiceImpl.save(favorite);
			if (newfavorite != null) {
				addToWishlistResponse.setSuccess("true");
				addToWishlistResponse.setMessage("Başarılı");
			} else {
				addToWishlistResponse.setSuccess("false");
				addToWishlistResponse.setMessage("Başarısız");
			}
		}

		return addToWishlistResponse;

	}
	
	@SuppressWarnings({ "rawtypes", "unused" })
	@RequestMapping(value = "/addFavoriteWeb", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public ModelAndView addFavoriteWeb(String product_id, String user_id) {

		
		long ProductId = Long.valueOf(product_id);
		long UserId = Long.valueOf(user_id);

		List<Object> list = eTicaret_FavoritesServiceImpl.getFavoriteByProductIdAndUserId(Math.toIntExact(UserId),
				Math.toIntExact(ProductId));

		ETicaret_Products_Favorite existsFavorite = null;

		List<Object> result = (List<Object>) list;
		Iterator itr = result.iterator();

		while (itr.hasNext()) {
			Object[] obj = (Object[]) itr.next();
			existsFavorite = new ETicaret_Products_Favorite();
			existsFavorite.setId(Long.valueOf((obj[0].toString())));
			existsFavorite.setProductid(Long.valueOf((obj[1].toString())));
			existsFavorite.setUserid(Long.valueOf((obj[2].toString())));
			existsFavorite.setStatus(Integer.valueOf((obj[3].toString())));

		}
		// daha önce favariye eklenmiş sonra favorilerden çıkarılmış
		// ancak tekrar favorilere eklenmek istenen ürünü tekrar favarilere eklemek için
		if (existsFavorite != null) {
			if (existsFavorite.getStatus() == 0) {
				ETicaret_Products_Favorite favorite = new ETicaret_Products_Favorite();
				favorite.setId(existsFavorite.getId());
				favorite.setProductid(existsFavorite.getProductid());
				favorite.setUserid(existsFavorite.getUserid());
				favorite.setStatus(1);
				ETicaret_Products_Favorite newfavorite = eTicaret_FavoritesServiceImpl.updateFavorite(favorite);
				
			} else {
				
			}
		} else {
			ETicaret_Products_Favorite favorite = new ETicaret_Products_Favorite();
			favorite.setProductid(ProductId);
			favorite.setUserid(UserId);
			favorite.setStatus(1);
			ETicaret_Products_Favorite newfavorite = eTicaret_FavoritesServiceImpl.save(favorite);
			if (newfavorite != null) {
				
			} else {
				
			}
		}

		return new ModelAndView("redirect:/allfavorites");

	}

	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/deleteFavorite", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public AddToWishlistResponse deleteFavorite(String product_id, String user_id) {

		AddToWishlistResponse addToWishlistResponse = new AddToWishlistResponse();
		int ProductId = Integer.valueOf(product_id);
		int UserId = Integer.valueOf(user_id);

		List<Object> list = eTicaret_FavoritesServiceImpl.getFavoriteByProductIdAndUserId(UserId, ProductId);

		ETicaret_Products_Favorite existsFavorite = null;

		List<Object> result = (List<Object>) list;
		Iterator itr = result.iterator();

		while (itr.hasNext()) {
			Object[] obj = (Object[]) itr.next();
			existsFavorite = new ETicaret_Products_Favorite();
			existsFavorite.setId(Long.valueOf((obj[0].toString())));
			existsFavorite.setProductid(Long.valueOf((obj[1].toString())));
			existsFavorite.setUserid(Long.valueOf((obj[2].toString())));

		}

		if (existsFavorite != null) {
			ETicaret_Products_Favorite favorite = new ETicaret_Products_Favorite();
			favorite.setId(existsFavorite.getId());
			favorite.setProductid(existsFavorite.getProductid());
			favorite.setUserid(existsFavorite.getUserid());
			favorite.setStatus(0);
			ETicaret_Products_Favorite newfavorite = eTicaret_FavoritesServiceImpl.updateFavorite(favorite);
			if (newfavorite != null) {
				addToWishlistResponse.setSuccess("true");
				addToWishlistResponse.setMessage("Başarılı");
			} else {
				addToWishlistResponse.setSuccess("false");
				addToWishlistResponse.setMessage("Başarısız");
			}
		}

		return addToWishlistResponse;

	}
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/deleteWebFavorite", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public ModelAndView deleteWebFavorite(String product_id, String user_id) {

	
		int ProductId = Integer.valueOf(product_id);
		int UserId = Integer.valueOf(user_id);

		List<Object> list = eTicaret_FavoritesServiceImpl.getFavoriteByProductIdAndUserId(UserId, ProductId);

		ETicaret_Products_Favorite existsFavorite = null;

		List<Object> result = (List<Object>) list;
		Iterator itr = result.iterator();

		while (itr.hasNext()) {
			Object[] obj = (Object[]) itr.next();
			existsFavorite = new ETicaret_Products_Favorite();
			existsFavorite.setId(Long.valueOf((obj[0].toString())));
			existsFavorite.setProductid(Long.valueOf((obj[1].toString())));
			existsFavorite.setUserid(Long.valueOf((obj[2].toString())));

		}

		if (existsFavorite != null) {
			ETicaret_Products_Favorite favorite = new ETicaret_Products_Favorite();
			favorite.setId(existsFavorite.getId());
			favorite.setProductid(existsFavorite.getProductid());
			favorite.setUserid(existsFavorite.getUserid());
			favorite.setStatus(0);
			ETicaret_Products_Favorite newfavorite = eTicaret_FavoritesServiceImpl.updateFavorite(favorite);
			if (newfavorite != null) {
				return new ModelAndView("redirect:/allfavorites");
			} 
		}

		return new ModelAndView("redirect:/allfavorites");

	}

	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/deleteFavorite2", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public AddToWishlistResponse deleteFavorite2(String product_id, String user_id) {

		AddToWishlistResponse addToWishlistResponse = new AddToWishlistResponse();
		Long ProductId = Long.valueOf(product_id);
		Long UserId = Long.valueOf(user_id);

		eTicaret_FavoritesServiceImpl.deleteFavoriteByProductIdAndUserId(Math.toIntExact(UserId),
				Math.toIntExact(ProductId));

		ETicaret_Products_Favorite favorite = new ETicaret_Products_Favorite();

		favorite.setProductid(ProductId);
		favorite.setUserid(UserId);
		favorite.setStatus(0);

		addToWishlistResponse.setSuccess("true");
		addToWishlistResponse.setMessage("Başarılı");

		return addToWishlistResponse;

	}

	@RequestMapping(value = "/getFavori_Products", method = RequestMethod.POST)
	@ResponseBody
	public WishlistResponse getFavori_Products(@RequestParam String user_id) {

		WishlistResponse newWishlistResponse = new WishlistResponse();

		int UserId = Integer.valueOf(user_id);
		List<ProductDTO> newList;

		List<Object> productList = eTicaret_FavoritesServiceImpl.getFavoritesByUserId(UserId);
		newList = new ArrayList<ProductDTO>();
		List<Object> result = (List<Object>) productList;
		Iterator itr = result.iterator();
		while (itr.hasNext()) {
			Object[] obj = (Object[]) itr.next();
			ProductDTO newProductsDTO = new ProductDTO();
			newProductsDTO.setProductID(Integer.valueOf((obj[0].toString())));
			newProductsDTO.setCategoryid(Integer.valueOf((obj[1].toString())));
			newProductsDTO.setName(obj[3].toString());
			newProductsDTO.setDescription(obj[4].toString());
			// newProductsDTO.setCategoryname(obj[18].toString());
			newProductsDTO.setPrice(Double.valueOf((String) (obj[6].toString())));
			newProductsDTO.setImage(obj[7].toString());
			// newProductsDTO.setImgSrc(obj[19].toString());
			newProductsDTO.setSales(Integer.valueOf((obj[8].toString())));
			// newMainCategories_ProductsDTO.setDates(obj[9].toString());
			newProductsDTO.setQuantity(Double.valueOf((obj[10].toString())));
			newProductsDTO.setStatus(Integer.valueOf((obj[17].toString())));
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
			newProductsDTO.setProductMedias(newMediaList);

			newList.add(newProductsDTO);

		}
		newWishlistResponse.setSuccess("true");
		newWishlistResponse.setMessage("Başarılı");
		newWishlistResponse.setProduct(newList);

		return newWishlistResponse;

	}

	@SuppressWarnings({ "rawtypes", "unused" })
	@RequestMapping(value = "/wishCheck", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public AddToWishlistResponse wishCheck(String product_id, String user_id) {

		AddToWishlistResponse addToWishlistResponse = new AddToWishlistResponse();
		long ProductId = Long.valueOf(product_id);
		long UserId = 0;
		if (user_id == "" || user_id == null) {
			UserId = 0;

		} else {
			UserId = Long.valueOf(user_id);
		}

		List<Object> list = eTicaret_FavoritesServiceImpl.getFavoriteByProductIdAndUserId(Math.toIntExact(UserId),
				Math.toIntExact(ProductId));

		ETicaret_Products_Favorite existsFavorite = null;
		;

		List<Object> result = (List<Object>) list;
		Iterator itr = result.iterator();

		while (itr.hasNext()) {
			Object[] obj = (Object[]) itr.next();
			existsFavorite = new ETicaret_Products_Favorite();
			existsFavorite.setId(Long.valueOf((obj[0].toString())));
			existsFavorite.setProductid(Long.valueOf((obj[1].toString())));
			existsFavorite.setUserid(Long.valueOf((obj[2].toString())));
			existsFavorite.setStatus(Integer.valueOf((obj[3].toString())));

		}
		if (existsFavorite != null) {
			if (existsFavorite.getStatus() == 0) {
				addToWishlistResponse.setSuccess("false");
				addToWishlistResponse.setMessage("Başarısız");
			} else {
				addToWishlistResponse.setSuccess("true");
				addToWishlistResponse.setMessage("Başarılı");
			}
		} else {
			addToWishlistResponse.setSuccess("false");
			addToWishlistResponse.setMessage("Başarısız");
		}

		return addToWishlistResponse;

	}

}
