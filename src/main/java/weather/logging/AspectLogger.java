package weather.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.logging.Level;
import java.util.logging.Logger;

@Aspect
@Component
public class AspectLogger {

    private Logger logger = Logger.getLogger(AspectLogger.class.getName());

    @Before("execution(* weather.service.impl.ForecastServiceImpl.*(..)) || " +
            "execution(* weather.utils.Converter.*(..)) || " +
            "execution(* weather.service.request.DarkSkyConnection.*(..))")
    public void logBefore(JoinPoint point) {
        logger.log(Level.INFO, "Calling method " + point.getSignature().getName() + " from " + point.getTarget().getClass());

    }

    @After("execution(* weather.service.impl.ForecastServiceImpl.*(..)) || " +
            "execution(* weather.utils.Converter.*(..)) || " +
            "execution(* weather.service.request.DarkSkyConnection.*(..))")
    public void logAfter(JoinPoint point) {
        logger.log(Level.INFO, "Call " + point.getSignature().getName() + " has been completed");

    }

    @AfterThrowing(value = "execution(* weather.service.request.DarkSkyConnection.*(..)) || ", throwing = "ex")
    public void logException(JoinPoint point, Exception ex) {
        logger.log(Level.WARNING, "Exception during calling method: " + point.getSignature().getName() + " ", ex);
    }

}
