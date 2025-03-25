package com.cookmates.backend.serviceIMPL;

import com.cookmates.backend.dto.IngredientDTO;
import com.cookmates.backend.dto.RecipeDTO;
import com.cookmates.backend.dto.RecipeIngredientDTO;
import com.cookmates.backend.dto.StepDTO;
import com.cookmates.backend.enums.RecipeStatus;
import com.cookmates.backend.enums.UnitName;
import com.cookmates.backend.exception.DataNotFoundException;
import com.cookmates.backend.model.*;
import com.cookmates.backend.repository.*;
import com.cookmates.backend.service.RecipeService;
import com.cookmates.backend.utils.ImageUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RecipeServiceIMPL implements RecipeService {
    private final RecipeRepository recipeRepository;
    private final StepRepository stepRepository;
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;
    private final IngredientRepository ingredientRepository;
    private final ImageUtils imageUtils;


    @Override
    @Transactional
    public Recipe addNewRecipe(RecipeDTO recipeDTO) {
        // check user existing
        User user = userRepository.getUserById(recipeDTO.getUserId())
                .orElseThrow(() -> new DataNotFoundException("User not found with id: " + recipeDTO.getUserId()));

        // check category existing
        List<Category> categories = new ArrayList<>();
        for (Long idCategory : recipeDTO.getCategories()) {
            Category category = categoryRepository.findById(idCategory)
                    .orElseThrow(() -> new DataNotFoundException("Category not found with id: " + idCategory));
            categories.add(category);
        }

        // create init recipe
        Recipe recipe = Recipe.builder()
                .title(recipeDTO.getTitle())
                .description(recipeDTO.getDescription())
                .cookTime(recipeDTO.getCookTime())
                .prepTime(recipeDTO.getPrepTime())
                .servings(recipeDTO.getServings())
                .status(RecipeStatus.PENDING)
                .user(user)
                .categories(categories)
                .build();

        // find and add ingredient for recipe
        List<RecipeIngredient> recipeIngredients = new ArrayList<>();
        for (RecipeIngredientDTO recipeIngredientDTO : recipeDTO.getIngredients()) {
            // Tim ingredient neu khong co thi them moi
            Ingredient ingredient = ingredientRepository.findById(recipeIngredientDTO.getIngredientId()).or(() -> {
                Ingredient newIngredient = ingredientRepository.save(
                        Ingredient.builder()
                                .name(recipeIngredientDTO.getNameIngredient())
                                .build());
                return Optional.of(newIngredient);
            }).get();
            RecipeIngredient recipeIngredient = RecipeIngredient.builder()
                    .recipe(recipe)
                    .ingredient(ingredient)
                    .quantity(recipeIngredientDTO.getQuantity())
                    .unit(UnitName.valueOf(recipeIngredientDTO.getUnit()))
                    .build();

            recipeIngredients.add(recipeIngredient);
        }
        recipe.setRecipeIngredients(recipeIngredients);

        // Add step into recipe
        List<Step> steps = new ArrayList<>();
        for(StepDTO stepDTO : recipeDTO.getSteps()){
            Step step = Step.builder()
                    .recipe(recipe)
                    .description(stepDTO.getDescription())
                    .stepNumber(stepDTO.getStepNumber())
                    .build();
            if (stepDTO.getFile() != null) {
                Image image = imageUtils.uploadImage(stepDTO.getFile(), step);
                step.setImage(image);
            }
            steps.add(step);
        }
        recipe.setSteps(steps);

        return recipeRepository.save(recipe);
    }

    @Override
    public Page<Recipe> getAllRecipes(Pageable pageable) {
        return recipeRepository.findAll(pageable);
    }

    @Override
    public Page<Recipe> getAllRecipesByActive(Pageable pageable, boolean active) {
        return null;
//        return recipeRepository.findByStatus(active ? RecipeStatus.APPROVED : RecipeStatus.PENDING, pageable);
    }

    @Override
    public Page<Recipe> getRecipesByUserId(Long userId, Pageable pageable) {
        List<Recipe> recipes = recipeRepository.getAllRecipesByUserId(userId);
        return new PageImpl<>(recipes, pageable, recipes.size());
    }

    @Override
    @Transactional
    public Recipe updateRecipe(Long id, RecipeDTO recipeDTO) {
        Recipe recipe = recipeRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Recipe not found with id: " + id));

        recipe.setTitle(recipeDTO.getTitle());
        recipe.setDescription(recipeDTO.getDescription());
        recipe.setCookTime(recipeDTO.getCookTime());
        recipe.setPrepTime(recipeDTO.getPrepTime());
        recipe.setServings(recipeDTO.getServings());
        recipe.setStatus(RecipeStatus.valueOf(recipeDTO.getStatus()));

        List<Category> categories = recipeDTO.getCategories().stream()
                .map(categoryId -> categoryRepository.findById(categoryId)
                        .orElseThrow(() -> new DataNotFoundException("Category not found with id: " + categoryId)))
                .toList();
        recipe.setCategories(categories);

        stepRepository.deleteAll(recipe.getSteps());
        List<Step> steps = recipeDTO.getSteps().stream()
                .map(stepDTO -> {
                    Step step = Step.builder()
                            .recipe(recipe)
                            .description(stepDTO.getDescription())
                            .stepNumber(stepDTO.getStepNumber())
                            .build();
                    if (stepDTO.getFile() != null) {
                        Image image = imageUtils.uploadImage(stepDTO.getFile(), step);
                        step.setImage(image);
                    }
                    return step;
                }).toList();
        recipe.setSteps(steps);

        return recipeRepository.save(recipe);
    }

    @Override
    @Transactional
    public void deleteRecipe(Long id) {
        Recipe recipe = recipeRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Recipe not found with id: " + id));
        recipeRepository.delete(recipe);
    }
}
