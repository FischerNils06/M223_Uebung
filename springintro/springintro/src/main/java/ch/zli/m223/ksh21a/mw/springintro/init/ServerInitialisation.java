package ch.zli.m223.ksh21a.mw.springintro.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import ch.zli.m223.ksh21a.mw.springintro.model.AppUserImpl;
import ch.zli.m223.ksh21a.mw.springintro.model.RoleImpl;
import ch.zli.m223.ksh21a.mw.springintro.repository.RoleRepository;
import ch.zli.m223.ksh21a.mw.springintro.repository.UserRepository;

@Component
public class ServerInitialisation implements ApplicationRunner {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        userRepository.save(
            new AppUserImpl("max@trax.com", "max")
        );

        userRepository.save(
            new AppUserImpl("mini@max.com", "mini")
        );

        roleRepository.save(
            new RoleImpl("user")
        );

        roleRepository.save(
            new RoleImpl("ceo")
        );
    }
}
