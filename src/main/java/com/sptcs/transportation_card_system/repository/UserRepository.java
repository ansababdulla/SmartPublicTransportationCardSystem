package com.sptcs.transportation_card_system.repository;

import com.sptcs.transportation_card_system.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository  // This annotation indicates that it's a Spring Data JPA repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Custom query method to find a User by username
    Optional<User> findByUsername(String username);

    // Custom query method to find a User by phone number
    Optional<User> findByPhoneNo(String phoneNo);

    // Custom query method to find a User by username and password (for login)
    Optional<User> findByUsernameAndPassword(String username, String password);

    // You can add more custom queries as needed
}
