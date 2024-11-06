package RUT.vokzal.Service.Impl;

import RUT.vokzal.Entity.Trip;
import RUT.vokzal.Repository.TripRepository;
import RUT.vokzal.Service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripServiceImpl implements TripService {

    private TripRepository tripRepository;

    public TripRepository getTripRepository() {
        return tripRepository;
    }

    @Autowired
    public void setTripRepository(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    @Override
    public void createTrip(Trip trip) {
        tripRepository.create(trip);
    }

    @Override
    public Trip getTripById(Integer id) {
        return tripRepository.findById(id);
    }

    @Override
    public Trip updateTrip(Trip trip) {
        return tripRepository.update(trip);
    }

    @Override
    public List<Trip> getAllTrips() {
        return tripRepository.findAll();
    }
}
