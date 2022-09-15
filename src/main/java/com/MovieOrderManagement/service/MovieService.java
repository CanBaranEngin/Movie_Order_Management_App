package com.MovieOrderManagement.service;

import com.MovieOrderManagement.exception.EntityNotFoundException;
import com.MovieOrderManagement.model.dto.MovieDto;
import com.MovieOrderManagement.model.entity.Movie;
import com.MovieOrderManagement.model.entity.User;
import com.MovieOrderManagement.repository.MovieRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MovieService {

    private final MovieRepository movieRepository;
    private final ModelMapper modelMapper;


    public MovieService(MovieRepository movieRepository, ModelMapper modelMapper) {
        this.movieRepository = movieRepository;
        this.modelMapper = modelMapper;
    }

    public Movie create(MovieDto movieDto){
        Movie movie = modelMapper.map(movieDto,Movie.class);
        return movieRepository.save(movie);
    }

    public Movie getById(Long id){
        Optional<Movie> byId = movieRepository.findById(id);
        return byId.orElseThrow(()->new EntityNotFoundException("User"));
    }
}
