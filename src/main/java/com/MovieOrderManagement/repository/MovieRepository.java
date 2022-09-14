package com.MovieOrderManagement.repository;

import com.MovieOrderManagement.model.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie,Long> {

}
