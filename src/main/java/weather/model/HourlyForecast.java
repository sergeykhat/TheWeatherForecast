package weather.model;

import weather.data.City;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table (name = "hourly_forecast")
public class HourlyForecast {

    @Id
    @Column
    @GeneratedValue (strategy = GenerationType.AUTO)
    private long id;

    @Column (name = "city")
    @Enumerated(EnumType.STRING)
    private City city;

    @Column (name = "temperature")
    private int temperature;

    @Column (name = "humidity")
    private double humidity;

    @Column (name = "pressure")
    private int pressure;

    @Column (name = "wind_speed")
    private int windSpeed;

    @Column (name ="icon")
    private String icon;

    @Column (name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

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

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
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
}
