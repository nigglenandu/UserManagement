package com.UserManagement.userManagement.Controller;

import com.UserManagement.userManagement.Entity.User;
import com.UserManagement.userManagement.Services.IServiceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {

    @Autowired
    private IServiceUser userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUser(){
        return new ResponseEntity<>(userService.getAllUser(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addUser(@RequestBody User user){
        userService.saveUser(user);
        return new ResponseEntity<>("added successfully", HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<String> updateUser(@PathVariable Long id, @RequestBody User user){
        userService.updateUser(id, user);
        return new ResponseEntity<>("updated successfully", HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable Long id){
        userService.deleteUserById(id);
        return new ResponseEntity<>("deleted successfully", HttpStatus.OK);
    }
}
