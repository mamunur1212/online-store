package com.example.storeapp.services;

import com.example.storeapp.entities.Address;
import com.example.storeapp.entities.Category;
import com.example.storeapp.entities.Product;
import com.example.storeapp.entities.User;
import com.example.storeapp.repositories.*;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final EntityManager entityManager;
    private final ProfileRepository profileRepository;
    private final AddressRepository addressRepository;
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    public UserService(UserRepository userRepository, EntityManager entityManager, ProfileRepository profileRepository, AddressRepository addressRepository, CategoryRepository categoryRepository, ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.entityManager = entityManager;
        this.profileRepository = profileRepository;
        this.addressRepository = addressRepository;
        this.categoryRepository = categoryRepository;
        this.productRepository = productRepository;
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

    public void persistRelated() {
        User user = new User("John Doe", "john81.doe@example.com", "password");
        Address address = new Address("123 Main St", "Anytown", "CA", "12345");
        user.addAddress(address);
        userRepository.save(user);
    }

    @Transactional
    public void deleteRelated() {
        User user = userRepository.findById(8L).orElseThrow();
        // userRepository.delete(user);
        var address = user.getAddresses().getFirst();
        user.removeAddress(address);
        userRepository.save(user);
    }

    public void saveCategoryAndProduct() {
        // Implement logic to save category and product
        Category category = new Category("Electronics");
        // Create a product and associate it with the category
        Product product = new Product("Smartphone", new BigDecimal("699.99"), "A high-end smartphone with a great camera.");
        // Save the category and product using the appropriate repository
        product.setCategory(category);
        productRepository.save(product);
    }

    @Transactional
    public void fetchProductsByCategory() {
        // Implement logic to fetch products by category
        Category category = categoryRepository.findById((byte) 1)
                .orElseThrow();
        // System.out.println("Products in category " + category.getName() + ":");
        Product product = new Product("Smartphone1", new BigDecimal("599.99"), "A high-end smartphone with a great camera and video capabilities.");
        product.setCategory(category);
        productRepository.save(product);

    }

    @Transactional
    public void addProductToWishlist() {
        User user = userRepository.findById(1L).orElseThrow();
        var products = productRepository.findAll();
        products.forEach(user::addProduct);
        userRepository.save(user);
    }

    @Transactional
    public void deleteProduct() {
        Product product = productRepository.findById(1L).orElseThrow();
        productRepository.delete(product);
    }

    @Transactional
    public void updateProductPrice() {
        productRepository.updatePriceByCategoryId(new BigDecimal("799.99"), (byte) 1);
    }

    public void fetchProductByCategoryId() {
        var products = productRepository.findByCategoryId((byte) 1);
        products.forEach(System.out::println);
    }
    @Transactional
    public void fetchUserByEmail() {
        var user = userRepository.findByEmail("aa").orElseThrow();
        System.out.println(user);
    }

    public void fetchAllUsersWithAddresses() {
        var users = userRepository.findAllUserWithAddresses();
        users.forEach(user -> {
            System.out.println("User: " + user);
            user.getAddresses().forEach(address -> System.out.println("Address: " + address.getStreet()));
        });
    }

    @Transactional
    public void fetchProducts() {
        // var products = productRepository.findProducts(new BigDecimal("100"), new BigDecimal("1000"));
        // products.forEach(product -> System.out.println("Product: " + product.getName() + ", Price: " + product.getPrice()));

        var product = new Product();
        product.setName("product");

        var matcher = ExampleMatcher.matching()
                .withIncludeNullValues()
                .withIgnorePaths("id", "description")
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        var example = Example.of(product, matcher);

        var products = productRepository.findAll(example);
        products.forEach(p -> System.out.println("Product: " + p.getName() + ", Price: " + p.getPrice()));

    }

    @Transactional
    public void fetchUserProfile() {
//        var profile = profileRepository.findLoyaltyPoints(2);
//        profile.forEach(p -> {
//            System.out.println("Profile: " + p.getId() + ", User Email: "+ p.getEmail());
//        });
        var users = userRepository.findLoyalUsers(2);
        users.forEach(user -> {
            System.out.println("User ID: " + user.getId() + ", Email: "+ user.getEmail());
        });
    }
}
