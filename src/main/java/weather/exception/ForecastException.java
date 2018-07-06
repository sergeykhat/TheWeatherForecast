package weather.exception;


public class ForecastException extends RuntimeException {

    ForecastException (String message, Throwable cause) {
        super(message, cause);
    }

}
