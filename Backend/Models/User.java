package Backend.Models;

import javax.persistence.*;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    
    private String email;
    private String username;
    private String password;
    private String firstName;
    private String lastName;

    @OneToMany(mappedBy = "user")
    private Set<Product> products;

    @OneToMany(mappedBy = "user")
    private Set<BoughtProduct> boughtProducts;

    // Standard getters and setters
}
