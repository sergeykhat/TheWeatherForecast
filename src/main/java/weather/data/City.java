package weather.data;

import java.util.stream.Stream;

public enum City {

    MOSCOW(55.7558, 37.6173),
    ST_PETERSBURG(59.9343, 30.3351),
    NOVOSIBIRSK(55.0084, 82.9357),
    YEKATERINBURG(56.8389, 60.6057),
    NIZHNY_NOVGOROD(56.2965, 43.9361),
    SAMARA(53.2415, 50.2212),
    OMSK(54.9885, 73.3242),
    KAZAN(55.8304, 49.0661),
    VOLGROGRAD(48.7080, 44.5133); // !

    private double latitude;
    private double longitude;

    City(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public static City getCityByCoord(double latitude, double longitude) throws Exception {
        return Stream.of(City.values())
                .filter(city -> (city.latitude == latitude && city.longitude == longitude))
                .findFirst()
                .orElseThrow(Exception::new);
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

}
