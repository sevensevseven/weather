package com.stefan.weather.controllers;

import com.stefan.weather.db.WeatherCondition;
import com.stefan.weather.services.OpenMeteoService;
import com.stefan.weather.services.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class OpenMeteoAPITestController {
    private final WeatherService weather;
    @GetMapping("/getWeatherForCityId/{id}")
    public ResponseEntity<WeatherCondition> getWeatherForCityId(@PathVariable Integer id) {
        WeatherCondition condition = weather.getCityIdWeather(id);
        return ResponseEntity.ok(condition);
    }

    @GetMapping("/getWeatherForCityName/{name}")
    public ResponseEntity<WeatherCondition> getWeatherForCityName(@PathVariable String name) {
        WeatherCondition condition = weather.getCityNameWeather(name);
        return ResponseEntity.ok(condition);

        // TODO: Enhancement in care argumentul sa fie numele orasului si nu ID-ul
    }
}
