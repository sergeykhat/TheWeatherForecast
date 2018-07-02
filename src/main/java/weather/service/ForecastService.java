package weather.service;


import weather.model.HourlyForecast;
import weather.data.City;

import java.util.List;

public interface ForecastService {

    List<HourlyForecast> getAll(City citys);
    void create(HourlyForecast hourlyForecast);
    void create(Iterable<HourlyForecast> hourlyForecasts);
    void deleteAll(City city);

}
