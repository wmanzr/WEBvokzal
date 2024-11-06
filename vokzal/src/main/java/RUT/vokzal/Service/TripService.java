package RUT.vokzal.Service;

import RUT.vokzal.Entity.Trip;
import java.util.List;

public interface TripService {
    void createTrip(Trip trip);
    Trip getTripById(Integer id);
    Trip updateTrip(Trip trip);
    List<Trip> getAllTrips();
}