package ch.zli.m223.ksh21a.mw.springintro.repository;


import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import ch.zli.m223.ksh21a.mw.springintro.model.Role;
import ch.zli.m223.ksh21a.mw.springintro.model.RoleImpl;

public interface RoleRepository extends JpaRepository<RoleImpl, Long>{

    Optional<Role> findByRole(String role);

    default Role create(String role) {
        return save(new RoleImpl(role));
    }
}
