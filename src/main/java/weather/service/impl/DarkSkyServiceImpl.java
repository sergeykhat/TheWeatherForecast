package weather.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import weather.exception.ForecastException;
import weather.service.DarkSkyService;
import weather.service.ForecastService;
import weather.model.Forecast;
import weather.model.HourlyForecast;
import weather.service.request.DarkSkyConnection;
import weather.utils.Converter;
import weather.model.City;

import java.util.ArrayList;
import java.util.List;

import static weather.model.Forecast.Status.*;

@Service
@Qualifier ("DarkSkyServiceImpl")
public class DarkSkyServiceImpl implements DarkSkyService {

    private DarkSkyConnection darkSkyConnection;
    private ForecastService service;
    private Converter converter = new Converter();

    @Autowired
    public DarkSkyServiceImpl(DarkSkyConnection darkSkyConnection, ForecastService forecastService) {
        this.darkSkyConnection = darkSkyConnection;
        this.service = forecastService;
    }

    @Override
    public Forecast getForecast(City city) {
        try {
            String response = darkSkyConnection.sendGetRequest(city);
            List<HourlyForecast> hourlyForecasts = converter.convertToHourlyForecasts(response, city);
            service.deleteAll(city);
            service.create(hourlyForecasts);
            return new Forecast(OK, hourlyForecasts);
        } catch (ForecastException e) {
            return new Forecast(ERROR, new ArrayList<>(), e);
        }
    }

}