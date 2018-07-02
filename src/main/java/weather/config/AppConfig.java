package weather.config;

import com.google.common.cache.CacheBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import java.util.concurrent.TimeUnit;


@Configuration
@PropertySource(value = {"classpath:darksky.properties"})
public class AppConfig {

    @Bean
    CacheBuilder<Object, Object> builder(@Value("${darksky.cache.concurrencyLevel}") int concurrencyLevel,
                                         @Value("${darksky.cache.expireAfterWrite}") long expireAfterWrite) {
        return CacheBuilder.newBuilder()
                .concurrencyLevel(concurrencyLevel)
                .expireAfterWrite(expireAfterWrite, TimeUnit.SECONDS);
    }

}
