package com.bilgeadam.SpringBootTuran.admin;

 
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import com.bilgeadam.SpringBootTuran.entity.ETicaret_Categories;
import com.bilgeadam.SpringBootTuran.entity.ETicaret_Manset;
 
 
import com.bilgeadam.SpringBootTuran.repository.ETicaret_MansetRepository;
 
import com.bilgeadam.SpringBootTuran.service.impl.ETicaret_CategoriesServiceImpl;
import com.bilgeadam.SpringBootTuran.service.impl.ETicaret_MansetsServiceImpl;
import com.bilgeadam.SpringBootTuran.service.impl.ETicaret_ProductsServiceImpl;
 

@Controller
public class AdminMansetViewController {
	private final ETicaret_MansetsServiceImpl eTicaret_MansetsServiceImpl;
	@SuppressWarnings("unused")
	private final ETicaret_CategoriesServiceImpl eTicaret_CategoriesServiceImpl;
	private final ETicaret_MansetRepository eTicaret_MansetRepository;

	public AdminMansetViewController(ETicaret_MansetsServiceImpl eTicaret_MansetsServiceImpl,
			ETicaret_CategoriesServiceImpl eTicaret_CategoriesServiceImpl,
			ETicaret_MansetRepository eTicaret_MansetRepository) {
		this.eTicaret_MansetsServiceImpl = eTicaret_MansetsServiceImpl;
		this.eTicaret_CategoriesServiceImpl = eTicaret_CategoriesServiceImpl;
		this.eTicaret_MansetRepository = eTicaret_MansetRepository;

	}

	@RequestMapping(value = "/Admin/adminallmansets", method = RequestMethod.GET)
	public ModelAndView getMansets() {
		List<ETicaret_Manset> adminmansetlists = eTicaret_MansetsServiceImpl.getAll();

		List<ETicaret_Categories> admincategories = eTicaret_CategoriesServiceImpl.getParentCategory();
		List<ETicaret_Categories> altkategori = eTicaret_CategoriesServiceImpl.getCategory();
		ModelAndView model = new ModelAndView("Admin/adminmansets");
		model.addObject("adminmansetlists", adminmansetlists);
		model.addObject("parentcategory", admincategories);
		model.addObject("altkategori", altkategori);
		return model;

	}

	@RequestMapping(value = "/getSubCategory/{parentCategoryId}", method = RequestMethod.GET, headers = "Accept=application/json")
	public ModelAndView getSubCategoriessByParentCategoryId(@PathVariable int parentCategoryId) {
		List<ETicaret_Categories> altKategoriler = eTicaret_CategoriesServiceImpl.getCategory(parentCategoryId);
		ModelAndView model = new ModelAndView("Admin/adminmansets");
		model.addObject("altKategoriler", altKategoriler);
		return model;
	}

	@SuppressWarnings("unused")
	@RequestMapping(value = "/Admin/mansetAdd", method = RequestMethod.POST)
	public String save(@RequestParam("file") MultipartFile file, @RequestParam String baslik,
			@RequestParam int mansetmaincategoryId, @RequestParam int mansetsubcategoryId, @RequestParam int categoryid,
			@RequestParam String detay, @RequestParam int sira) {

		int CategoryID = 0;

		if (file.isEmpty()) {

			return "redirect:/Admin/adminallmansets";
		}

		try {

			// Get the file and save it somewhere
			byte[] bytes = file.getBytes();
			Path path = Paths.get(System.getProperty("user.dir")
					+ "//src//main//resources//static//img//hero//slideshow//" + file.getOriginalFilename());
			Files.write(path, bytes);
			
			//C:\Users\Administrator\Downloads\mehmetulker\ecommerce2\src\main\resources\static\img\hero\slideshow

		} catch (IOException e) {
			e.printStackTrace();
		}

		if (mansetmaincategoryId > 0) {
			CategoryID = mansetmaincategoryId;
		}
		if (mansetsubcategoryId > 0) {
			CategoryID = mansetsubcategoryId;
		}
		if (categoryid > 0) {
			CategoryID = categoryid;
		}

		ETicaret_Manset manset = new ETicaret_Manset();
		manset.setImage(file.getOriginalFilename());
		manset.setBaslik(baslik);
		manset.setDetay(detay);
		manset.setSira(sira);
		manset.setCategoryId(CategoryID);
		manset.setStatu(1);
		eTicaret_MansetsServiceImpl.save(manset);

		return "redirect:/Admin/adminallmansets";
	}

	@RequestMapping(value = "/Admin/adminallmansets", method = RequestMethod.POST)
	public String addManset() {

		return "return:/adminallmansets";

	}
	
	

	@RequestMapping(value = "/getManset/{mid}", method = RequestMethod.GET, headers = "Accept=application/json")
	@ResponseBody
	public List<Object[]> dataMansetProduct(@PathVariable int mid) {
		return eTicaret_MansetsServiceImpl.allMansetdataProduct(mid);

	}

	@RequestMapping(value = "/Admin/updateManset/{mid}", method = RequestMethod.POST, headers = "Accept=application/json")
	@ResponseBody
	public ModelAndView updateMansets(@RequestParam int mid, @RequestParam("file") MultipartFile file,
			@RequestParam String baslik, @RequestParam int mansetmaincategoryId, @RequestParam int mansetsubcategoryId,
			@RequestParam int categoryid, @RequestParam String detay, @RequestParam int sira) {

		int CategoryID = 0;
		
		ETicaret_Manset mansetDb = (ETicaret_Manset) eTicaret_MansetsServiceImpl.mansetById(mid);
		

		if (file.getOriginalFilename().toString().length()>3) {

			Path pathEski = Paths.get(System.getProperty("user.dir") + "//src//main//resources//static//img//hero//slideshow//"	
					+ mansetDb.getImage());
			File fileeski = new File(pathEski.toString());
			   if(fileeski.exists()) { 

				   fileeski.delete();
			    
			   }
				try {
					byte[] bytes = file.getBytes();
					Path pathYeni = Paths.get(System.getProperty("user.dir") + "//src//main//resources//static//img//hero//slideshow//"
							+ file.getOriginalFilename());
					Files.write(pathYeni, bytes);
					mansetDb.setImage(file.getOriginalFilename());
				} catch (IOException e) {
					mansetDb.setImage("Resim alınamadı.");
				}
		}
		

		if (mansetmaincategoryId > 0) {
			CategoryID = mansetmaincategoryId;
		}
		if (mansetsubcategoryId > 0) {
			CategoryID = mansetsubcategoryId;
		}
		if (categoryid > 0) {
			CategoryID = categoryid;
		}

	

		mansetDb.setBaslik(baslik);
		mansetDb.setDetay(detay);
		mansetDb.setSira(sira);
		mansetDb.setCategoryId(CategoryID);
		mansetDb.setStatu(1);

		eTicaret_MansetsServiceImpl.update(mansetDb);

		List<ETicaret_Manset> adminmansetlists = eTicaret_MansetsServiceImpl.getAll();

		List<ETicaret_Categories> admincategories = eTicaret_CategoriesServiceImpl.getParentCategory();
		List<ETicaret_Categories> altkategori = eTicaret_CategoriesServiceImpl.getCategory();
		ModelAndView model = new ModelAndView("Admin/adminmansets");
		model.addObject("adminmansetlists", adminmansetlists);
		model.addObject("parentcategory", admincategories);
		model.addObject("altkategori", altkategori);
		return model;
	}
	
	@RequestMapping(value = "/deleteManset/{mid}", method = {RequestMethod.DELETE,RequestMethod.GET})
	@ResponseBody
	public ModelAndView deleteManset(@PathVariable int mid) {
		
		Long midLong = (long) mid;
		eTicaret_MansetsServiceImpl.delete(midLong);		
		return new ModelAndView("redirect:/Admin/adminallmansets");
	}

}
