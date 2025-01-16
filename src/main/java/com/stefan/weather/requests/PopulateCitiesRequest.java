package com.stefan.weather.requests;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class PopulateCitiesRequest {
    @NotNull
    List<String> cities;
}
