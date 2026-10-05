package com.example.storeapp.repositories;

import com.example.storeapp.dtos.UserSummary;
import com.example.storeapp.entities.User;
import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @EntityGraph(attributePaths = {"tags", "profile"})
    Optional<User> findByEmail(String email);



    @EntityGraph(attributePaths = {"addresses"})
    @Query("SELECT u FROM User u")
    List<User> findAllUserWithAddresses();

    @Query("select u.id as id, u.email as email from User u where u.profile.loyaltyPoints > :loyaltyPoints order by u.email")
    List<UserSummary> findLoyalUsers(@Param("loyaltyPoints") int loyaltyPoints);
}
