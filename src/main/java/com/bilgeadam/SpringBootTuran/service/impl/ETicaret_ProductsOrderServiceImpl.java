package com.bilgeadam.SpringBootTuran.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bilgeadam.SpringBootTuran.entity.ETicaret_Products_Order;
import com.bilgeadam.SpringBootTuran.repository.ETicaret_ProductsOrderRepository;
import com.bilgeadam.SpringBootTuran.service.ETicaret_ProductsOrderService;


@Service
public class ETicaret_ProductsOrderServiceImpl implements ETicaret_ProductsOrderService {

	private final ETicaret_ProductsOrderRepository eTicaret_ProductsOrderRepository;

	public ETicaret_ProductsOrderServiceImpl(ETicaret_ProductsOrderRepository eTicaret_ProductsOrderRepository) {
		this.eTicaret_ProductsOrderRepository = eTicaret_ProductsOrderRepository;
	}

	@Override
	public List<ETicaret_Products_Order> getAll() {
		List<ETicaret_Products_Order> data = eTicaret_ProductsOrderRepository.findAll();
		return data;

	}

	@Override
	public ETicaret_Products_Order getById(Long id) {
		ETicaret_Products_Order o = eTicaret_ProductsOrderRepository.getOne(id);
		return o;
	}

	@Override
	public ETicaret_Products_Order save(ETicaret_Products_Order eTicaret_Products_Order) {
		ETicaret_Products_Order eTicaret_Products_OrderDB = eTicaret_ProductsOrderRepository
				.save(eTicaret_Products_Order);
		return eTicaret_Products_OrderDB;
	}

	@SuppressWarnings({ "unused", "null" })
	@Override
	public ETicaret_Products_Order update(ETicaret_Products_Order eTicaret_Products_Order) {
		ETicaret_Products_Order orderDb = eTicaret_ProductsOrderRepository.getOne(eTicaret_Products_Order.getId());
		if (orderDb == null)
			throw new IllegalArgumentException("Project Does Not Exist ID:" + orderDb.getId());
		ETicaret_Products_Order orderUpd = eTicaret_ProductsOrderRepository.save(orderDb);
		return orderDb;
	}
	
	public List<ETicaret_Products_Order> getMyOrders(int UserId)
	{
		List<ETicaret_Products_Order> orders = eTicaret_ProductsOrderRepository.getMyOrders(UserId);
		return orders;
	}
	
	public List<Object> getAllOrders()
	{
		List<Object> orders = eTicaret_ProductsOrderRepository.getAllOrders();
		return orders;
	}

}
