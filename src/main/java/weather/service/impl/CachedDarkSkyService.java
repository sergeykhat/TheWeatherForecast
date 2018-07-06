package weather.service.impl;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import weather.service.DarkSkyService;
import weather.model.Forecast;
import weather.model.City;

@Service
@Qualifier("CachedDarkSkyService")
public class CachedDarkSkyService implements DarkSkyService {

    private LoadingCache<City, Forecast> cache;

    @Autowired
    private void init(DarkSkyServiceImpl darkSkyService, CacheBuilder<Object, Object> builder) {
        cache = builder.build(CacheLoader.from(city -> darkSkyService.getForecast(city)));
    }

    @Override
    public Forecast getForecast(City city) {
        Forecast forecast = cache.getUnchecked(city);
        if (forecast.getStatus() == Forecast.Status.ERROR) {
            cache.cleanUp();
        }
        return forecast;
    }

}
