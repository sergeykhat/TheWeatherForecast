package weather.service.request;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import weather.exception.ConnectionException;
import weather.model.City;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

@Service
public class DarkSkyConnection {

    @Value("${darksky.key}")
    private String key;

    @Value("${darksky.request.url}")
    private String textUrl;

    @Value("${darksky.request.parameters}")
    private String parameters;

    public String sendGetRequest(City city) throws ConnectionException{

        String requestUrl = textUrl + key + "/" + city.getLatitude() + "," + city.getLongitude() + parameters;
        try {
            URL url = new URL(requestUrl);
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            StringBuilder response = new StringBuilder();
            try (BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String line;
                while ((line = input.readLine()) != null) {
                    response.append(line);
                }
            }
            return response.toString();
        } catch (IOException e) {
            throw new ConnectionException("Error occurred during connection to Darksky API " + requestUrl, e);
        }
    }

}
