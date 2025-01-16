package com.stefan.weather.controllers;

import com.stefan.weather.requests.PopulateCitiesRequest;
import com.stefan.weather.services.PopulateCitiesService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PopulateCitiesController {
    private final PopulateCitiesService service;

    @PostMapping("/populateCities")
    public ResponseEntity<Void> populateCities(@Valid @RequestBody PopulateCitiesRequest request) {
        service.populateCities(request);
        return ResponseEntity.ok().build();
    }
}
