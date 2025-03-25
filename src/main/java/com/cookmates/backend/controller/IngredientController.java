package com.cookmates.backend.controller;

import com.cookmates.backend.dto.IngredientDTO;
import com.cookmates.backend.dto.ResponseMessage;
import com.cookmates.backend.repository.IngredientRepository;
import com.cookmates.backend.service.IngredientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api/v1/ingredients")
@RequiredArgsConstructor
public class IngredientController {
    private final IngredientService ingredientService;

    @PostMapping
    public ResponseEntity<ResponseMessage> doAddIngredient(@RequestBody IngredientDTO ingredientDTO) {
        return new ResponseEntity<>(ResponseMessage.builder()
                .status(true)
                .message("Ingredient added successfully !")
                .timestamp(new Date())
                .data(ingredientService.addNewIngredient(ingredientDTO.getName()))
                .build(), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<ResponseMessage> getIngredients() {
        return new ResponseEntity<>(ResponseMessage.builder()
                .status(true)
                .message("Get all ingredients successfully !")
                .timestamp(new Date())
                .data(ingredientService.getIngredients())
                .build(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseMessage> getIngredientById(@PathVariable Long id) {
        return new ResponseEntity<>(ResponseMessage.builder()
                .status(true)
                .message("Get ingredients successfully with id: "+id)
                .timestamp(new Date())
                .data(ingredientService.getIngredientById(id))
                .build(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseMessage> updateIngredient(@PathVariable Long id, @RequestBody IngredientDTO ingredientDTO) {
        return new ResponseEntity<>(ResponseMessage.builder()
                .status(true)
                .message("Update ingredients successfully with id: "+id)
                .timestamp(new Date())
                .data(ingredientService.updateIngredient(id, ingredientDTO))
                .build(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseMessage> deleteIngredient(@PathVariable Long id) {
        ingredientService.deleteIngredient(id);
        return new ResponseEntity<>(ResponseMessage.builder()
                .status(true)
                .message("Delete ingredients successfully with id: "+id)
                .timestamp(new Date())
                .build(), HttpStatus.OK);
    }
}
