package com.example.storeapp.repositories;

import com.example.storeapp.dtos.UserSummary;
import com.example.storeapp.entities.Profile;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProfileRepository extends CrudRepository<Profile, Long> {
    @EntityGraph(attributePaths = {"user"})
    List<Profile> findProfileByLoyaltyPointsGreaterThan(Integer points);

    // sort by user email
    @Query("select p.id as id, p.user.email as email from Profile p where p.loyaltyPoints > :points order by p.user.email")
    @EntityGraph(attributePaths = {"user"})
    List<UserSummary> findLoyaltyPoints(@Param("points") Integer points);
}
