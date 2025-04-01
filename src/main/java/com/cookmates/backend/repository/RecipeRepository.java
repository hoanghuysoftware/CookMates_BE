package com.cookmates.backend.repository;

import com.cookmates.backend.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    List<Recipe> getAllRecipesByUserId(Long userId);
    Optional<Recipe> getRecipesById(Long id);
}
