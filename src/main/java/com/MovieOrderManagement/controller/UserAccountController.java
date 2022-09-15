package com.MovieOrderManagement.controller;

import com.MovieOrderManagement.model.dto.UserAccountDto;
import com.MovieOrderManagement.model.entity.UserAccount;
import com.MovieOrderManagement.service.UserAccountService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@Validated
@RestController
@RequestMapping("/api/v1/")
@Transactional
public class UserAccountController {

    private final UserAccountService userAccountService;
    private final ModelMapper modelMapper;

    public UserAccountController(UserAccountService userAccountService, ModelMapper modelMapper) {
        this.userAccountService = userAccountService;
        this.modelMapper = modelMapper;
    }
    @PostMapping("UserAccount")
    public ResponseEntity<UserAccount> create(@RequestBody UserAccountDto userAccountDto){
        UserAccount userAccount = userAccountService.create(userAccountDto);
        return ResponseEntity.ok(userAccount);
    }
}
