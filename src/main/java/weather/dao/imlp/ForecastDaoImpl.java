package weather.dao.imlp;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import weather.dao.ForecastDao;
import weather.data.City;
import weather.model.HourlyForecast;
import weather.repository.ForecastRepository;

import java.util.List;

@Repository
public class ForecastDaoImpl implements ForecastDao {


    private ForecastRepository repository;

    @Autowired
    public ForecastDaoImpl(ForecastRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(HourlyForecast hourlyForecast) {
        repository.save(hourlyForecast);
    }

    @Override
    public void saveAll(Iterable<HourlyForecast> hourlyForecast) {
        repository.saveAll(hourlyForecast);
    }

    @Override
    public HourlyForecast get(City city) {
        return repository.findByCity(city);
    }

    @Override
    public List<HourlyForecast> getAll(City city) {
        return Lists.newArrayList(repository.findAllByCity(city));
    }

    @Override
    public void deleteAllByCity(City city) {
        repository.deleteAllByCity(city);
    }
}
