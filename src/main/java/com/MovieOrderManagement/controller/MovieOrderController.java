package com.MovieOrderManagement.controller;


import com.MovieOrderManagement.repository.MovieOrderRepository;
import org.modelmapper.ModelMapper;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@Validated
@RestController
@RequestMapping("/api/v1/")
@Transactional
public class MovieOrderController {

    private final ModelMapper modelMapper;
    private final MovieOrderService movieOrderService;
}
