package com.cookmates.backend.service;

import com.cookmates.backend.dto.IngredientDTO;
import com.cookmates.backend.model.Ingredient;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IngredientService {
    List<Ingredient> getIngredients();
    Ingredient getIngredientById(Long id);
    Ingredient addNewIngredient(String name);
    Ingredient updateIngredient(Long id, IngredientDTO ingredient);
    void deleteIngredient(Long id);

}
