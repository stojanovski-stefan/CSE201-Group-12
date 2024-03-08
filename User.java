package com.example.demo;

/*
 * The User entity class 
 * @author Kimberly Hamilton
 */
import jakarta.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table (name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    //========================================== instance properties
    private Long id;
    
    @NotNull(message = "Email is required")
    @Column(nullable = false, unique = true, length = 45)
    private String email;
    
    @NotNull(message = "Username is required")
    @Column(nullable = false, unique = true, length = 20)
    private String username;
    
    @NotNull(message = "Password is required")
    @Column(nullable = false, length = 20)
    private String password;
    
    @NotNull(message = "First Name is required")
    @Column(name = "first_name", nullable = false, length = 20)
    private String firstName;
    
    @NotNull(message = "Last Name is required")
    @Column(name = "last_name",nullable = false, length = 20)
    private String lastName;
    
    //========================================== constructor
    /*
     * Empty Constructor
     */
    protected User() {
    }
    
    /*
     * Partial Constructor: Set user variables to defined values
     * @param email of user
     * @param username of user
     * @param password of user
     * @param first name of user
     * @param last name of user
     */
    public User(String email, String username, String password
            ,String firstName, String lastName) {
        this.email = email;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    //========================================== method
    /*
     * Creates a String representation of user information
     * @return String representation 
     */
    @Override
    public String toString() {
      return String.format(
          "User[id=%d, email='%s', username='%s', firstName='%s', "
          + "lastName='%s']",id, email, username, firstName, lastName);
    }
    
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
