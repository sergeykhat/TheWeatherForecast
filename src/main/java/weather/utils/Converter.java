package weather.utils;

import com.google.gson.*;
import weather.exception.CustomException;
import weather.model.HourlyForecast;
import weather.data.City;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Converter {

    private JsonParser parser = new JsonParser();
    private Gson gson = new Gson();

    public List<HourlyForecast> convertToHourlyForecasts(String response, City city) throws CustomException {

        List<HourlyForecast> hourlyForecastList = new ArrayList<>();

        JsonObject fullForecastObject = parser.parse(response).getAsJsonObject();
        JsonObject fullHourlyObject = fullForecastObject.getAsJsonObject("hourly");
        JsonArray hourlyArray = fullHourlyObject.getAsJsonArray("data");

        for (JsonElement element : hourlyArray) {
            JsonObject hourlyObject = element.getAsJsonObject();
            hourlyObject.addProperty("pressure",
                    Math.round(hourlyObject.get("pressure").getAsDouble() * 0.75)); // millibars to mmhg
            hourlyObject.addProperty("windSpeed",
                    Math.round(hourlyObject.get("windSpeed").getAsDouble() * 0.277)); // km/h to m/s
            hourlyObject.addProperty("humidity",
                    Math.round(hourlyObject.get("humidity").getAsDouble() * 100)); // km/h to m/s
            HourlyForecast hourlyForecast = gson.fromJson(element, HourlyForecast.class);
            hourlyForecast.setCity(city);
            hourlyForecast.setDate(new Date(element.getAsJsonObject().get("time").getAsLong() * 1000));
            hourlyForecastList.add(hourlyForecast);
        }
        return hourlyForecastList;
    }

}
