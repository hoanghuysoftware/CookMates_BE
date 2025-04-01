package com.cookmates.backend.repository;

import com.cookmates.backend.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> getReviewsByRecipeId(Long id);
}
