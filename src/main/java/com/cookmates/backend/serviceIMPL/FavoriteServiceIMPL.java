package com.cookmates.backend.serviceIMPL;

import com.cookmates.backend.dto.FavoriteDTO;
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
import org.springframework.transaction.annotation.Transactional;

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
        );
        Favorite favorite = Favorite.builder()
                .user(user)
                .recipe(recipe)
                .build();
        return favoriteRepository.save(favorite);
    }

    @Override
    public Page<FavoriteDTO> getFavoriteByUserId(Long userId, Pageable pageable) {

        Page<Favorite> favoriteDTOS = favoriteRepository.findFavoritesByUserId(userId, pageable);
        return favoriteDTOS.map(FavoriteDTO::toFavoriteDTO);
    }

    @Transactional
    @Override
    public void deleteFavoriteByUserId(Long userId, Long recipeId) {
        favoriteRepository.deleteFavoriteByUserIdAndRecipeId(userId, recipeId);
    }
}
