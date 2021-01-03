package com.bilgeadam.SpringBootTuran.service;

import java.util.List;

import com.bilgeadam.SpringBootTuran.entity.ETicaret_Products_Favorite;


public interface ETicaret_FavoritesService {
	
	List<Object[]> getFavorites(Long userid);
	
	ETicaret_Products_Favorite save(ETicaret_Products_Favorite eTicaret_Favorites);

}