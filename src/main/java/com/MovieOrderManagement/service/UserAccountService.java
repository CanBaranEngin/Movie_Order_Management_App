package com.MovieOrderManagement.service;

import com.MovieOrderManagement.model.dto.UserAccountDto;
import com.MovieOrderManagement.model.entity.User;
import com.MovieOrderManagement.model.entity.UserAccount;
import com.MovieOrderManagement.repository.UserAccountRepository;
import com.MovieOrderManagement.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserAccountService {

    private final UserAccountRepository userAccountRepository;
    private final UserService userService;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserAccountService(UserAccountRepository userAccountRepository, UserService userService, UserRepository userRepository, ModelMapper modelMapper) {
        this.userAccountRepository = userAccountRepository;
        this.userService = userService;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }


    public UserAccount create(UserAccountDto userAccountDto) {
        UserAccount userAccount = modelMapper.map(userAccountDto,UserAccount.class);
        User user = userService.getById(userAccountDto.getUserId());
        user.setUserAccount(userAccount);
        userRepository.save(user);
        return userAccountRepository.save(userAccount);

    }

    public Boolean updateAccountBalance(Double money,Long id){
        User user = userService.getById(id);
        if(user !=null){
            user.getUserAccount().setAccountBalance(user.getUserAccount().getAccountBalance()+money);
            userRepository.save(user);
            return true;
        }
        else
            return false;

    }
}
