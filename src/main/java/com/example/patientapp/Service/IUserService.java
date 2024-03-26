package com.example.patientapp.Service;

import com.example.patientapp.Entity.Role;
import com.example.patientapp.Entity.User;

public interface IUserService {

    User addNewUser(User user);
    Role addNewRole(Role role);
    User findUserByUserName(String userName);
    Role findRoleByRoleName(String roleName);
    void addRoleToUser(String userName,String roleName);
    User authenticate(String userName,String password);

}
