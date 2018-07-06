package weather.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table (name = "hourly_forecast")
@SuppressWarnings("unused")
public class HourlyForecast {

    @Id
    @Column
    @JsonIgnore
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;

    @Column (name = "city")
    @Enumerated(EnumType.STRING)
    private City city;

    @Column (name = "temperature")
    private int temperature;

    @Column (name = "humidity")
    private int humidity;

    @Column (name = "pressure")
    private int pressure;

    @Column (name = "wind_speed")
    private int windSpeed;

    @Column (name ="icon")
    private String icon;

    @Column (name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @JsonIgnore
    private Long time;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public int getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(int windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

}
