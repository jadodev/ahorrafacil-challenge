package com.challenge.ahorrafacil.infra.controllers;

import com.challenge.ahorrafacil.application.services.SubscriptionService;
import com.challenge.ahorrafacil.domain.models.Subscription;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/subscription")
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    public SubscriptionController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @PostMapping
    public ResponseEntity<Optional<Subscription>> createSubscription(@RequestBody Subscription subscription) {
        Optional<Subscription> createSub = subscriptionService.createSubscription(subscription);
        return new ResponseEntity<>(createSub, HttpStatus.CREATED);

    }

    @PutMapping("/deactivate/{id}")
    public ResponseEntity<Optional<Subscription>> updateSubscriptionStatus(@PathVariable Long id, @RequestParam String status) {
        Optional<Subscription> updatedSubscription = subscriptionService.deactivateSubscription(id);
        return new ResponseEntity<>(updatedSubscription, HttpStatus.OK);
    }
}
