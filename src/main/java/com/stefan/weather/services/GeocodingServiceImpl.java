package com.stefan.weather.services;

import com.opencagedata.jopencage.JOpenCageGeocoder;
import com.opencagedata.jopencage.model.JOpenCageForwardRequest;
import com.opencagedata.jopencage.model.JOpenCageLatLng;
import com.opencagedata.jopencage.model.JOpenCageResponse;
import com.opencagedata.jopencage.model.JOpenCageResult;
import com.stefan.weather.config.GeocodingProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@Service
public class GeocodingServiceImpl implements GeocodingService {
    private final GeocodingProperties properties;
    @Override
    public Pair<Double, Double> getCoordinatesForPlace(String cityName) {
        JOpenCageGeocoder jOpenCageGeocoder = new JOpenCageGeocoder(properties.getApiKey());
        JOpenCageForwardRequest request = new JOpenCageForwardRequest(cityName);
        request.setNoAnnotations(false);
        JOpenCageResponse response = jOpenCageGeocoder.forward(request);

        JOpenCageLatLng latLng = response.getFirstPosition();
        return Pair.of(latLng.getLat(), latLng.getLng());
    }
}
