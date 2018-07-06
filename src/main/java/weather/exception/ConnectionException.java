package weather.exception;

public class ConnectionException extends ForecastException {

    public ConnectionException(String message, Throwable cause) {
        super(message, cause);
    }

}
