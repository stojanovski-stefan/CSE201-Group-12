package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testSaveUser() {
        // Given
        User user = new User();
        user.setUsername("testuser");
        user.setEmail("testuser@example.com");
        user.setPassword("password");
        user.setFirstName("Jane");
        user.setLastName("Doe");

        // When
        User savedUser = userRepository.save(user);

        // Then
        assertNotNull(savedUser.getId());
        assertEquals("testuser", savedUser.getUsername());
    }

    @Test
    public void testFindByUsername() {
        // Given
        User user = new User();
        user.setUsername("testuser");
        user.setEmail("testuser@example.com");
        user.setPassword("password");
        user.setFirstName("Jane");
        user.setLastName("Doe");
        entityManager.persist(user);

        // When
        User foundUser = userRepository.findByUsername("testuser");

        // Then
        assertNotNull(foundUser);
        assertEquals("testuser@example.com", foundUser.getEmail());
    }
}