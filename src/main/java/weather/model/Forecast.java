package weather.model;

import weather.exception.ForecastException;

import java.util.List;

public class Forecast {

    public enum Status {
        OK, ERROR;

        private ForecastException exception;

        public ForecastException getException() {
            return exception;
        }

        public void setException(ForecastException exception) {
            this.exception = exception;
        }
    }

    private Status status;
    private List<HourlyForecast> hourlyForecasts;

    public Forecast(Status status, List<HourlyForecast> hourlyForecasts) {
        this.status = status;
        this.hourlyForecasts = hourlyForecasts;
    }

    public Forecast(Status status, List<HourlyForecast> hourlyForecasts, ForecastException exception) {
        status.setException(exception);
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
