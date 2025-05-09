package com.cookmates.backend.dto;

import com.cookmates.backend.model.Recipe;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RecipeResponseDTO {
    private Long id;
    private String title;
    private String description;
    private int cookTime;
    private int prepTime;
    private int servings;
    private String status;
    private String thumbnail;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private UserDTO user;
    private List<CategoryDTO> categories;
    private List<StepDTO> steps; // Mỗi Step có ảnh đi kèm
    private List<IngredientResponse> ingredients;
    private List<FavoriteDTO> favorites;


    public static RecipeResponseDTO fromToRecipeResponseDTO(Recipe recipe) {
        UserDTO userDTO = UserDTO.builder()
                .id(recipe.getUser().getId())
                .username(recipe.getUser().getUsername())
                .email(recipe.getUser().getEmail())
                .fullName(recipe.getUser().getFullName())
                .roleName(recipe.getUser().getRole().name())
                .status(recipe.getUser().getStatus().name())
                .phoneNumber(recipe.getUser().getPhoneNumber())
                .build();
        List<CategoryDTO> categoryDTOS = new ArrayList<>();
        recipe.getCategories().forEach(category -> {
            categoryDTOS.add(CategoryDTO.builder()
                            .id(category.getId())
                            .name(category.getName())
                    .build());
        });
        List<IngredientResponse> ingredientResponses = new ArrayList<>();
        recipe.getRecipeIngredients().forEach(ingredient -> {
            ingredientResponses.add(IngredientResponse.builder()
                            .id(ingredient.getId())
                            .name(ingredient.getIngredient().getName())
                            .unit(ingredient.getUnit().name())
                            .quantity(ingredient.getQuantity())
                    .build());
        });
        List<StepDTO> stepDTOS = new ArrayList<>();
        recipe.getSteps().forEach(step -> {
            stepDTOS.add(StepDTO.builder()
                            .id(step.getId())
                            .title(step.getTitle())
                            .stepNumber(step.getStepNumber())
                            .description(step.getDescription())
                            .imageUrl(step.getImage().getImageUrl())
                    .build());
        });
        List<FavoriteDTO> favoriteDTOS = new ArrayList<>();
        recipe.getFavorites().forEach(favorite -> {
            favoriteDTOS.add(FavoriteDTO.builder()
                            .id(favorite.getId())
                            .recipeId(recipe.getId())
                            .userId(favorite.getUser().getId())
                    .build());
        });
        return RecipeResponseDTO.builder()
                .id(recipe.getId())
                .title(recipe.getTitle())
                .thumbnail(recipe.getThumbnail())
                .description(recipe.getDescription())
                .cookTime(recipe.getCookTime())
                .prepTime(recipe.getPrepTime())
                .servings(recipe.getServings())
                .status(recipe.getStatus().name())
                .createdAt(recipe.getCreatedAt())
                .updatedAt(recipe.getUpdatedAt())
                .user(userDTO)
                .categories(categoryDTOS)
                .ingredients(ingredientResponses)
                .steps(stepDTOS)
                .favorites(favoriteDTOS)
                .build();
    }
}
