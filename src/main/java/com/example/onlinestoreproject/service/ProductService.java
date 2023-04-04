package com.example.onlinestoreproject.service;

import com.example.onlinestoreproject.dto.ProductDTO;
import com.example.onlinestoreproject.model.Product;
import com.example.onlinestoreproject.repository.ProductRepository;
import com.example.onlinestoreproject.repository.spec.Specif;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Join;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductDTO> findProduct(Boolean sort) {
        List<Product> products = productRepository.findFetchAll(
                sort ?
                        Sort.by(Sort.Direction.DESC, "createdDate") :
                        Sort.unsorted());
        return products.stream().map(ProductDTO::of).collect(Collectors.toList());
    }

    public ProductDTO save(ProductDTO product) {
        productRepository.save(product.to());
        return product;
    }

    public ProductDTO update(ProductDTO product) {
        productRepository.save(product.to());
        return product;
    }

    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    //    TODO: inpliment
    public List<ProductDTO> search(String name, String description, String categoryName) {
        List<Product> products = productRepository.findAll(Specif.byName(name).and(Specif.byDescription(description)).and(Specif.byCategory(categoryName)));
        //    TODO: add mapping plz
        return null;
    }
}
