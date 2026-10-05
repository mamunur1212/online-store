package com.example.storeapp.repositories;

import com.example.storeapp.dtos.ProductSummary;
import com.example.storeapp.dtos.ProductSummaryDTO;
import com.example.storeapp.entities.Product;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
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

    //

    List<Product> findByPriceBetweenOrderByName(BigDecimal price1, BigDecimal price2);

    // Custom query methods, JPQL
    @Query("SELECT p" +
            " FROM Product p" +
            " WHERE p.price between :price1 and :price2" +
            " ORDER BY p.name"
    )
    List<Product> findProducts1(@Param("price1") BigDecimal price1, @Param("price2") BigDecimal price2);

    // Custom query methods, native SQL
    @Query(value = "SELECT *" +
            " FROM products p" +
            " WHERE p.price between :price1 and :price2" +
            " ORDER BY p.name", nativeQuery = true
    )
    List<Product> findProducts2(@Param("price1") BigDecimal price1, @Param("price2") BigDecimal price2);


//    @Query(value = "SELECT count(*)" +
//            " FROM products p" +
//            " WHERE p.price between :price1 and :price2", nativeQuery = true
//    )
    // Custom query methods, JPQL
    @Query(
            "SELECT count(p)" +
                    " FROM Product p" +
                    " WHERE p.price between :price1 and :price2"
    )
    long countProducts(
            @Param("price1") BigDecimal price1, @Param("price2") BigDecimal price2
    );

    @Modifying
    @Query(
            "UPDATE Product p" +
                    " SET p.price = :newPrice" +
                    " WHERE p.category.id = :categoryId"
    )
    void updatePriceByCategoryId(
            @Param("newPrice") BigDecimal newPrice, @Param("categoryId") Byte categoryId
    );

    // List<Product> findByCategoryId(Byte categoryId);
    // List<ProductSummary> findByCategoryId(Byte categoryId);
    List<ProductSummaryDTO> findByCategoryId(Byte categoryId);


    @Procedure("findProductsByPriceRange")
    List<Product> findProducts(BigDecimal min, BigDecimal max);
}
