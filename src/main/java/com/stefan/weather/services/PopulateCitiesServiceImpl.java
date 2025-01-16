package com.stefan.weather.services;

import com.stefan.weather.db.City;
import com.stefan.weather.repositories.CityRepository;
import com.stefan.weather.requests.PopulateCitiesRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PopulateCitiesServiceImpl implements PopulateCitiesService{
    private final CityRepository repository;
    private final GeocodingService geocodingService;

    @Override
    public void populateCities(PopulateCitiesRequest request) {
        for (String cityName : request.getCities()) {
            Pair<Double, Double> coords = geocodingService.getCoordinatesForPlace(cityName);
            City city = new City();
            city.setLat(coords.getFirst());
            city.setLng(coords.getSecond());
            city.setName(cityName);
            repository.save(city);

//            repository.save(new City(coords.getFirst(), coords.getSecond(), cityName));
        }
    }
}
