package weather.service;

import weather.model.Forecast;
import weather.model.City;

public interface DarkSkyService {

    Forecast getForecast(City city);

}
