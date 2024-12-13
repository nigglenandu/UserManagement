package com.UserManagement.userManagement.Services;

import com.UserManagement.userManagement.Entity.Role;

import java.util.List;

public interface IServiceRole {
    List<Role> getAllRoles();
    Role getRoleById(Long id);
    void createRole(Role role);
    boolean updateRoleById(Long id, Role role);
    boolean deleteRoleById(Long id);
}
