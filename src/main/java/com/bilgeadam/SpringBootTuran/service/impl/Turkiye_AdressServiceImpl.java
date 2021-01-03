package com.bilgeadam.SpringBootTuran.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bilgeadam.SpringBootTuran.repository.Turkiye_AdressRepository;



@Service
public class Turkiye_AdressServiceImpl {

	private final Turkiye_AdressRepository turkiye_AdressRepository;

	public Turkiye_AdressServiceImpl(Turkiye_AdressRepository turkiye_AdressRepository) {

		this.turkiye_AdressRepository = turkiye_AdressRepository;

	}

	// il
	public List<Object> AllCity() {
		List<Object> data = turkiye_AdressRepository.AllCity();
		return data;

	}

	// ilçe
	public List<Object> getAllTown(String city) {
		List<Object> data = turkiye_AdressRepository.getAllTown(city);
		return data;
	}

	// Semt
	public List<Object> getAllDistrict(String town) {

		List<Object> data = turkiye_AdressRepository.getAllDistrict(town);
		return data;
	}

	// Mahalle
	public List<Object> getAllNeighborhoods(String district) {

		List<Object> data = turkiye_AdressRepository.getAllNeighborhoods(district);
		return data;
	}

	// Posta Kodu
	public Object getZipCode(String district, String neighborhoods) {
		Object data = turkiye_AdressRepository.getZipCode(district, neighborhoods);
		return data;
	}
	

}
