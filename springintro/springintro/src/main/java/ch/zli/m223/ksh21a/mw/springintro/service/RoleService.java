package ch.zli.m223.ksh21a.mw.springintro.service;

import java.util.List;

import ch.zli.m223.ksh21a.mw.springintro.model.Role;

public interface RoleService {

    List<Role> getAllRoles();

    Role getRoleById(Long id);

    Role addRole(String role);

    void deleteRoleById(Long id);
}
