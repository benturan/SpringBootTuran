package com.bilgeadam.SpringBootTuran.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bilgeadam.SpringBootTuran.entity.ETicaret_User_Adress;
import com.bilgeadam.SpringBootTuran.repository.ETicaret_User_AdressRepository;
import com.bilgeadam.SpringBootTuran.service.ETicaret_User_AdressService;

 


@Service
public class ETicaret_User_AdressServiceImpl implements ETicaret_User_AdressService {
	
	
	 private final ETicaret_User_AdressRepository eTicaret_User_AdressRepository;
	 
	 public ETicaret_User_AdressServiceImpl(ETicaret_User_AdressRepository eTicaret_User_AdressRepository) {
		this.eTicaret_User_AdressRepository= eTicaret_User_AdressRepository;
	}

	public ETicaret_User_Adress save(ETicaret_User_Adress eTicaret_User_Adress) {
		ETicaret_User_Adress data= eTicaret_User_AdressRepository.save(eTicaret_User_Adress);
		return data;
	}

	
	public List<ETicaret_User_Adress>  getAllAdress(int userId){		
		List<ETicaret_User_Adress> data=eTicaret_User_AdressRepository.getAllAdress(userId);
		return data;		
	}


	public ETicaret_User_Adress  adressDelete(int userId, int adresId)
	{
		ETicaret_User_Adress data = eTicaret_User_AdressRepository.adresDelete(userId, adresId);
		return data;
		
	}

	@Override
	public List<ETicaret_User_Adress> getAll() {
		List<ETicaret_User_Adress> data=eTicaret_User_AdressRepository.findAll();
		return data;
	}

	

	public ETicaret_User_Adress controlSave() {
		ETicaret_User_Adress data=eTicaret_User_AdressRepository.controlSave();
		return data;
	}

}
