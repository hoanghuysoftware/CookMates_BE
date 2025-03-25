package com.cookmates.backend.serviceIMPL;

import com.cookmates.backend.exception.DataNotFoundException;
import com.cookmates.backend.model.Favorite;
import com.cookmates.backend.model.Recipe;
import com.cookmates.backend.model.User;
import com.cookmates.backend.repository.FavoriteRepository;
import com.cookmates.backend.repository.RecipeRepository;
import com.cookmates.backend.repository.UserRepository;
import com.cookmates.backend.service.FavoriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FavoriteServiceIMPL implements FavoriteService {
    private final FavoriteRepository favoriteRepository;
    private final UserRepository userRepository;
    private final RecipeRepository recipeRepository;

    @Override
    public Favorite addFavorite(Long userId, Long recipeId) {
        User user = userRepository.getUserById(userId).orElseThrow(
                () -> new DataNotFoundException("Not found user with id " + userId)
        );
        Recipe recipe = recipeRepository.getRecipesById(recipeId).orElseThrow(
                () -> new DataNotFoundException("Not found user with id " + userId)
        );;
        Favorite favorite = Favorite.builder()
                .user(user)
                .recipe(recipe)
                .build();
        return favoriteRepository.save(favorite);
    }

    @Override
    public Page<Favorite> getFavoriteByUserId(Long userId, Pageable pageable) {
        List<Favorite> favorites = favoriteRepository.getFavoritesByUserId(userId);
        return new PageImpl<>(favorites);
    }

    @Override
    public void deleteFavoriteByUserId(Long favoriteId) {
        Favorite favorite = favoriteRepository.getFavoriteById(favoriteId).orElseThrow(
                () -> new DataNotFoundException("Not found favorite with id " + favoriteId)
        );
        favoriteRepository.delete(favorite);
    }
}
