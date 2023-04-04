package com.example.onlinestoreproject.controller;

import com.example.onlinestoreproject.dto.CategoryDTO;
import com.example.onlinestoreproject.service.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<CategoryDTO> findAll(){
        return categoryService.findAll();
    }
}
