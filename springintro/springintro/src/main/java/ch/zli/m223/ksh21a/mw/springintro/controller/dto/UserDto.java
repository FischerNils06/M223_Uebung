package ch.zli.m223.ksh21a.mw.springintro.controller.dto;

import ch.zli.m223.ksh21a.mw.springintro.model.AppUser;

public class UserDto {
    public Long id;
    public String email;


    public UserDto(AppUser user) {
        id = user.getId();
        email = user.getEmail();
    }
}
