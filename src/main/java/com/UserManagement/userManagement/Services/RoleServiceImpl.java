package com.UserManagement.userManagement.Services;

import com.UserManagement.userManagement.Entity.Role;
import com.UserManagement.userManagement.Repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements IServiceRole{
    @Autowired
    RoleRepository roleRepository;

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Role getRoleById(Long id) {
        return roleRepository.findById(id).get();
    }

    @Override
    public void createRole(Role role) {
        roleRepository.save(role);
    }

    @Override
    public boolean updateRoleById(Long id, Role role) {
        Optional<Role> optionalRole = roleRepository.findById(id);
        if(optionalRole.isPresent()) {
            Role roleToUpdate = optionalRole.get();
            roleToUpdate.setName(role.getName());
            roleRepository.save(roleToUpdate);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean deleteRoleById(Long id) {
        if(roleRepository.existsById(id)){
            roleRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
