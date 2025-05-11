package com.cookmates.backend.repository;

import com.cookmates.backend.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    @Query("select r from Review  r where r.recipe.id = :id order by r.createdAt DESC")
    List<Review> getReviewsByRecipeId(@Param("id") Long id);
}
