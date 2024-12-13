package com.UserManagement.userManagement.Controller;

import com.UserManagement.userManagement.Entity.Role;
import com.UserManagement.userManagement.Services.IServiceRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RoleController {
    @Autowired
    IServiceRole serviceRole;

    @GetMapping
    public ResponseEntity<List<Role>> getAllRole(){
        return new ResponseEntity<>(serviceRole.getAllRoles(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Role> getRoleById(@PathVariable Long id){
        return new ResponseEntity<>(serviceRole.getRoleById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createRole(@RequestBody Role role){
        serviceRole.createRole(role);
        return new ResponseEntity<>("role created", HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<String> updateRoleById(@PathVariable Long id, @RequestBody Role role){
        serviceRole.updateRoleById(id, role);
        return new ResponseEntity<>("role updated", HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteRoleById(@PathVariable Long id){
        serviceRole.deleteRoleById(id);
        return new ResponseEntity<>("role deleted", HttpStatus.OK);
    }
}
