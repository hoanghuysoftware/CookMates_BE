package com.cookmates.backend.controller;

import com.cookmates.backend.dto.CategoryDTO;
import com.cookmates.backend.dto.ResponseMessage;
import com.cookmates.backend.model.Category;
import com.cookmates.backend.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/categories")
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<ResponseMessage> createCategory(@RequestPart("category") CategoryDTO categoryDTO,
                                                          @RequestPart(value = "image", required = false) MultipartFile image) {
        Category category = categoryService.save(categoryDTO, image);
        return new ResponseEntity<>(ResponseMessage.builder()
                .status(true)
                .message("Category created successfully !")
                .timestamp(new Date())
                .data(category)
                .build(), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<ResponseMessage> getAllCategories() {
        return new ResponseEntity<>(ResponseMessage.builder()
                .status(true)
                .message("Get all categories successfully !")
                .timestamp(new Date())
                .data(categoryService.findAll())
                .build(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseMessage> getCategoryById(@PathVariable long id) {
        return new ResponseEntity<>(ResponseMessage.builder()
                .status(true)
                .message("Get category by ID successfully !")
                .timestamp(new Date())
                .data(categoryService.findById(id))
                .build(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseMessage> updateCategory(@PathVariable long id, @RequestBody CategoryDTO categoryDTO) {
        Category categoryUpdate = categoryService.update(id, categoryDTO);
        return new ResponseEntity<>(ResponseMessage.builder()
                .status(true)
                .message("Update category successfully !")
                .timestamp(new Date())
                .data(categoryUpdate)
                .build(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseMessage> deleteCategory(@PathVariable long id) {
        categoryService.delete(id);
        return new ResponseEntity<>(ResponseMessage.builder()
                .status(true)
                .message("Delete category successfully !")
                .timestamp(new Date())
                .build(), HttpStatus.OK);
    }
}
