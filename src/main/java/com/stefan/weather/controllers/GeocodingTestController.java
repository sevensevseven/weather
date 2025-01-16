package com.stefan.weather.controllers;

import com.stefan.weather.services.GeocodingService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.util.Pair;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class GeocodingTestController {
    private final GeocodingService geocodingService;

    @GetMapping("/updateCoordForCityName/{name}")
    public ResponseEntity<Pair<Double, Double>> updateCoordForCityName(@PathVariable String name) {
        return ResponseEntity.ok(geocodingService.getCoordinatesForPlace(name));
    }
}
