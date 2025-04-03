package com.yasithsandesh.cconnect_api.service.impl;

import com.yasithsandesh.cconnect_api.dto.request.FavoriteAddDTO;
import com.yasithsandesh.cconnect_api.entitiy.Favorite;
import com.yasithsandesh.cconnect_api.entitiy.ServiceProfile;
import com.yasithsandesh.cconnect_api.repo.FavoriteRepo;
import com.yasithsandesh.cconnect_api.repo.ServiceProfileRepo;
import com.yasithsandesh.cconnect_api.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteServiceIMPL implements FavoriteService {

    @Autowired
    FavoriteRepo favoriteRepo;

    @Autowired
    ServiceProfileRepo serviceProfileRepo;

    @Override
    public boolean addFavorite(FavoriteAddDTO favoriteAddDTO) {
        ServiceProfile serviceProfile = this.serviceProfileRepo.getReferenceById(favoriteAddDTO.getServiceProfileId());
        Favorite favorite = new Favorite(favoriteAddDTO.getUserId(),serviceProfile);
        this.favoriteRepo.save(favorite);
        return true;
    }

    @Override
    public List<Favorite> getAllFavorites(String userId) {
        List<Favorite> favorites = this.favoriteRepo.findByUserId(userId);
        return favorites;
    }

    @Override
    public boolean removeFavorite(String favoriteId) {
       Favorite favorite =  this.favoriteRepo.getReferenceById(Long.parseLong(favoriteId));
       this.favoriteRepo.delete(favorite);
        return true;
    }
}
