package ch.zli.m223.ksh21a.mw.springintro.service.impl;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ch.zli.m223.ksh21a.mw.springintro.exceptions.NoRoleInRequestException;
import ch.zli.m223.ksh21a.mw.springintro.exceptions.RoleAlreadyExistsException;
import ch.zli.m223.ksh21a.mw.springintro.exceptions.RoleNotFoundException;
import ch.zli.m223.ksh21a.mw.springintro.model.Role;
import ch.zli.m223.ksh21a.mw.springintro.repository.RoleRepository;
import ch.zli.m223.ksh21a.mw.springintro.service.RoleService;


@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> getAllRoles() {
        return new ArrayList<Role>(roleRepository.findAll());
    }

    @Override
    public Role getRoleById(Long id) {
        return roleRepository.findById(id).orElseThrow(() -> new RoleNotFoundException());
    }


    @Override
    public Role addRole(String role) {
        if (role == null) {
            throw new NoRoleInRequestException();
        }
        if (roleRepository.findByRole(role).isPresent()) {
        throw new RoleAlreadyExistsException();
        } else {
            return roleRepository.create(role);
        }
    }

    @Override
    public void deleteRoleById(Long id) {
        roleRepository.deleteById(id);
    }
    
}
