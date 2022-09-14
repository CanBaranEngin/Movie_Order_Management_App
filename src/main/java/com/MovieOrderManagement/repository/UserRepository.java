package com.MovieOrderManagement.repository;

import com.MovieOrderManagement.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUserName(String userName);

    boolean existsByUserName(String userName);

    void deleteByUserName(String username);
}
