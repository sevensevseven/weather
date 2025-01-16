package com.stefan.weather.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "geocoding.properties")
@Data
public class GeocodingProperties {
    private String apiKey;
}
