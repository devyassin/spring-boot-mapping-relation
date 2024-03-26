package com.example.patientapp.Service;

import com.example.patientapp.Entity.Role;
import com.example.patientapp.Entity.User;
import com.example.patientapp.Repositery.RoleRepositery;
import com.example.patientapp.Repositery.UserRepositery;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements IUserService {

    private UserRepositery userRepositery;
    private RoleRepositery roleRepositery;

    @Override
    public User addNewUser(User user) {
        user.setId(UUID.randomUUID().toString());
        return userRepositery.save(user);
    }

    @Override
    public Role addNewRole(Role role) {
        return roleRepositery.save(role);
    }

    @Override
    public User findUserByUserName(String userName) {
        return userRepositery.findByUsername(userName);
    }

    @Override
    public Role findRoleByRoleName(String roleName) {
        return roleRepositery.findByRoleName(roleName);
    }

    @Override
    public void addRoleToUser(String userName, String roleName) {
        User user=findUserByUserName(userName);
        Role role=findRoleByRoleName(roleName);
        if(user.getRoles()!=null){
            user.getRoles().add(role);
            role.getUsers().add(user);
        }
        // we dont need to use save because it's a transactional operation
        userRepositery.save(user);
    }

    @Override
    public User authenticate(String userName, String password) {
        User userInfo=userRepositery.findUserByUsernameAndPassword(userName,password);
        if(userInfo==null) throw new RuntimeException("Bad credentials");
        return userInfo;
    }
}
