package com.cookmates.backend.repository;

import com.cookmates.backend.model.Favorite;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
    List<Favorite> getFavoritesByUserId(Long userId);
    Optional<Favorite> getFavoriteById(Long id);
    Page<Favorite> findFavoritesByUserId(Long userId, Pageable pageable);
}
