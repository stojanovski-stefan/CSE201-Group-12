/*
 * The User entity class 
 * @author Kimberly Hamilton
 */
package net.codejava;

import jakarta.persistence.*;

@Entity
@Table (name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    //========================================== instance properties
    private Long id;
    
    @Column(nullable = false, unique = true, length = 45)
    private String email;
    
    @Column(nullable = false, unique = true, length = 20)
    private String username;
    
    @Column(nullable = false, length = 20)
    private String password;
    
    @Column(name = "first_name", nullable = false, length = 20)
    private String firstName;
    
    @Column(name = "last_name",nullable = false, length = 20)
    private String lastName;
    
    //========================================== getters/setters
    /*
     * This gets the Id of the user
     */
    public Long getId() {
        return id;
    }

    /*
     * This sets the Id of the user
     * @param id to be set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /*
     * This gets the email of the user
     */
    public String getEmail() {
        return email;
    }

    /*
     * This sets the email of the user
     * @param email to be set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /*
     * This gets the username of the user
     */
    public String getUsername() {
        return username;
    }

    /*
     * This sets the username of the user
     * @param username to be set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /*
     * This gets the password of the user
     */
    public String getPassword() {
        return password;
    }

    /*
     * This sets the password of the user
     * @param password to be set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /*
     * This gets the firstname of the user
     */
    public String getFirstName() {
        return firstName;
    }

    /*
     * This sets the firstname of the user
     * @param firstname to be set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /*
     * This gets the lastname of the user
     */
    public String getLastName() {
        return lastName;
    }

    /*
     * This sets the lastname of the user
     * @param lastname to be set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
}
