package com.cookmates.backend.dto;

import lombok.*;

import java.time.LocalDateTime;
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
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private UserDTO user;
    private List<CategoryDTO> categories;
    private List<StepDTO> steps; // Mỗi Step có ảnh đi kèm
}
