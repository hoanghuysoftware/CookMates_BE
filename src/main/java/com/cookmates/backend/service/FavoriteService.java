package com.cookmates.backend.service;

import com.cookmates.backend.dto.FavoriteDTO;
import com.cookmates.backend.model.Favorite;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FavoriteService {
    Favorite addFavorite(Long userId, Long recipeId);
    Page<FavoriteDTO> getFavoriteByUserId(Long userId, Pageable pageable);
    void deleteFavoriteByUserId(Long userId, Long recipeId);
}
