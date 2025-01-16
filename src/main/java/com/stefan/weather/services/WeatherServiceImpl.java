package com.stefan.weather.services;

import com.stefan.weather.db.City;
import com.stefan.weather.db.WeatherCondition;
import com.stefan.weather.repositories.CityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class WeatherServiceImpl implements WeatherService {
    private final CityRepository repository;
    private final OpenMeteoService openMeteoService;

    @Override
    public WeatherCondition getCityIdWeather(Integer city_id) {
        try {
            Optional<City> cityOptional = repository.findById(city_id);
            City city = cityOptional.get();
            if (checkTimestamp(city.getLastUpdated())) {
                WeatherCondition newCondition = openMeteoService.getWeather(city.lat, city.lng);
                city.setWeatherCondition(newCondition);
                city.setLastUpdated(Instant.now());
                repository.save(city);
            }
            return city.getWeatherCondition();
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException(String.format("Weather condition for city with id %d not found", city_id));
        }
    }

    @Override
    public WeatherCondition getCityNameWeather(String city_name) {
        try {
            Optional<City> cityOptional = repository.findByName(city_name);
            City city = cityOptional.get();
            if (checkTimestamp(city.getLastUpdated())) {
                WeatherCondition newCondition = openMeteoService.getWeather(city.lat, city.lng);
                city.setWeatherCondition(newCondition);
                city.setLastUpdated(Instant.now());
                repository.save(city);
            }
            return city.getWeatherCondition();
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException(String.format("Weather condition for city with name %s not found", city_name));
        }
    }

    private boolean checkTimestamp(Instant instant) {
        Instant result = Instant.now().minus(10, ChronoUnit.MINUTES);
        return instant == null || instant.isBefore(result);
    }
}
