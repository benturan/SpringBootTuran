package com.bilgeadam.SpringBootTuran.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bilgeadam.SpringBootTuran.entity.ETicaret_Products_Order_Detail;
import com.bilgeadam.SpringBootTuran.repository.ETicaret_ProductsOrderDetailRepository;
import com.bilgeadam.SpringBootTuran.service.ETicaret_ProductsOrderDetailService;

@Service
public class ETicaret_ProductsOrderDetailServiceImpl implements ETicaret_ProductsOrderDetailService{

 
	@SuppressWarnings("unused")
	private final ETicaret_ProductsOrderDetailRepository eTicaret_ProductsOrderDetailRepository;
		 
		 public ETicaret_ProductsOrderDetailServiceImpl(ETicaret_ProductsOrderDetailRepository eTicaret_ProductsOrderDetailRepository)
		 {
			 this.eTicaret_ProductsOrderDetailRepository = eTicaret_ProductsOrderDetailRepository;
		 }
		
		@Override
		public List<ETicaret_Products_Order_Detail> getAll() {
			 List<ETicaret_Products_Order_Detail> data = eTicaret_ProductsOrderDetailRepository.findAll();
		        return data;
		
		}

		@Override
		public ETicaret_Products_Order_Detail getById(Long id) {
			ETicaret_Products_Order_Detail od = eTicaret_ProductsOrderDetailRepository.getOne(id);
	        return od;
		}

		@Override
		public void save(ETicaret_Products_Order_Detail eTicaret_Products_Order_Detail) {
			eTicaret_ProductsOrderDetailRepository.save(eTicaret_Products_Order_Detail);
		       
		}

		@SuppressWarnings({ "unused", "null" })
		@Override
		public ETicaret_Products_Order_Detail update(ETicaret_Products_Order_Detail eTicaret_Products_Order_Detail) {
			ETicaret_Products_Order_Detail orderDetailDb = eTicaret_ProductsOrderDetailRepository.getOne(eTicaret_Products_Order_Detail.getId());
	        if (orderDetailDb == null)
	            throw new IllegalArgumentException("Project Does Not Exist ID:" + orderDetailDb.getId());
	        ETicaret_Products_Order_Detail orderDetailUpd = eTicaret_ProductsOrderDetailRepository.save(orderDetailDb);
	       return orderDetailUpd;
		}
		
		
		public List<ETicaret_Products_Order_Detail> getOrderDetailsByOrderId(int OrderId) {
			 List<ETicaret_Products_Order_Detail> data = eTicaret_ProductsOrderDetailRepository.getOrderDetailsByOrderId(OrderId);
		        return data;
		
		}


}
