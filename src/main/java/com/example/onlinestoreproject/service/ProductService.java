package com.example.onlinestoreproject.service;

import com.example.onlinestoreproject.dto.CategoryDTO;
import com.example.onlinestoreproject.dto.ProductDTO;
import com.example.onlinestoreproject.model.Category;
import com.example.onlinestoreproject.model.Product;
import com.example.onlinestoreproject.repository.CategoryRepository;
import com.example.onlinestoreproject.repository.ProductRepository;
import com.example.onlinestoreproject.repository.spec.Specif;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<ProductDTO> findProduct(Boolean sort) {
        List<Product> products = productRepository.findFetchAllBy(
                sort ?
                        Sort.by(Sort.Direction.DESC, "creationDate") :
                        Sort.unsorted());
        return products.stream().map(ProductDTO::of).collect(Collectors.toList());
    }

    private Product saveAndUpdate(ProductDTO productDTO) {
        Product product = productDTO.to();
        List<Long> categoriesId = productDTO.getCategories().stream()
                .map(CategoryDTO::getId)
                .collect(Collectors.toList());
        List<Category> category = categoryRepository.findAllById(categoriesId);
        category.forEach(product::addCategory);
        return product;
    }

    public ProductDTO save(ProductDTO productDTO) {
        Product product = saveAndUpdate(productDTO);
        product = productRepository.save(product);
        return ProductDTO.of(product);
    }

    public ProductDTO update(Long id, ProductDTO productDTO) {
        Product product = saveAndUpdate(productDTO);
        product.setId(id);
        product = productRepository.save(product);
        return ProductDTO.of(product);
    }

    @Transactional
    public void delete(Long id) {
        productRepository.deleteById(id);
    }
    public List<ProductDTO> search(String name, String description, String categoryName) {
        List<Product> products = productRepository
                .findAll(Specif.byName(name)
                        .and(Specif.byDescription(description))
                        .and(Specif.byCategory(categoryName)));
        return products.stream().map(ProductDTO::of).collect(Collectors.toList());
    }
}
