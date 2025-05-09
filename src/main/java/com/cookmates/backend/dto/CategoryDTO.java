package com.cookmates.backend.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {
    private long id;
    @NotBlank(message = "Category name cannot be blank")
    @Size(max = 100, message = "Category name must be less than 100 characters")
    private String name;

    private String imageUrl;
}
