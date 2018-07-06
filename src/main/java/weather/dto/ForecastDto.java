package weather.dto;

public class ForecastDto {
    private Double latitude;
    private Double longitude;
    private String timezone;
    private Integer offset;
    private ForecastByHourDto hourly;

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public ForecastByHourDto getHourly() {
        return hourly;
    }

    public void setHourly(ForecastByHourDto hourly) {
        this.hourly = hourly;
    }
}
