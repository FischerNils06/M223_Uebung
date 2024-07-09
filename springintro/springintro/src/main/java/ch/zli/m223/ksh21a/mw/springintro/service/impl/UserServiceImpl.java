package ch.zli.m223.ksh21a.mw.springintro.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.zli.m223.ksh21a.mw.springintro.exceptions.NoEmailInRequestException;
import ch.zli.m223.ksh21a.mw.springintro.exceptions.UserAlreadyExistsException;
import ch.zli.m223.ksh21a.mw.springintro.exceptions.UserNotFoundException;
import ch.zli.m223.ksh21a.mw.springintro.model.AppUser;
import ch.zli.m223.ksh21a.mw.springintro.repository.UserRepository;
import ch.zli.m223.ksh21a.mw.springintro.service.UserService;


@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<AppUser> getAllUser() {
        return new ArrayList<AppUser>(userRepository.findAll());
    }

    @Override
    public AppUser getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException());
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public AppUser addUser(String email, String password) {
        if (email == null) {
            throw new NoEmailInRequestException();
        }
        if (userRepository.findByEmail(email).isPresent()) {
        throw new UserAlreadyExistsException();
        } else {
            return userRepository.create(email, password);
        }
    }
    
}
