package weather.exception;

public class ParsingException extends ForecastException {
    public ParsingException(String message, Throwable cause) {
        super(message, cause);
    }
}
