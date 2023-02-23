package com.example.webproject.database;

import com.example.webproject.user.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository
        extends JpaRepository<Users, Long> {

    Users findByEmail(String email);
}
