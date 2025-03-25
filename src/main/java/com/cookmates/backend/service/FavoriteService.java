package com.cookmates.backend.service;

import com.cookmates.backend.model.Favorite;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FavoriteService {
    Favorite addFavorite(Long userId, Long recipeId);
    Page<Favorite> getFavoriteByUserId(Long userId, Pageable pageable);
    void deleteFavoriteByUserId(Long favoriteId);
}
