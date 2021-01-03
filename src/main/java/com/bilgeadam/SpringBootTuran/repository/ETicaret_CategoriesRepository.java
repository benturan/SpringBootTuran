
package com.bilgeadam.SpringBootTuran.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bilgeadam.SpringBootTuran.entity.ETicaret_Categories;


public interface ETicaret_CategoriesRepository extends JpaRepository<ETicaret_Categories, Long> {

	@Query(value = "SELECT * FROM eticaret_category u WHERE u.ParentCategoryId = 0", nativeQuery = true)
	List<ETicaret_Categories> getParentCategory();

	@Query(value = "SELECT * FROM eticaret_category u WHERE u.ParentCategoryId != 0", nativeQuery = true)
	List<ETicaret_Categories> getCategory();

	@Query(value = "SELECT CategoryId FROM eticaret_category u WHERE u.CategoryName = ?1", nativeQuery = true)
	Long getCategoryid(String categoryname);

	@Query(value = "SELECT * FROM eticaret_category u WHERE u.ParentCategoryId = ?1", nativeQuery = true)
	List<ETicaret_Categories> getCategory(long id);

	@Query(value = "SELECT u.ParentCategoryId FROM eticaret_category u WHERE u.CategoryId = ?1", nativeQuery = true)
	int findParentIdByCategoryId(long id);

	@Query(value = "SELECT u.ParentCategoryId FROM eticaret_category u WHERE u.CategoryId = ?1", nativeQuery = true)
	int subCategorysFindParentIdByParentId(long id);

	@Query(value = "SELECT * FROM eticaret_category u WHERE u.ParentCategoryId = ?1", nativeQuery = true)
	List<ETicaret_Categories> getParentIdAllCategories(long parentId);

	@Query(value = "select etp.*,etc.CategoryName,etc.ImgSrc from eticaret_products as etp inner join eticaret_category as etc "
			+ "on etc.CategoryId = etp.CategoryId where etc.ParentCategoryId=0", nativeQuery = true)
	List<Object> getCategories_Products();
	
	@Query(value = "SELECT * FROM eticaret_products_media  WHERE ProductId= ?1", nativeQuery = true)
	 List<Object>  getMainCategories_Products_Medias(int productId);
	
	@Query(value = "select etp.*,etc.CategoryName,etc.ImgSrc from eticaret_products as etp inner join eticaret_category as etc"
			+ " on etc.CategoryId = etp.CategoryId where etp.CategoryId=?1", nativeQuery = true)
	List<Object> getMainCategories_ProductsByCategoryId(int CategoryId);

	
	@Query(value = "select etp.*,etc.CategoryName,etc.ImgSrc from eticaret_products as etp inner join eticaret_category as etc"
			+ " on etc.CategoryId = etp.CategoryId where etp.ProductId=?1", nativeQuery = true)
	List<Object> getProductsDetailByProductId(int ProductId);


}
