package com.example.storeapp.repositories;

import com.example.storeapp.entities.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Byte> {
}
