package weather.dto;

public class ForecastByHourDto {
    private String summary;
    private String icon;
    private ForecastDataDto[] data;

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public ForecastDataDto[] getData() {
        return data;
    }

    public void setData(ForecastDataDto[] data) {
        this.data = data;
    }
}
