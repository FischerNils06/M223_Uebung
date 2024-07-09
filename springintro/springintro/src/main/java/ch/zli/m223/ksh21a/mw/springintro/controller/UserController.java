package ch.zli.m223.ksh21a.mw.springintro.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ch.zli.m223.ksh21a.mw.springintro.controller.dto.UserDto;
import ch.zli.m223.ksh21a.mw.springintro.controller.dto.UserInputDto;
import ch.zli.m223.ksh21a.mw.springintro.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;





@RestController
@RequestMapping("api/v1/users")

public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("")
    List<UserDto> getAllUsers() {
    
        //return List.of(new UserDto("Max"), new UserDto("Trax"));
        return userService.getAllUser().stream()
                .map((user) -> new UserDto(user))
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable("id") Long id) {
        return new UserDto(userService.getUserById(id));
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable("id") Long id) {
        userService.deleteUserById(id);
    }

    @PostMapping("")
    public UserDto addUser(@RequestBody UserInputDto user) {
        return new UserDto(userService.addUser(user.email, user.password));
    }
    
    
    
}