package com.stefan.weather.services;

import com.stefan.weather.db.WeatherCondition;

public interface WeatherService {


    WeatherCondition getCityIdWeather(Integer city_id);

    WeatherCondition getCityNameWeather(String city_name);
}
