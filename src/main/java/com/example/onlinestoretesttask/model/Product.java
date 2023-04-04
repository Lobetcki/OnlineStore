package com.example.onlinestoretesttask.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;
import java.util.Set;

@Entity
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Lob
    private String description;
    private Instant creationDate = Instant.now();
    private Instant modificationDate;
    @ManyToMany(mappedBy = "category", fetch = FetchType.EAGER)
    private Set<Category> category;

}
