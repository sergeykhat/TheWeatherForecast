package weather.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import weather.service.ForecastService;
import weather.dao.ForecastDao;
import weather.model.HourlyForecast;
import weather.data.City;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ForecastServiceImpl implements ForecastService {

    private ForecastDao dao;

    @Autowired
    public ForecastServiceImpl(ForecastDao dao) {
        this.dao = dao;
    }
    
    @Transactional
    public void create(HourlyForecast hourlyForecast) {
        dao.save(hourlyForecast);
    }

    @Transactional
    public void create(Iterable <HourlyForecast> hourlyForecasts) {
        dao.saveAll(hourlyForecasts);
    }

    public HourlyForecast get(City city) {
        return dao.get(city);
    }

    public List<HourlyForecast> getAll(City city) {
        return dao.getAll(city);
    }

    @Transactional
    public void update(HourlyForecast hourlyForecast){
        dao.save(hourlyForecast);
    }

    @Transactional
    public void deleteAll(City city) {
        dao.deleteAllByCity(city);
    }

}
