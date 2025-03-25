package com.cookmates.backend.repository;

import com.cookmates.backend.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface    IngredientRepository extends JpaRepository<Ingredient, Long> {
    Optional<Ingredient> getIngredientById(Long id);
    Optional<Ingredient> getIngredientByName(String name);
}
