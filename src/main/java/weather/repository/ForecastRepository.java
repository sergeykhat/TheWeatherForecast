package weather.repository;

import org.springframework.data.repository.CrudRepository;
import weather.data.City;
import weather.model.HourlyForecast;

public interface ForecastRepository extends CrudRepository <HourlyForecast, Long> {
    HourlyForecast findByCity(City city);
    Iterable<HourlyForecast> findAllByCity(City city);
    void deleteAllByCity(City city);
}
