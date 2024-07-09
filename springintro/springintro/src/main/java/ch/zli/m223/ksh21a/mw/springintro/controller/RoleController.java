package ch.zli.m223.ksh21a.mw.springintro.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.zli.m223.ksh21a.mw.springintro.controller.dto.RoleInputDto;
import ch.zli.m223.ksh21a.mw.springintro.model.Role;
import ch.zli.m223.ksh21a.mw.springintro.service.RoleService;

@RestController
@RequestMapping("api/v1/roles")
public class RoleController {
    
    @Autowired RoleService roleService;

    
    @GetMapping("")
    public List<Role> getAllRoles() {
        return roleService.getAllRoles();
    }

    @GetMapping("/{id}")
        public Role getRoleById(@PathVariable("id") Long id) {
        return roleService.getRoleById(id);
    }

    @PostMapping("")
    public Role addRole(@RequestBody RoleInputDto role) {
        return roleService.addRole(role.role);
    }

    @DeleteMapping("/{id}")
    public void deleteRoleById(@PathVariable("id") Long id) {
        roleService.deleteRoleById(id);
    }


}
