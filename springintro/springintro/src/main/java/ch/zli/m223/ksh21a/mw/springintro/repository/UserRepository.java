package ch.zli.m223.ksh21a.mw.springintro.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import ch.zli.m223.ksh21a.mw.springintro.model.AppUser;
import ch.zli.m223.ksh21a.mw.springintro.model.AppUserImpl;




public interface UserRepository extends JpaRepository<AppUserImpl, Long>{
    Optional<AppUserImpl> findByEmail(String email);

    default AppUser create(String email, String password) {
        return save(new AppUserImpl(email, password));
    }
}
