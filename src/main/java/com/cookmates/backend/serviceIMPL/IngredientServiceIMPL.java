package com.cookmates.backend.serviceIMPL;

import com.cookmates.backend.dto.IngredientDTO;
import com.cookmates.backend.exception.DataNotFoundException;
import com.cookmates.backend.model.Ingredient;
import com.cookmates.backend.repository.IngredientRepository;
import com.cookmates.backend.service.IngredientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IngredientServiceIMPL implements IngredientService {
    private final IngredientRepository ingredientRepository;

    @Override
    public List<Ingredient> getIngredients() {
        return ingredientRepository.findAll();
    }

    @Override
    public Ingredient getIngredientById(Long id) {
        return ingredientRepository.getIngredientById(id).orElseThrow(
                () -> new DataNotFoundException("Ingredient with id " + id + " not found")
        );
    }

    @Override
    public Ingredient addNewIngredient(String name) {
        Ingredient ingredient = Ingredient.builder()
                .name(name)
                .build();
        return ingredientRepository.save(ingredient);
    }

    @Override
    public Ingredient updateIngredient(Long id, IngredientDTO ingredient) {
        Ingredient existingIngredient = getIngredientById(id);
        existingIngredient.setName(ingredient.getName());
        return ingredientRepository.save(existingIngredient);
    }

    @Override
    public void deleteIngredient(Long id) {
        Ingredient existingIngredient = getIngredientById(id);
        ingredientRepository.delete(existingIngredient);
    }
}
