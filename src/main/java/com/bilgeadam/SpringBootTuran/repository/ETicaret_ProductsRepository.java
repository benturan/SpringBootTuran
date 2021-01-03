package com.bilgeadam.SpringBootTuran.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bilgeadam.SpringBootTuran.entity.ETicaret_Products;

public interface ETicaret_ProductsRepository extends JpaRepository<ETicaret_Products, Long> {

	@Query(value = "select etp.*,etc.CategoryName,etc.ImgSrc from eticaret_products as etp "
			+ "inner join eticaret_category as etc"
			+ " on etc.CategoryId = etp.CategoryId where etp.ProductId=?1", nativeQuery = true)
	List<Object> getProductsDetailByProductId(int ProductId);

	@Query(value = "SELECT * FROM eticaret_products_media  WHERE ProductId= ?1 order by Id desc", nativeQuery = true)
	List<Object> getProducts_Medias(int productId);

	 

	// en çok satan ürünler(index sayfasında gösterilecek ürün sayısına göre
	// limitler)
	@Query(value = "select * from eticaret_products where ProductID IN(select s.ProductId from(select sum(Quantity)as toplamorder,ProductId from eticaret_products_order_detail group by ProductId order by toplamorder desc limit ?1 ) as s)", nativeQuery = true)
	List<ETicaret_Products> encoksatan(int a);

	// indirimdeki ürünler(index sayfasında gösterilecek ürün sayısına göre
	// limitler)
	@Query(value = "select * from eticaret_products where OldPrice>Price limit ?1", nativeQuery = true)
	List<ETicaret_Products> indirimdekiurunler(int a);

	// tüm en çok satan ürünler(en çok satandan az satana göre sıralı gelir)
	@Query(value = "select * from eticaret_products where ProductID IN(select s.ProductId from(select sum(Quantity)as toplamorder,ProductId from eticaret_products_order_detail group by ProductId order by toplamorder desc ) as s)", nativeQuery = true)
	List<ETicaret_Products> encoksatanAll();

	// tüm indirimdeki ürünleri getirir.
	@Query(value = "select * from eticaret_products where OldPrice>Price", nativeQuery = true)
	List<ETicaret_Products> indirimdekiurunlerAll();
	
	@Query(value = "SELECT * FROM eticaret_products u WHERE u.Price between ?1 and ?2", nativeQuery = true)
	List<ETicaret_Products> getFiltrele(double fiyat1, double fiyat2);

	@Query(value = "SELECT * FROM eticaret_products u WHERE u.Price < 50", nativeQuery = true)
	List<ETicaret_Products> get50below();

	@Query(value = "select * from eticaret_products u order by  u.Dates desc limit 4 ", nativeQuery = true)
	List<ETicaret_Products> getClose4();

	@Query(value = "SELECT * FROM eticaret_products u WHERE u.CategoryId=?1", nativeQuery = true)
	List<ETicaret_Products> getAllPCategory(Long id);

	@Query(value = "SELECT ProductID FROM eticaret_products u WHERE u.Name = ?1", nativeQuery = true)
	Long getProductID(String productname);

	@Query(value = "select * from eticaret_products limit 12 ", nativeQuery = true)
	List<ETicaret_Products> get12Products();

	@Query(value = "select * from eticaret_products u where u.ProductID=?1  ", nativeQuery = true)
	List<ETicaret_Products> ürüngetir(Long id);

	@Query(value = "SELECT ep.ProductID,ep.Name,ep.Price,epd.Detail,ep.Image,ec.CategoryId,ep.Sales,ec.CategoryName FROM eticaret_products_detail as epd \r\n"
			+ "JOIN  eticaret_products ep on epd.ProductID = ep.ProductID \r\n"
			+ "JOIN eticaret_category ec on ec.CategoryId = ep.CategoryId\r\n" + "where ep.ProductID = ?1"
			+ "", nativeQuery = true)
	List<Object[]> alldataProduct(Long id);

	@Query(value = "SELECT * FROM eticaret_products WHERE Name LIKE '%' ?1  '%' limit 10", nativeQuery = true)
	List<ETicaret_Products> mobileSearch(String sorgu);
	
	@Query(value = "select etp.*,etc.CategoryName,etc.ImgSrc from eticaret_products as etp inner join eticaret_category as etc on etc.CategoryId = etp.CategoryId WHERE (etp.Name LIKE '%' ?1  '%') or (etc.CategoryName like '%' ?1  '%') limit 10", nativeQuery = true)
	List<Object> mobileSearch2(String sorgu);
}
