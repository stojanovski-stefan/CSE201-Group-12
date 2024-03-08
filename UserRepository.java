package com.example.demo;

/*
 * Spring Data JPA Repository
 * @author Kimberly Hamilton
 */
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface UserRepository extends JpaRepository<User, Long> {
    //Save new Users
    User save(User user);
    
    //Find user by username
    User findByUsername(String username);
    
    //Find user by id
    User findById(long id);
    
    //Find user by email
    User findByEmail(String email);
 
}
