package com.UserManagement.userManagement.Services;

import com.UserManagement.userManagement.Entity.User;

import java.util.List;

public interface IServiceUser {
    List<User> getAllUser();

    User getUserById(Long id);

    void saveUser(User user);
    
    
    boolean updateUser(Long id, User user);

    boolean deleteUserById(Long id);
}
