package com.cookmates.backend.service;

import com.cookmates.backend.dto.CategoryDTO;
import com.cookmates.backend.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findByName(String name);
    List<Category> findAll();
    Category findById(long id);
    Category save(CategoryDTO categoryDTO);
    Category update(Long id, CategoryDTO categoryDTO);
    void delete(Long id);
}
