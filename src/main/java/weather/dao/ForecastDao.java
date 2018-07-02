package weather.dao;


import weather.model.HourlyForecast;
import weather.data.City;

import java.util.List;

public interface ForecastDao {

    void save(HourlyForecast hourlyForecast);
    void saveAll(Iterable<HourlyForecast> hourlyForecast);
    HourlyForecast get(City city);
    List<HourlyForecast> getAll(City city);
    void deleteAllByCity(City city);

}
