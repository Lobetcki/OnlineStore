package com.example.onlinestoreproject.dto;

import com.example.onlinestoreproject.model.Product;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.Instant;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

@Data
public class ProductDTO {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;
    private String name;
    private String description;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Instant creationDate = Instant.now();
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Instant modificationDate = Instant.now();
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
        product.setName(this.getName());
        product.setDescription(this.getDescription());
        product.setCreationDate(this.getCreationDate());
        product.setModificationDate(this.getModificationDate());
        return product;
    }
}
