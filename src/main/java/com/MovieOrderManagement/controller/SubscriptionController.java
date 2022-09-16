package com.MovieOrderManagement.controller;

import com.MovieOrderManagement.model.dto.SubscriptionDto;
import com.MovieOrderManagement.model.entity.Subscription;
import com.MovieOrderManagement.service.SubscriptionService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@Validated
@RestController
@RequestMapping("/api/v1/")
@Transactional
public class SubscriptionController {

    private final SubscriptionService subscriptionService;


    public SubscriptionController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @PostMapping("/subscription")
    public ResponseEntity<Subscription> create(@RequestBody SubscriptionDto subscriptionDto){
        Subscription subscription = subscriptionService.create(subscriptionDto);
        return ResponseEntity.ok(subscription);
    }
    @GetMapping("/subscriptions")
    public ResponseEntity<List<Subscription>> getAll(){
        List<Subscription> subscriptionList=subscriptionService.getAll();
        return ResponseEntity.ok(subscriptionList);
    }
}
