package com.cookmates.backend.service;

import com.cookmates.backend.dto.RecipeDTO;
import com.cookmates.backend.dto.RecipeResponseDTO;
import com.cookmates.backend.enums.RecipeStatus;
import com.cookmates.backend.model.Recipe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface RecipeService {
    Recipe addNewRecipe(RecipeDTO recipeDTO, List<MultipartFile> stepFiles);
    Page<RecipeResponseDTO> getAllRecipesByActive(Pageable pageable, RecipeStatus status);
    Page<RecipeResponseDTO> getAllRecipes(Pageable pageable);
    RecipeResponseDTO getRecipeById(Long id);
    RecipeResponseDTO updateStatusRecipe(Long id, String status);
    Page<Recipe> getRecipesByUserId(Long userId, Pageable pageable);
    Recipe updateRecipe(Long id, RecipeDTO recipeDTO);
    void deleteRecipe(Long id);
    Page<RecipeResponseDTO> searchRecipeByTitle(String title, Pageable pageable);

}
