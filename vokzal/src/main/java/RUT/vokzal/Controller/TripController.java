package RUT.vokzal.Controller;

import RUT.vokzal.Entity.Trip;
import RUT.vokzal.Service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trips")
public class TripController {

    private TripService tripService;

    public TripService getTripService() {
        return tripService;
    }

    @Autowired
    public void setTripService(TripService tripService) {
        this.tripService = tripService;
    }

    @PostMapping
    public void createTrip(@RequestBody Trip trip) {
        tripService.createTrip(trip);
    }

    @GetMapping("/{id}")
    public Trip getTripById(@PathVariable Integer id) {
        return tripService.getTripById(id);
    }

    @PutMapping("/{id}")
    public Trip updateTrip(@PathVariable Integer id, @RequestBody Trip trip) {
        trip.setId(id);
        return tripService.updateTrip(trip);
    }

    @GetMapping
    public List<Trip> getAllTrips() {
        return tripService.getAllTrips();
    }
}
