package com.stefan.weather.db;

import jakarta.persistence.*;
import lombok.Data;
import io.hypersistence.utils.hibernate.type.json.JsonType;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import java.time.Instant;
import java.time.LocalDateTime;

@Data
@Entity(name = "city")
@NoArgsConstructor
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    public Double lat;
    public Double lng;

    @Column(unique = true, nullable = false)
    public String name;

    @Column(columnDefinition = "jsonb")
    @Type(JsonType.class)
    public WeatherCondition weatherCondition;

    public Instant lastUpdated = null;

    public City(Double lat, Double lng, String name) {
        this.lat = lat;
        this.lng = lng;
        this.name = name;
    }

    // De rezolvat eroarea cu serializarea de la JSON si dupa testare metoda de test getWeatherForCity
}
