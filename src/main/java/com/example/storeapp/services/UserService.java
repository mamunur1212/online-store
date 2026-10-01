package com.example.storeapp.services;

import com.example.storeapp.entities.User;
import com.example.storeapp.repositories.AddressRepository;
import com.example.storeapp.repositories.ProfileRepository;
import com.example.storeapp.repositories.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final EntityManager entityManager;
    private final ProfileRepository profileRepository;
    private final AddressRepository addressRepository;

    public UserService(UserRepository userRepository, EntityManager entityManager, ProfileRepository profileRepository, AddressRepository addressRepository) {
        this.userRepository = userRepository;
        this.entityManager = entityManager;
        this.profileRepository = profileRepository;
        this.addressRepository = addressRepository;
    }

    @Transactional
    public void showEntityStates() {
        User user = new User("John Doe", "hello3@example.com", "password");
        if (entityManager.contains(user))
            System.out.println("Persistent");
        else
            System.out.println("Transient / Detached");

        userRepository.save(user);

        if (entityManager.contains(user))
            System.out.println("Persistent");
        else
            System.out.println("Transient / Detached");
    }

    @Transactional
    public void showRelatedEntities() {
        var profile = profileRepository.findById(8L).orElseThrow();
        System.out.println(profile.getUser().getEmail());
    }

    public void fetchAddress() {
        var address = addressRepository.findById(1L).orElseThrow();
    }
}
