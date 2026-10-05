package com.example.storeapp.repositories;

import com.example.storeapp.entities.User;
import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    @EntityGraph(attributePaths = {"tags", "profile"})
    Optional<User> findByEmail(String email);



    @EntityGraph(attributePaths = {"addresses"})
    @Query("SELECT u FROM User u")
    List<User> findAllUserWithAddresses();
}
