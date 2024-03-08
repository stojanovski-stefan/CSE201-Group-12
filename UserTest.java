/*
 * This is a test for User.java
 * @author Kimberly Hamilton
 */
package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UserTest {

    @Test
    public void testGettersSetters() {
        //Create User
        User user = new User();
        
        //Set setter properties
        user.setId(1L);
        user.setEmail("test@example.com");
        user.setUsername("testuser");
        user.setPassword("password");
        user.setFirstName("Jane");
        user.setLastName("Doe");
        
        //Use getters to check properties
        assertEquals(1L, user.getId());
        assertEquals("test@example.com",user.getEmail());
        assertEquals("testuser", user.getUsername());
        assertEquals("password",user.getPassword());
        assertEquals("Jane",user.getFirstName());
        assertEquals("Doe",user.getLastName());
    }
    
    @Test
    public void testToString() {
        //Create User
        User user = new User("test@example.com", "testuser", 
                "password", "Jane", "Doe");
        
        //Check toString() method
        assertEquals("User[id=null, email='test@example.com', "
                + "username='testuser', firstName='Jane', lastName='Doe']", 
                user.toString());
    }

}
