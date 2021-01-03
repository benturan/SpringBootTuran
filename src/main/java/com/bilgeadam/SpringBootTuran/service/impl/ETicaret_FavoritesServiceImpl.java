package com.bilgeadam.SpringBootTuran.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bilgeadam.SpringBootTuran.entity.ETicaret_Products_Favorite;
import com.bilgeadam.SpringBootTuran.repository.ETicaretFavoritesRepository;
import com.bilgeadam.SpringBootTuran.service.ETicaret_FavoritesService;



@Service
public class ETicaret_FavoritesServiceImpl implements ETicaret_FavoritesService {
	private final ETicaretFavoritesRepository eTicaretFavoritesRepository;

	

	public ETicaret_FavoritesServiceImpl(ETicaretFavoritesRepository eTicaretFavoritesRepository) {
		this.eTicaretFavoritesRepository = eTicaretFavoritesRepository;
	
	}

	@Override
	public List<Object[]> getFavorites(Long userid) {
		List<Object[]> data = eTicaretFavoritesRepository.getFavorites(userid);
		return data;
	}
	
	


	public ETicaret_Products_Favorite updateFavorite(ETicaret_Products_Favorite eTicaret_Products_Favorite) {
	
		
		ETicaret_Products_Favorite favoriteUpd = eTicaretFavoritesRepository.saveAndFlush(eTicaret_Products_Favorite);
	       return favoriteUpd;
	}
	
	public ETicaret_Products_Favorite save(ETicaret_Products_Favorite eTicaret_Products_Favorite) {
	
		
		ETicaret_Products_Favorite favoriteUpd = eTicaretFavoritesRepository.saveAndFlush(eTicaret_Products_Favorite);
	       return favoriteUpd;
	}

	@SuppressWarnings("unchecked")
	public List<Object> getFavoritesByUserId(int UserId) {
		List<Object> list = eTicaretFavoritesRepository.getFavoritesByUserId(UserId);
		return list;
	}
	
	public List<Object>  getFavoriteByProductIdAndUserId(int UserId, int ProductId)
	{
		List<Object> favorite = eTicaretFavoritesRepository.getFavoriteByProductIdAndUserId(UserId,ProductId);
		return favorite;
		
	}
	
	public void  deleteFavoriteByProductIdAndUserId(int UserId, int ProductId)
	{
		eTicaretFavoritesRepository.deleteFavoriteByProductIdAndUserId(UserId,ProductId);
		
		
	}

}