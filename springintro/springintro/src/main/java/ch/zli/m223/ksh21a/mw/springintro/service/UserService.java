package ch.zli.m223.ksh21a.mw.springintro.service;

import java.util.List;

import ch.zli.m223.ksh21a.mw.springintro.model.AppUser;

public interface UserService {
    List<AppUser> getAllUser();

    AppUser getUserById(Long id);

    void deleteUserById(Long id);

    AppUser addUser(String email, String password);
}
