package com.bilgeadam.SpringBootTuran.service.impl;

import org.springframework.stereotype.Service;

import com.bilgeadam.SpringBootTuran.entity.ETicaret_Products;
import com.bilgeadam.SpringBootTuran.repository.ETicaret_ProductsRepository;
import com.bilgeadam.SpringBootTuran.service.ETicaret_ProductsService;

import java.util.List;

@Service
public class ETicaret_ProductsServiceImpl implements ETicaret_ProductsService {

	private final ETicaret_ProductsRepository eTicaret_ProductsRepository;

	public ETicaret_ProductsServiceImpl(ETicaret_ProductsRepository eTicaret_ProductsRepository) {
		this.eTicaret_ProductsRepository = eTicaret_ProductsRepository;

	}

	public List<Object> getProductsDetailByProductId(int ProductId) {
		List<Object> urunDetay = eTicaret_ProductsRepository.getProductsDetailByProductId(ProductId);
		return urunDetay;
	}

	public List<Object> getProducts_Medias(int productId) {
		List<Object> list = eTicaret_ProductsRepository.getProducts_Medias(productId);
		return list;
	}

	// en çok satanlar
	@Override
	public List<ETicaret_Products> encoksatan(int a) {
		List<ETicaret_Products> list = eTicaret_ProductsRepository.encoksatan(a);

		return list;
	}

	@Override
	public List<ETicaret_Products> encoksatanAll() {
		List<ETicaret_Products> list = eTicaret_ProductsRepository.encoksatanAll();

		return list;
	}

// indirimdeki ürünler
	@Override
	public List<ETicaret_Products> indirimdekiurunler(int a) {
		List<ETicaret_Products> list = eTicaret_ProductsRepository.indirimdekiurunler(a);

		return list;
	}

	@Override
	public List<ETicaret_Products> indirimdekiurunlerAll() {
		List<ETicaret_Products> list = eTicaret_ProductsRepository.indirimdekiurunlerAll();

		return list;
	}

	@Override
	public List<ETicaret_Products> getAll() {
		List<ETicaret_Products> data = eTicaret_ProductsRepository.findAll();
		return data;
	}

	@Override
	public ETicaret_Products getById(Long id) {
		ETicaret_Products p = eTicaret_ProductsRepository.getOne(id);
		return p;
	}

	@Override
	public ETicaret_Products save(ETicaret_Products eTicaret_Products) {
		ETicaret_Products eTicaret_Productsdb = eTicaret_ProductsRepository.save(eTicaret_Products);
		return eTicaret_Productsdb;

	}

	@Override
	public ETicaret_Products update(ETicaret_Products eTicaret_Products) {
		ETicaret_Products projectDb = eTicaret_ProductsRepository.getOne(eTicaret_Products.getProductID());
		if (projectDb == null)
			throw new IllegalArgumentException("Project Does Not Exist ID:" + eTicaret_Products.getProductID());

		// projectDb.setProjectCode(eTicaret_Products.getProjectCode());
		// projectDb.setProjectName(eTicaret_Products.getProjectName());
		// projectDb.setInsertDate(project.);
		ETicaret_Products projectUpd = eTicaret_ProductsRepository.save(projectDb);
		return projectUpd;
	}

	@Override
	public Boolean delete(Long id) {
		eTicaret_ProductsRepository.deleteById(id);
		return true;
	}

	public List<ETicaret_Products> getFiltrele(double fiyat1, double fiyat2) {
		List<ETicaret_Products> data = eTicaret_ProductsRepository.getFiltrele(fiyat1, fiyat2);
		return data;
	}

	public List<ETicaret_Products> get50below() {
		List<ETicaret_Products> data = eTicaret_ProductsRepository.get50below();
		return data;
	}

	@Override
	public List<ETicaret_Products> getClose4() {
		List<ETicaret_Products> data = eTicaret_ProductsRepository.getClose4();
		return data;
	}

	@Override
	public List<ETicaret_Products> getAllPCategory(Long id) {
		List<ETicaret_Products> data = eTicaret_ProductsRepository.getAllPCategory(id);
		return data;
	}

	@Override
	public Long getProductID(String productname) {
		Long id = eTicaret_ProductsRepository.getProductID(productname);
		return id;
	}

	@Override
	public List<ETicaret_Products> get12Products() {
		List<ETicaret_Products> data = eTicaret_ProductsRepository.get12Products();
		return data;
	}

	@Override
	public List<ETicaret_Products> ürüngetir(Long id) {
		List<ETicaret_Products> data = eTicaret_ProductsRepository.ürüngetir(id);
		return data;
	}

	@Override
	public List<Object[]> alldataProduct(Long id) {
		List<Object[]> data = eTicaret_ProductsRepository.alldataProduct(id);
		return data;
	}

	@SuppressWarnings("unchecked")
	public List<ETicaret_Products> mobileSearch(String sorgu) {
		List<ETicaret_Products> list = eTicaret_ProductsRepository.mobileSearch(sorgu);
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Object> mobileSearch2(String sorgu) {
		List<Object> list = eTicaret_ProductsRepository.mobileSearch2(sorgu);
		return list;
	}

}
