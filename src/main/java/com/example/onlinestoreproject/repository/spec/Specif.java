package com.example.onlinestoreproject.repository.spec;

import com.example.onlinestoreproject.model.Category;
import com.example.onlinestoreproject.model.Product;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;

public class Specif {
    public static Specification<Product> byName(String name){
        return (root, query, criteriaBuilder) -> {
            if (name == null || name.isBlank()){
                return criteriaBuilder.conjunction();
            }
            root.join("categories", JoinType.LEFT);
            root.fetch("categories");
            return criteriaBuilder.like(root.get("name"), "%" + name + "%");
        };
    }

    public static Specification<Product> byDescription(String desc){
        return (root, query, criteriaBuilder) -> {
            if (desc == null || desc.isBlank()){
                return criteriaBuilder.conjunction();
            }
            root.join("categories", JoinType.LEFT);
            root.fetch("categories");
            return criteriaBuilder.like(root.get("description"), "%" + desc + "%");
        };
    }

    public static Specification<Product> byCategory(String category){
        return (root, query, criteriaBuilder) -> {
            if (category == null || category.isBlank()){
                return criteriaBuilder.conjunction();
            }
            Join<Product, Category> categoryJoin = root.join("categories", JoinType.LEFT);
            root.fetch("categories");
            return criteriaBuilder.equal(categoryJoin.get("name"), category);
        };
    }
}
