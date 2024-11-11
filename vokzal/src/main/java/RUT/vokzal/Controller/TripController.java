package RUT.vokzal.Controller;

import RUT.vokzal.DTO.TripInDTO;
import RUT.vokzal.DTO.View.TripOutDTO;
import RUT.vokzal.Service.TripService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trips")
public class TripController {

    private TripService tripService;

    @Autowired
    public void setTripService(TripService tripService) {
        this.tripService = tripService;
    }

    @PostMapping
    public void createTrip(@Valid @RequestBody TripInDTO tripInDTO) {
        tripService.createTrip(tripInDTO);
    }

    @GetMapping("/{id}")
    public TripOutDTO getTripById(@PathVariable Integer id) {
        return tripService.getTripById(id);
    }

    @PutMapping("/{id}")
    public void updateTrip(@Valid @PathVariable Integer id, @RequestBody TripInDTO tripInDTO) {
        tripService.updateTrip(id, tripInDTO);
    }

    @GetMapping
    public List<TripOutDTO> getAllTrips() {
        return tripService.getAllTrips();
    }
}
