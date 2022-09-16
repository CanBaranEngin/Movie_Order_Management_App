package com.MovieOrderManagement.repository;

import com.MovieOrderManagement.model.entity.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepository extends JpaRepository <Subscription,Long> {
}
