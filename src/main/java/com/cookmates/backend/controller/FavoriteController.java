package com.cookmates.backend.controller;

import com.cookmates.backend.dto.FavoriteDTO;
import com.cookmates.backend.dto.ResponseMessage;
import com.cookmates.backend.dto.ResponsePagination;
import com.cookmates.backend.model.Favorite;
import com.cookmates.backend.service.FavoriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/favorites")
public class FavoriteController {
    private final FavoriteService favoriteService;

    @GetMapping("/{idUser}")
    public ResponseEntity<ResponsePagination> getFavoriteRecipeByIdUser(@PathVariable Long idUser,
                                                                        @RequestParam(name = "page", defaultValue = "0") int page,
                                                                        @RequestParam(name = "limit", defaultValue = "10") int limit) {
        Pageable pageable = PageRequest.of(page, limit);
        Page<FavoriteDTO> favorites = favoriteService.getFavoriteByUserId(idUser, pageable);
        return new ResponseEntity<>(ResponsePagination.builder()
                .status(true)
                .message("Get favorite recipe by id: "+idUser)
                .totalPages(favorites.getTotalPages())
                .totalElements((int) favorites.getTotalElements())
                .data(favorites.getContent())
                .build(), HttpStatus.OK);
    }

    @PostMapping("/user/{idUser}/recipe/{idRecipe}")
    public ResponseEntity<ResponseMessage> doAddFavorites(@PathVariable Long idUser,
                                                          @PathVariable Long idRecipe){
        return new ResponseEntity<>(ResponseMessage.builder()
                .status(true)
                .message("Add favorite recipe by id: "+idUser)
                .timestamp(new Date())
                .data(favoriteService.addFavorite(idUser, idRecipe))
                .build(), HttpStatus.OK);
    }

    @DeleteMapping()
    public ResponseEntity<ResponseMessage> deleteFavoriteRecipe(@RequestParam(name = "idFavorite")Long idFavorite){
        favoriteService.deleteFavoriteByUserId(idFavorite);
        return new ResponseEntity<>(ResponseMessage.builder()
                .status(true)
                .message("Delete favorite recipe by id: "+idFavorite)
                .timestamp(new Date())
                .build(), HttpStatus.OK);
    }
}
