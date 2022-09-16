package com.MovieOrderManagement.controller;

import com.MovieOrderManagement.model.dto.UserAccountDto;
import com.MovieOrderManagement.model.entity.UserAccount;
import com.MovieOrderManagement.service.UserAccountService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("userAccountBalance/{id}")
    public ResponseEntity updateAccountBalance(@RequestParam Double money,@PathVariable("id") Long id){
        if(userAccountService.updateAccountBalance(money,id)){
            return ResponseEntity.status(HttpStatus.OK).body("Account balance of User" + id + " has been updated  successfully.");
        }
        else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User not found");

    }
}
