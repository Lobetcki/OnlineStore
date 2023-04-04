package com.example.onlinestoreproject.service;

import com.example.onlinestoreproject.dto.CategoryDTO;
import com.example.onlinestoreproject.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryDTO> findAll() {
        return categoryRepository.findAll().stream().map(CategoryDTO::of).collect(Collectors.toList());
    }
}
