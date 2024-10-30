package RUT.vokzal.Controller;

import RUT.vokzal.Entity.Trip;
import RUT.vokzal.Service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("")
public class HomeController {

    @Autowired
    private HomeService homeService;

    /**
     * Получение ближайших поездок с датой и временем отправления по названию вокзала.
     * @param vokzalName название вокзала
     * @return Список объектов, содержащих дату поездки и время отправления
     */
    @GetMapping("/upcoming-trips")
    public List<Object[]> getUpcomingTripsWithTime(@RequestParam String vokzalName) {
        return homeService.getUpcomingTripsWithTimeByStationName(vokzalName);
    }

    /**
     * Получение загруженности вокзала по названию, учитывая день недели и время.
     * @param vokzalName название вокзала
     * @return процент загруженности вокзала
     */
    @GetMapping("/station-load")
    public int getStationLoad(@RequestParam String vokzalName) {
        return homeService.getStationLoadByDayAndTime(vokzalName);
    }

    /**
     * Получение альтернативных поездок для отмененной поездки, если такие имеются.
     * @return Список альтернативных поездок
     */
    @GetMapping("/alternative-trips")
    public List<Trip> getAlternativeTripsIfCanceled() {
        return homeService.getAlternativeTripsIfCanceled();
    }
}