package com.cookmates.backend.serviceIMPL;

import com.cookmates.backend.dto.CategoryDTO;
import com.cookmates.backend.exception.DataNotFoundException;
import com.cookmates.backend.exception.ExistingDataException;
import com.cookmates.backend.model.Category;
import com.cookmates.backend.repository.CategoryRepository;
import com.cookmates.backend.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceIMPL implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> findByName(String name) {
        return categoryRepository.getCategoryByName(name);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(long id) {
        return categoryRepository.findById(id).orElseThrow(
                () -> new DataNotFoundException("Category not found with id " + id)
        );
    }

    @Override
    public Category save(CategoryDTO categoryDTO) {
        Category category = Category.builder()
                .name(categoryDTO.getName())
                .build();
        return categoryRepository.save(category);
    }

    @Override
    public Category update(Long id, CategoryDTO categoryDTO) {
        Category existingCategory = categoryRepository.findById(id).orElseThrow(
                () -> new DataNotFoundException("Category not found with id " + id)
        );
        boolean checkName =  categoryRepository.existsByName(categoryDTO.getName());
        if (checkName) {
            throw new ExistingDataException("Already exists category with name " + categoryDTO.getName());
        }
        existingCategory.setName(categoryDTO.getName());
        categoryRepository.save(existingCategory);
        return categoryRepository.save(existingCategory);
    }

    @Override
    public void delete(Long id) {
        Category existingCategory = categoryRepository.findById(id).orElseThrow(
                () -> new DataNotFoundException("Category not found with id " + id)
        );
        categoryRepository.delete(existingCategory);
    }
}
