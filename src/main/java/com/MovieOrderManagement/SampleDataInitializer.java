package com.MovieOrderManagement;

import com.MovieOrderManagement.model.entity.User;
import com.MovieOrderManagement.model.service.UserService;
import com.MovieOrderManagement.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SampleDataInitializer implements ApplicationRunner {
    private final UserRepository userRepository;
    private final UserService userService;

    @Override
    public void run(ApplicationArguments args) {


        // Creating a sample Admin USER
        User adminUser = new User("admin-user", "adminuser@mail.com", "pass1234");
        if (!userRepository.existsByUserName(adminUser.getUserName())) {
            userService.signup(adminUser, true);
        }

        // Creating a sample USER
        User sampleUser = new User("sample-user", "sampleuser@mail.com", "pass1234");
        if (!userRepository.existsByUserName(sampleUser.getUserName())) {
            userService.signup(sampleUser, false);
        }

    }
}
