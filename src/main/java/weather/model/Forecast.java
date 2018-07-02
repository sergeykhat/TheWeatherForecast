package weather.model;

import weather.exception.CustomException;

import java.util.List;

public class Forecast {

    public enum Status {
        OK, ERROR;

        private CustomException exception;

        public CustomException getException() {
            return exception;
        }

        public Status setException(CustomException exception) {
            this.exception = exception;
            return this;
        }
    }

    private Status status;
    private List<HourlyForecast> hourlyForecasts;

    public Forecast(Status status, List<HourlyForecast> hourlyForecasts) {
        this.status = status;
        this.hourlyForecasts = hourlyForecasts;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<HourlyForecast> getHourlyForecasts() {
        return hourlyForecasts;
    }

    public void setHourlyForecasts(List<HourlyForecast> hourlyForecasts) {
        this.hourlyForecasts = hourlyForecasts;
    }

}
