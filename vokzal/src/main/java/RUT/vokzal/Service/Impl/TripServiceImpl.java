package RUT.vokzal.Service.Impl;

import RUT.vokzal.DTO.TripInDTO;
import RUT.vokzal.DTO.View.TripOutDTO;
import RUT.vokzal.Entity.Trip;
import RUT.vokzal.Repository.TripRepository;
import RUT.vokzal.Service.TripService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TripServiceImpl implements TripService {

    private TripRepository tripRepository;
    private ModelMapper modelMapper;

    @Autowired
    public void setTripRepository(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public void createTrip(TripInDTO tripInDTO) {
        Trip trip = modelMapper.map(tripInDTO, Trip.class);
        tripRepository.create(trip);
    }

    @Override
    public TripOutDTO getTripById(Integer id) {
        Trip trip = tripRepository.findById(id);
        return modelMapper.map(trip, TripOutDTO.class);
    }

    @Override
    public void updateTrip(int id, TripInDTO tripInDTO) {
        Trip trip = modelMapper.map(tripInDTO, Trip.class);
        trip.setId(id);
        tripRepository.update(trip);
    }

    @Override
    public List<TripOutDTO> getAllTrips() {
        List<TripOutDTO> result = new ArrayList<>();
        List<Trip> trips = tripRepository.findAll();
        for (Trip trip : trips) {
            result.add(modelMapper.map(trip, TripOutDTO.class));
        }
        return result;
    }
}
