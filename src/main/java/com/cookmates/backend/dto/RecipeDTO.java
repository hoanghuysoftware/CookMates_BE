package com.cookmates.backend.dto;

import com.cookmates.backend.dto.CategoryDTO;
import com.cookmates.backend.dto.StepDTO;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RecipeDTO {
    private Long id;

    @NotBlank(message = "Title cannot be blank")
    @Size(max = 255, message = "Title must be less than 255 characters")
    private String title;

    @Size(max = 500, message = "Description must be less than 500 characters")
    private String description;

    @Min(value = 1, message = "Cook time must be at least 1 minute")
    private int cookTime;

    @Min(value = 1, message = "Prep time must be at least 1 minute")
    private int prepTime;

    @Min(value = 1, message = "Servings must be at least 1")
    private int servings;

    private String status;

    private List<CategoryDTO> categories;
    private List<StepDTO> steps;
}
