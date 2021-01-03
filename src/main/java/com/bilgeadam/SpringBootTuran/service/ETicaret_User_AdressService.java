package com.bilgeadam.SpringBootTuran.service;

import java.util.List;

import com.bilgeadam.SpringBootTuran.entity.ETicaret_User_Adress;

 

public interface ETicaret_User_AdressService {

	ETicaret_User_Adress save(ETicaret_User_Adress eTicaret_User_Adress);

	List<ETicaret_User_Adress> getAll();

}
