package com.cookmates.backend.controller;

import com.cookmates.backend.dto.ResponseMessage;
import com.cookmates.backend.dto.ReviewDTO;
import com.cookmates.backend.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/review")
public class ReviewController {
    private final ReviewService reviewService;

    @PostMapping()
    public ResponseEntity<ResponseMessage> addReview(@RequestBody ReviewDTO reviewDTO) {
        return new ResponseEntity<>(ResponseMessage.builder()
                .status(true)
                .message("Add review successfully")
                .timestamp(new Date())
                .data(reviewService.addNewReview(reviewDTO))
                .build(), HttpStatus.CREATED);
    }

    @GetMapping("/{idRecipe}")
    public ResponseEntity<ResponseMessage> getReviewById(@PathVariable Long idRecipe) {
        return new ResponseEntity<>(ResponseMessage.builder()
                .status(true)
                .message("Get review by id: "+idRecipe)
                .timestamp(new Date())
                .data(reviewService.getReviewByRecipe(idRecipe))
                .build(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseMessage> updateReview(@PathVariable Long id, @RequestBody ReviewDTO reviewDTO) {
        return new ResponseEntity<>(ResponseMessage.builder()
                .status(true)
                .message("Update review by id: "+id)
                .timestamp(new Date())
                .data(reviewService.updateReview(id, reviewDTO))
                .build(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseMessage> deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
        return new ResponseEntity<>(ResponseMessage.builder()
                .status(true)
                .message("Delete review by id: "+id)
                .timestamp(new Date())
                .build(), HttpStatus.OK);
    }
}
