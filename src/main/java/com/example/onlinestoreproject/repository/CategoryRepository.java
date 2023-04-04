package com.example.onlinestoreproject.repository;

import com.example.onlinestoreproject.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
