package com.MovieOrderManagement.controller;


import com.MovieOrderManagement.model.dto.MovieOrderDto;
import com.MovieOrderManagement.model.entity.MovieOrder;
import com.MovieOrderManagement.service.MovieOrderService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@Validated
@RestController
@RequestMapping("/api/v1/")
@Transactional
public class MovieOrderController {

    private final ModelMapper modelMapper;
    private final MovieOrderService movieOrderService;

    public MovieOrderController(ModelMapper modelMapper, MovieOrderService movieOrderService) {
        this.modelMapper = modelMapper;
        this.movieOrderService = movieOrderService;
    }

    @PostMapping("movieOrder")
    public ResponseEntity<MovieOrder> create(@RequestBody MovieOrderDto movieOrderDto){
        MovieOrder movieOrder =movieOrderService.create(movieOrderDto);
        //MovieOrderDto result = modelMapper.map(movieOrder,MovieOrderDto.class);
        return ResponseEntity.ok(movieOrder);

    }
}
