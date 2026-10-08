package com.example.storeapp.mappers;

import com.example.storeapp.dtos.ProductDTO;
import com.example.storeapp.entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(source = "category.id", target = "categoryId")
    ProductDTO toDto(Product product);
}
