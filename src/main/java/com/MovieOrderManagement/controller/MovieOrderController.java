package com.MovieOrderManagement.controller;


import com.MovieOrderManagement.model.dto.MovieOrderDto;
import com.MovieOrderManagement.model.dto.MovieOrderResponseDto;
import com.MovieOrderManagement.model.entity.MovieOrder;
import com.MovieOrderManagement.model.entity.Subscription;
import com.MovieOrderManagement.service.MovieOrderService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

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
    public ResponseEntity<MovieOrderResponseDto> create(@RequestBody MovieOrderDto movieOrderDto){
        MovieOrder movieOrder =movieOrderService.create(movieOrderDto);
        MovieOrderResponseDto movieOrderResponseDto= new MovieOrderResponseDto();
        movieOrderResponseDto.setMovieName(movieOrder.getMovie().getTitle());
        movieOrderResponseDto.setUserName(movieOrder.getUser().getUserName());
        //MovieOrderDto result = modelMapper.map(movieOrder,MovieOrderDto.class);
        return ResponseEntity.ok(movieOrderResponseDto);

    }

    @GetMapping("/movieorders")
    public ResponseEntity<List<MovieOrderResponseDto>> getAll(){
        List<MovieOrder> movieOrderList=movieOrderService.getAll();
        List<MovieOrderResponseDto> movieOrderResponseDtoList = new ArrayList<>();
        for (int i = 0; i < movieOrderList.size(); i++) {
            movieOrderResponseDtoList.add(new MovieOrderResponseDto());
            movieOrderResponseDtoList.get(i).setMovieName(movieOrderList.get(i).getMovie().getTitle());
            movieOrderResponseDtoList.get(i).setUserName(movieOrderList.get(i).getUser().getUserName());
        }
        return ResponseEntity.ok(movieOrderResponseDtoList);
    }
}
