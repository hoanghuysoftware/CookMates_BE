package com.cookmates.backend.service;

import com.cookmates.backend.dto.RecipeDTO;
import com.cookmates.backend.model.Recipe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RecipeService {
    Recipe addNewRecipe(RecipeDTO recipeDTO);
    Page<Recipe> getAllRecipesByActive(Pageable pageable, boolean active);
    Page<Recipe> getAllRecipes(Pageable pageable);
    Page<Recipe> getRecipesByUserId(Long userId, Pageable pageable);
    Recipe updateRecipe(Long id, RecipeDTO recipeDTO);
    void deleteRecipe(Long id);
}
