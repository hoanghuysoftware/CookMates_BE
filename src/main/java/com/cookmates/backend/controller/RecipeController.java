package com.cookmates.backend.controller;

import com.cookmates.backend.dto.RecipeDTO;
import com.cookmates.backend.dto.RecipeResponseDTO;
import com.cookmates.backend.dto.ResponseMessage;
import com.cookmates.backend.dto.ResponsePagination;
import com.cookmates.backend.model.Recipe;
import com.cookmates.backend.service.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/recipe")
public class RecipeController {
    private final RecipeService recipeService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ResponseMessage> createRecipe(@RequestPart("recipe") RecipeDTO recipeDTO,
                                                        @RequestPart(value = "stepFiles", required = false) List<MultipartFile> stepFiles) {
        return new ResponseEntity<>(ResponseMessage.builder()
                .status(true)
                .message("Recipe created successfully !")
                .timestamp(new Date())
                .data(recipeService.addNewRecipe(recipeDTO, stepFiles))
                .build(), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<ResponsePagination> getAllRecipe(@RequestParam(name = "page", defaultValue = "0") int page,
                                                           @RequestParam(name = "limit", defaultValue = "10")int limit) {
        Pageable pageable = PageRequest.of(page, limit);
        Page<RecipeResponseDTO> result = recipeService.getAllRecipes(pageable);
        return new ResponseEntity<>(ResponsePagination.builder()
                .status(true)
                .message("Recipe get successfully !")
                .totalElements((int) result.getTotalElements())
                .totalPages((int) result.getTotalPages())
                .data(result.getContent())
                .build(), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseMessage> getRecipeById(@PathVariable Long id) {
        return new ResponseEntity<>(ResponseMessage.builder()
                .status(true)
                .message("Recipe get successfully !")
                .timestamp(new Date())
                .data(recipeService.getRecipeById(id))
                .build(),HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ResponseMessage> updateStatusRecipe(@PathVariable Long id,
                                                              @RequestParam(name = "status") String status) {
        return new ResponseEntity<>(ResponseMessage.builder()
                .status(true)
                .message("Update status successfully !")
                .timestamp(new Date())
                .data(recipeService.updateStatusRecipe(id, status))
                .build(),HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<ResponsePagination> doSearch(@RequestParam("value") String value,
                                                       @RequestParam(name = "page", defaultValue = "0") int page,
                                                       @RequestParam(name = "limit", defaultValue = "10")int limit){
        Pageable pageable = PageRequest.of(page, limit);
        Page<RecipeResponseDTO> result = recipeService.searchRecipeByTitle(value, pageable);
        return new ResponseEntity<>(ResponsePagination.builder()
                .status(true)
                .message("Recipe search successfully !")
                .totalPages((int) result.getTotalPages())
                .totalElements((int) result.getTotalElements())
                .data(result.getContent())
                .build(), HttpStatus.OK);
    }
}
