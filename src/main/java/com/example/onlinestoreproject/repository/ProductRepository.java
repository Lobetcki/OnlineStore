package com.example.onlinestoreproject.repository;

import com.example.onlinestoreproject.model.Product;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long>, JpaSpecificationExecutor<Product> {
    @EntityGraph(attributePaths = {"category"})
    List<Product> findFetchAll(Sort sort);


}
