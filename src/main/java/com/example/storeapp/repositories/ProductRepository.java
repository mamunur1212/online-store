package com.example.storeapp.repositories;

import com.example.storeapp.entities.Product;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {
    // String
    List<Product> findByName(String name);
    List<Product> findByNameLike(String name);
    List<Product> findByNameNotLike(String name);
    List<Product> findByNameContains(String name);
    List<Product> findByNameStartingWith(String name);
    List<Product> findByNameEndingWith(String name);
    List<Product> findByNameContainsIgnoreCase(String name);

    // Number
    List<Product> findByPrice(BigDecimal price);
    List<Product> findByPriceGreaterThan(BigDecimal price);
    List<Product> findByPriceLessThan(BigDecimal price);
    List<Product> findByPriceBetween(BigDecimal price1, BigDecimal price2);

    // Null
    List<Product> findByDescriptionIsNull();
    List<Product> findByDescriptionIsNotNull();

    // Multiple conditions
    List<Product> findByNameAndPrice(String name, BigDecimal price);
    List<Product> findByPriceGreaterThanAndDescriptionIsNotNull(BigDecimal price, String description);
    List<Product> findByNameContainingAndPriceGreaterThan(String name, BigDecimal price);

    // Sorting
    List<Product> findByNameContainingOrderByPriceAsc(String name);
    List<Product> findByNameContainingOrderByPriceDesc(String name);

    // Limiting
    List<Product> findTop5ByOrderByPriceDesc();
}
