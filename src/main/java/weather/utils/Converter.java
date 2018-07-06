package weather.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import weather.model.City;
import weather.dto.ForecastDataDto;
import weather.dto.ForecastDto;
import weather.exception.ParsingException;
import weather.model.HourlyForecast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Converter {
    private final ObjectMapper mapper = new ObjectMapper();

    public List<HourlyForecast> convertToHourlyForecasts(String response, City city) {
        List<HourlyForecast> hourlyForecastList = new ArrayList<>();
        ForecastDto forecast;
        try {
            forecast = mapper.readValue(response, ForecastDto.class);
        } catch (IOException e) {
            throw new ParsingException("Low-level I/O problem", e);
        }

        for (ForecastDataDto data: forecast.getHourly().getData()) {
            HourlyForecast hourlyForecast = mapper.convertValue(data, HourlyForecast.class);
            hourlyForecast.setCity(city);
            hourlyForecast.setDate(new Date(data.getTime() * 1000));
            hourlyForecastList.add(hourlyForecast);
        }
        return hourlyForecastList;
    }

}