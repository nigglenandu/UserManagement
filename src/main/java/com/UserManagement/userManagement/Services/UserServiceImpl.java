package com.UserManagement.userManagement.Services;

import com.UserManagement.userManagement.Entity.User;
import com.UserManagement.userManagement.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IServiceUser{
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public boolean updateUser(Long id, User user) {
        Optional<User> optional = userRepository.findById(id);
        if(optional.isPresent()){
            User userToUpdate = optional.get();
            userToUpdate.setUsername(user.getUsername());
            userToUpdate.setPassword(user.getPassword());
            userToUpdate.setEmail(user.getEmail());
            userRepository.save(userToUpdate);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean deleteUserById(Long id) {
        if(userRepository.existsById(id)){
            userRepository.deleteById(id);
            return true;
        } else{
            return false;
        }
    }


}
