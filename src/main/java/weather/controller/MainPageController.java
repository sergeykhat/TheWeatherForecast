package weather.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import weather.model.City;
import weather.model.Forecast;
import weather.service.DarkSkyService;


@Controller
public class MainPageController {

    private DarkSkyService service;

    @Autowired
    public MainPageController(@Qualifier("CachedDarkSkyService") DarkSkyService service) {
        this.service = service;
    }


    @RequestMapping("/")
    public String loadMainPage(Model model) {
        fillModel(model, City.MOSCOW);
        return "main-page";
    }

    @RequestMapping(value = "/city/{city}")
    public String showForecastByCity(@PathVariable("city") String cityName, Model model) {
        try {
            fillModel(model, City.valueOf(cityName));
        } catch (IllegalArgumentException e) {
            model.addAttribute("cities", City.values());
            model.addAttribute("status", "error");
            model.addAttribute("errorDescription", "There is no such a city");
            model.addAttribute("currentCity", "");
        }
        return "main-page";
    }

    private void fillModel(Model model, City city) {
        Forecast forecast = service.getForecast(city);
        model.addAttribute("currentCity", city);
        model.addAttribute("cities", City.values());
        if (forecast.getStatus() == Forecast.Status.OK) {
            model.addAttribute("status", "ok");
            model.addAttribute("forecast", forecast.getHourlyForecasts());
            return;
        }
        model.addAttribute("status", "error");
        model.addAttribute("errorDescription", forecast.getStatus().getException().getMessage());
    }

}
