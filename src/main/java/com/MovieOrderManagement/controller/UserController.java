package com.MovieOrderManagement.controller;

import com.MovieOrderManagement.model.dto.UserDataDto;
import com.MovieOrderManagement.model.dto.UserLoginDto;
import com.MovieOrderManagement.model.entity.User;
import com.MovieOrderManagement.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@RequestMapping("/api/v1")
@Transactional
public class UserController {

    private final UserService userService;
    private final ModelMapper modelMapper;
    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') OR hasRole('ROLE_NONSUBSCRIBER') OR hasRole('ROLE_SUBSCRIBER')")
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAll();
    }
    @PostMapping("/users/signin")
    public String login(@Valid @RequestBody UserLoginDto userLoginDTO) {
        return userService.signin(userLoginDTO.getUserName(), userLoginDTO.getPassword());
    }
    @PostMapping("/users/signup")
    public String signup(@RequestBody @Valid UserDataDto userDataDTO) {
        User user = new User();
        user.setUserName(userDataDTO.getUserName());
        user.setEmail(userDataDTO.getEmail());
        user.setPassword(userDataDTO.getPassword());
        return userService.signup(user,3);
    }

    @DeleteMapping(value = "/users/{username}")
    public String delete(@PathVariable String username) {
        userService.delete(username);
        return username;
    }


}
