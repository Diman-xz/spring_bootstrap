package com.example.spring_bootstrap.repository;

import com.example.spring_bootstrap.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User getUserByUsername(String username);

    User getUserByEmail(String email);
}
