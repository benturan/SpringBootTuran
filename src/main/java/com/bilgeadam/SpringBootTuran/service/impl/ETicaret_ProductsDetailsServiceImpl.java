package com.bilgeadam.SpringBootTuran.service.impl;

import java.util.List;

 

 
import org.springframework.stereotype.Service;

import com.bilgeadam.SpringBootTuran.entity.ETicaret_Products_Details;
import com.bilgeadam.SpringBootTuran.repository.ETicaret_ProductsDetailsRepository;
import com.bilgeadam.SpringBootTuran.service.ETicaret_ProductsDetailsService;

 


@Service
public class ETicaret_ProductsDetailsServiceImpl implements ETicaret_ProductsDetailsService {
	private final ETicaret_ProductsDetailsRepository eTicaret_ProductsDetailsRepository;	
	
	
	 

	    public ETicaret_ProductsDetailsServiceImpl
	    (ETicaret_ProductsDetailsRepository eTicaret_ProductsDetailsRepository ) {
	        this.eTicaret_ProductsDetailsRepository = eTicaret_ProductsDetailsRepository;
	         
	    }
	    
	    public List<Object[]> getDetail(Long id) {
	    	List<Object[]> liste = eTicaret_ProductsDetailsRepository.getDetail(id);
	    	return liste;
			
		}
	    

	    @Override
	    public ETicaret_Products_Details save(ETicaret_Products_Details eTicaret_Products_Details) {
	    	ETicaret_Products_Details data = eTicaret_ProductsDetailsRepository.save(eTicaret_Products_Details);
	        return data;
	      
	    }

		@Override
		public ETicaret_Products_Details getById(Long id) {
			ETicaret_Products_Details p = eTicaret_ProductsDetailsRepository.getOne(id);
	        return p;
		}

		@Override
		public Long idyakalaproductidile(Long pid) {
			Long id = eTicaret_ProductsDetailsRepository.idyakalaproductidile(pid);
			return id;
		}

		@Override
		public void updateproductdetail(String detail, Long pid) {
			eTicaret_ProductsDetailsRepository.updateproductdetail(detail, pid);
			
		}

		
	    
	    
	
	
}
