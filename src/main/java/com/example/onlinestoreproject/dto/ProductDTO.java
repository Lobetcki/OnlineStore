package com.example.onlinestoreproject.dto;

import com.example.onlinestoreproject.model.Category;
import com.example.onlinestoreproject.model.Product;
import lombok.Data;

import java.time.Instant;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toSet;

@Data
public class ProductDTO {
    private Long id;
    private String name;
    private String description;
    private Instant creationDate;
    private Instant modificationDate;
    private Set<CategoryDTO> categories;

    public static ProductDTO of(Product product) {
        ProductDTO dto = new ProductDTO();
        dto.setId(product.getId());
        dto.setName(product.getName());
        dto.setDescription(product.getDescription());
        dto.setCreationDate(product.getCreationDate());
        dto.setModificationDate(product.getModificationDate());
        dto.setCategories(product.getCategories().stream().map(CategoryDTO::of).collect(toSet()));
        return dto;
    }

    public Product to() {
        Product product = new Product();
        product.setId(this.getId());
        product.setName(this.getName());
        product.setDescription(this.getDescription());
        product.setCreationDate(this.getCreationDate());
        product.setModificationDate(this.getModificationDate());
        product.setCategories(this.getCategories().stream().map(CategoryDTO::to).collect(toSet()));
        return product;
    }
}
