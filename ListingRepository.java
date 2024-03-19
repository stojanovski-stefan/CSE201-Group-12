package com.example.demo;

/*
 * Spring Data JPA Repository
 * @author Casey Cross
 */
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface ListingRepository extends JpaRepository<Listing, Long> {
    //Save new Listing
    Listing save(Listing listing);
    
    //Find listing by name
    Listing findByName(String name);
    
    //Find listing by seller
    Listing findBySeller(User seller);
 
}
