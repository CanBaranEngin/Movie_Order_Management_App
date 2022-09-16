package com.MovieOrderManagement.controller;

import com.MovieOrderManagement.model.dto.MovieDto;
import com.MovieOrderManagement.model.entity.Movie;
import com.MovieOrderManagement.service.MovieService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

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

    @GetMapping("/ListMovies")
    public ResponseEntity<List<MovieDto>> getAll(){
        List<Movie> movieList = movieService.getAll();
        List<MovieDto> movieDtoList = movieList.stream().map(movie -> modelMapper
                .map(movie,MovieDto.class)).collect(Collectors.toList());
        return ResponseEntity.ok(movieDtoList);
    }
}
