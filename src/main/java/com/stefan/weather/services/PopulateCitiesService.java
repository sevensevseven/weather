package com.stefan.weather.services;

import com.stefan.weather.requests.PopulateCitiesRequest;
import org.springframework.http.HttpStatus;

public interface PopulateCitiesService {
     void populateCities(PopulateCitiesRequest request);
}
