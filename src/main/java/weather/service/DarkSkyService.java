package weather.service;

import weather.model.Forecast;
import weather.data.City;

public interface DarkSkyService {

    Forecast getForecast(City city);

}
