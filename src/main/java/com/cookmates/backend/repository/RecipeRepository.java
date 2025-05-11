package com.cookmates.backend.repository;

import com.cookmates.backend.enums.RecipeStatus;
import com.cookmates.backend.model.Recipe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    List<Recipe> getAllRecipesByUserId(Long userId);
    Optional<Recipe> getRecipesById(Long id);
    Page<Recipe> findByTitleContaining(String title, Pageable pageable);
    Page<Recipe> findRecipesByStatus(RecipeStatus recipeStatus, Pageable pageable);
}
