package com.example.patientapp.Repositery;

import com.example.patientapp.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepositery extends JpaRepository<User,String> {
    User findByUsername(String username);
    User findUserByUsernameAndPassword(String username, String password);
}
