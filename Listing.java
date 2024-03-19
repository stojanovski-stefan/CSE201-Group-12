package com.example.demo;

/*
 * Lising class
 * @author Casey Cross
 */

import jakarta.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table (name = "listings")
 public class Listing {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    // Instance Properties \\

    @NotNull(message = "Name is required")
    @Column(name = "name", nullable = false, length = 20)
    private String name;

    @NotNull(message = "An Image is required")
    @Column(name = "image", nullable = false, length = 300)
    private String image; 

    @NotNull(message = "Select a type")
    @Column(name = "type", nullable = false, length = 20)
    private String type; 

    @NotNull(message = "Add an item description")
    @Column(name = "description", nullable = false, length = 300)
    private String description;

    @NotNull(message = "Select a condition")
    @Column(name = "condition", nullable = false, length = 20)
    private String condition;

    @NotNull(message = "Select M/F/Uni")
    @Column(name = "sex", nullable = false, length = 20)
    private String sex;

    @NotNull(message = "Add a price")
    @Column(name = "price", nullable = false, length = 20)
    private double price;

    private User seller;
    private boolean availibility = true;

    // Constructors \\

    /**
     * Empty Constructor
     */
    public Listing() {

    }

    /**
     * Workhorse Constructor: Sets listing variables to defined values
     * @param n name of listing
     * @param i image of listing
     * @param t type of listing
     * @param d description of listing
     * @param s seller of listing
     * @param c condition of listing
     * @param se sex of listing
     * @param p price of listing
     */
    public Listing(String n, String i, String t, String d, String c, String se, double p, User s) {
        name = n;
        image = i;
        type = t;
        description = d;
        seller = s;
        condition = c;
        sex = se;
        price = p;
        availibility = true;
    }

    // Methods \\
    
    /*
     * Creates a String representation of listing information
     * @return String representation 
     */
    @Override
    public String toString() {
        return String.format("Name[%s]\n,
                            Image[%s]\n,
                            Type[%s]\n,
                            Description[%s]\n,
                            Condition[%s]\n,
                            Price[%f]\n,
                            %s", name, image, type, description, condition, price, seller.toSting());
    }

    // Getters / Setters \\

    public String getName() {
        return name;
    }

    public void setName(String n) {
        name = n;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String i) {
        image = i;
    }

    public String getType() {
        return type;
    }

    public void setType(String t) {
        type = t;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String d) {
        description = d;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String c) {
        condition = c;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double p) {
        price = p;
    }

    public User getSeller() {
        return seller;
    }

    public void setSeller(User s) {
        seller = s;
    }

    public boolean getAvailibility() {
        return availibility;
    }

    public void setAvailibility(boolean a) {
        availibility = a;
    }
 }
 