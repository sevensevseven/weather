package com.stefan.weather.repositories;

import com.stefan.weather.db.Account;
import com.stefan.weather.db.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CityRepository extends JpaRepository<City, Integer> {
    @Query(value = """
        SELECT c.* FROM City c WHERE c.id = :#{#city.id};
    """, nativeQuery = true)
    List<City> findById(@Param("city") City city);

    @Query(value = """
        SELECT c FROM City c WHERE name = :#{#name};
    """, nativeQuery = true)
    Optional<City> findByName(@Param("name") String name);
}
