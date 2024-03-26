package com.example.patientapp.Repositery;

import com.example.patientapp.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepositery extends JpaRepository<Role,Long> {
    Role findByRoleName(String roleName);
}
