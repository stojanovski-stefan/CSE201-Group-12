/*
 * Spring Data JPA Repository
 * @author Kimberly Hamilton
 */
 net.codejava;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.email = ?1")
    public User findByEmail(String email);
}
