package Backend.Models;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;
    
    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    private Double price;
    private Boolean availability;
    private String brand;
    private String size;
    private String gender;
    private String condition;
    private String itemCategory;
    private String sellerName;
    private String description;

    // Standard getters and setters
}
