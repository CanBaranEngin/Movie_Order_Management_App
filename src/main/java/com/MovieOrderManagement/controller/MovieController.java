package com.MovieOrderManagement.controller;

import com.MovieOrderManagement.model.dto.MovieDto;
import com.MovieOrderManagement.model.dto.UserLoginDto;
import com.MovieOrderManagement.model.entity.Movie;
import com.MovieOrderManagement.model.service.MovieService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@Validated
@RestController
@RequestMapping("/api/v1/")
@Transactional
public class MovieController {

    private final MovieService movieService;
    private final ModelMapper modelMapper;

    public MovieController(MovieService movieService, ModelMapper modelMapper) {
        this.movieService = movieService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/movies")
    public ResponseEntity<MovieDto> create(@Valid @RequestBody MovieDto movieDto) {
        Movie createdMovie = movieService.create(movieDto);
        MovieDto createdMovieDto= modelMapper.map(createdMovie,MovieDto.class);

        return ResponseEntity.ok(createdMovieDto);
    }
}
