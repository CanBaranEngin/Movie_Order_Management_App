package com.MovieOrderManagement.service;


import com.MovieOrderManagement.model.dto.MovieOrderDto;
import com.MovieOrderManagement.model.entity.MovieOrder;
import com.MovieOrderManagement.repository.MovieOrderRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class MovieOrderService {

    private final MovieOrderRepository movieOrderRepository;
    private final UserService userService;
    private final MovieService movieService;
    private final ModelMapper modelMapper;


    public MovieOrderService(MovieOrderRepository movieOrderRepository, UserService userService, MovieService movieService, ModelMapper modelMapper) {
        this.movieOrderRepository = movieOrderRepository;
        this.userService = userService;
        this.movieService = movieService;
        this.modelMapper = modelMapper;
    }

    public MovieOrder create(MovieOrderDto movieOrderDto) {

        MovieOrder movieOrder = modelMapper.map(movieOrderDto,MovieOrder.class);
        movieOrder.setMovie(movieService.getById(movieOrderDto.getMovieId()));
        movieOrder.setUser(userService.getById(movieOrderDto.getUserId()));
        return movieOrderRepository.save(movieOrder);
    }
}
