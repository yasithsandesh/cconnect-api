package com.yasithsandesh.cconnect_api.service;

import com.yasithsandesh.cconnect_api.dto.request.FavoriteAddDTO;
import com.yasithsandesh.cconnect_api.entitiy.Favorite;

import java.util.List;

public interface FavoriteService {
    //add
    public boolean addFavorite(FavoriteAddDTO favoriteAddDTO);
    //all
    public List<Favorite> getAllFavorites(String userId);
    //remove
    public boolean removeFavorite(String favoriteId);
}
