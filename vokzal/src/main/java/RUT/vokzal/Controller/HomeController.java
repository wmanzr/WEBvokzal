package RUT.vokzal.Controller;

import RUT.vokzal.DTO.TripInDTO;
import RUT.vokzal.Service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("")
public class HomeController {

    @Autowired
    private HomeService homeService;

    @GetMapping("/upcoming-trips")
    public List<TripInDTO> getUpcomingTripsWithTime(@RequestParam String vokzalName) {
        return homeService.getUpcomingTripsWithTimeByStationName(vokzalName);
    }

    @GetMapping("/vokzal-load")
    public int getStationLoad(@RequestParam String vokzalName) {
        return homeService.getStationLoadByDayAndTime(vokzalName);
    }

    @GetMapping("/alternative-trips")
    public List<TripInDTO> getAlternativeTripsIfCanceled() {
        return homeService.getAlternativeTripsIfCanceled();
    }
}