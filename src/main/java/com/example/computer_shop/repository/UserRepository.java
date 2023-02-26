package com.example.computer_shop.repository;

import com.example.computer_shop.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    String FIND_BY_EMAIL = "SELECT u FROM User u JOIN FETCH u.roles WHERE u.email = ?1";

    @Query(FIND_BY_EMAIL)
    Optional<User> findByEmail(String email);
}
