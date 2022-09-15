package com.MovieOrderManagement.repository;

import com.MovieOrderManagement.model.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAccountRepository extends JpaRepository <UserAccount,Long> {

}
