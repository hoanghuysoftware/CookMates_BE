package com.cookmates.backend.service;

import com.cookmates.backend.dto.ReviewDTO;
import com.cookmates.backend.model.Review;

import java.util.List;

public interface ReviewService {
    List<Review> getReviewByRecipe(Long recipeId);
    Review addNewReview(ReviewDTO reviewDTO);
    Review updateReview(Long id, ReviewDTO reviewDTO);
    void deleteReview(Long id);
}
