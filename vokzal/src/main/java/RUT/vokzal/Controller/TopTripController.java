package RUT.vokzal.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import RUT.vokzal.DTO.TripInDTO;
import RUT.vokzal.Service.TopTripService;

@RestController
@RequestMapping("")
public class TopTripController {

    @Autowired
    private TopTripService topTripService;

    @GetMapping("/top-trips")
    public List<TripInDTO> getTop5Trips() {
        return topTripService.getTop5Trips();
    }
}
