package com.stefan.weather.services;

import org.springframework.data.util.Pair;

public interface GeocodingService {
    Pair<Double, Double> getCoordinatesForPlace(String cityName);
}
