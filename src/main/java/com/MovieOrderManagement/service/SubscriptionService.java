package com.MovieOrderManagement.service;

import com.MovieOrderManagement.exception.CustomJwtException;
import com.MovieOrderManagement.model.Role;
import com.MovieOrderManagement.model.dto.SubscriptionDto;
import com.MovieOrderManagement.model.entity.Subscription;
import com.MovieOrderManagement.model.entity.User;
import com.MovieOrderManagement.repository.SubscriptionRepository;
import com.MovieOrderManagement.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;
    private final UserService userService;

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public SubscriptionService(SubscriptionRepository subscriptionRepository, UserService userService, UserRepository userRepository, ModelMapper modelMapper) {
        this.subscriptionRepository = subscriptionRepository;
        this.userService = userService;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    public Subscription create(SubscriptionDto subscriptionDto) {
        Subscription subscription= new Subscription();
        User user = userService.getById(subscriptionDto.getUserId());
        subscription.setUser(user);
        if(user.getUserAccount().getAccountBalance()>50.0){
            user.getUserAccount().setAccountBalance(user.getUserAccount().getAccountBalance()-50.0);
            user.setRoles(Collections.singletonList(Role.ROLE_SUBSCRIBER));
            //userRepository.save(user);
            return subscriptionRepository.save(subscription);

        }
        else {
            throw new CustomJwtException("Your balance is not enough for subscription!!", HttpStatus.BAD_REQUEST);
        }


    }
}
