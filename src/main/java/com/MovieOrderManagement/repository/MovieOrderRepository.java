package com.MovieOrderManagement.repository;

import com.MovieOrderManagement.model.entity.MovieOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieOrderRepository extends JpaRepository<MovieOrder,Long> {
}
