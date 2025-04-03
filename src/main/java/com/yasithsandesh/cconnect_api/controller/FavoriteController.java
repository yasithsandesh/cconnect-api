package com.yasithsandesh.cconnect_api.controller;

import com.yasithsandesh.cconnect_api.dto.request.FavoriteAddDTO;
import com.yasithsandesh.cconnect_api.entitiy.Favorite;
import com.yasithsandesh.cconnect_api.service.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/favorite")
public class FavoriteController {
    @Autowired
    private FavoriteService favoriteService;

    @PostMapping(path = "/add")
    public ResponseEntity addFavorite(@RequestBody FavoriteAddDTO favoriteAddDTO){
        return new ResponseEntity(this.favoriteService.addFavorite(favoriteAddDTO),HttpStatus.OK);
    }

    @GetMapping(path = "/get-all/{id}")
    public ResponseEntity<List<Favorite>> getAllFavorites(@PathVariable String id){
        return  new ResponseEntity<>(this.favoriteService.getAllFavorites(id), HttpStatus.OK);
    }

    @GetMapping(path = "/remove/{id}")
    public ResponseEntity<Boolean> removeFavorite(@PathVariable("id") String id){
        return new ResponseEntity<>(this.favoriteService.removeFavorite(id), HttpStatus.OK);
    }
}
