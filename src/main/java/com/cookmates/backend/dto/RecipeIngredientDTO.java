package com.cookmates.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RecipeIngredientDTO {
    private Long recipeId;
    private Long ingredientId;
    private String nameIngredient;
    private int quantity;
    private String unit;
}
