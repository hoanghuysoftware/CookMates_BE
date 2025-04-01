package com.cookmates.backend.serviceIMPL;

import com.cookmates.backend.dto.ReviewDTO;
import com.cookmates.backend.exception.DataNotFoundException;
import com.cookmates.backend.model.Recipe;
import com.cookmates.backend.model.Review;
import com.cookmates.backend.model.User;
import com.cookmates.backend.repository.RecipeRepository;
import com.cookmates.backend.repository.ReviewRepository;
import com.cookmates.backend.repository.UserRepository;
import com.cookmates.backend.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewServiceIMPL implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final RecipeRepository recipeRepository;

    @Override
    public List<Review> getReviewByRecipe(Long recipeId) {
        return reviewRepository.getReviewsByRecipeId(recipeId);
    }

    @Override
    public Review addNewReview(ReviewDTO reviewDTO) {
        User user = userRepository.getUserById(reviewDTO.getUserId()).orElseThrow(
                () -> new DataNotFoundException("Not found user with id: " + reviewDTO.getUserId())
        );
        Recipe recipe = recipeRepository.getRecipesById(reviewDTO.getRecipeId()).orElseThrow(
                () -> new DataNotFoundException("Not found recipe with id: " + reviewDTO.getRecipeId())
        );
        Review review = Review.builder()
                .content(reviewDTO.getContent())
                .rating(reviewDTO.getRating())
                .user(user)
                .recipe(recipe)
                .build();
        return reviewRepository.save(review);
    }

    @Override
    public Review updateReview(Long id, ReviewDTO reviewDTO) {
        Review review = reviewRepository.findById(id).orElseThrow(
                () -> new DataNotFoundException("Not found review with id: " + reviewDTO.getId())
        );
        review.setContent(reviewDTO.getContent());
        review.setRating(reviewDTO.getRating());

        return reviewRepository.save(review);
    }

    @Override
    public void deleteReview(Long id) {
        Review review = reviewRepository.findById(id).orElseThrow(
                () -> new DataNotFoundException("Not found review with id: " + id)
        );
        reviewRepository.delete(review);
    }
}
