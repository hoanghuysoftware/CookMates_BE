package com.cookmates.backend.dto;

import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StepDTO {
    private Long id;

    @Min(value = 1, message = "Step number must be at least 1")
    private int stepNumber;

    private String title;

    @NotBlank(message = "Description cannot be blank")
//    @Size(max = 1000, message = "Description must be less than 1000 characters")
    private String description;

    private String imageUrl; // File ảnh dành cho  từng bước
}
