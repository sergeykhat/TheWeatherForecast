package weather.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import weather.model.City;
import weather.model.HourlyForecast;

@Repository
public interface ForecastRepository extends CrudRepository <HourlyForecast, Long> {
    HourlyForecast findByCity(City city);
    Iterable<HourlyForecast> findAllByCity(City city);
    void deleteAllByCity(City city);
}

