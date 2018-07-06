package weather.service.impl;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import weather.model.City;
import weather.model.HourlyForecast;
import weather.dao.ForecastRepository;
import weather.service.ForecastService;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ForecastServiceImpl implements ForecastService {

    private ForecastRepository repository;

    @Autowired
    public ForecastServiceImpl(ForecastRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public void create(HourlyForecast hourlyForecast) {
        repository.save(hourlyForecast);
    }

    @Transactional
    public void create(Iterable<HourlyForecast> hourlyForecasts) {
        repository.saveAll(hourlyForecasts);
    }

    public HourlyForecast get(City city) {
        return repository.findByCity(city);
    }

    public List<HourlyForecast> getAll(City city) {
        return Lists.newArrayList(repository.findAllByCity(city));
    }

    @Transactional
    public void update(HourlyForecast hourlyForecast) {
        repository.save(hourlyForecast);
    }

    @Transactional
    public void deleteAll(City city) {
        repository.deleteAllByCity(city);
    }

}
