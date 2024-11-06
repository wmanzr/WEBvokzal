package RUT.vokzal.Service.Impl;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import RUT.vokzal.DTO.TripDTO;
import RUT.vokzal.Entity.Trip;
import RUT.vokzal.Repository.TripRepository;
import RUT.vokzal.Service.TopTripService;

@Service
public class TopTripServiceImpl implements TopTripService{

private ModelMapper modelMapper;

    public ModelMapper getModelMapper() {
        return this.modelMapper;
    }

    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Autowired
    private TripRepository tripRepository;

    @Override
    public List<TripDTO> getTop5Trips() {
        List<Trip> trips = tripRepository.findTop5TripsWithMaxSpeedAndMinDuration();

        List<TripDTO> tripSort = trips.stream()
            .sorted((trip1, trip2) -> {

                LocalDateTime departureDateTime1 = LocalDateTime.of(trip1.getDateDep(), trip1.getRoute().getTimeDep());
                LocalDateTime arrivalDateTime1 = LocalDateTime.of(trip1.getDateArr(), trip1.getRoute().getTimeArr());
                LocalDateTime departureDateTime2 = LocalDateTime.of(trip2.getDateDep(), trip2.getRoute().getTimeDep());
                LocalDateTime arrivalDateTime2 = LocalDateTime.of(trip2.getDateArr(), trip2.getRoute().getTimeArr());

                Duration duration1 = Duration.between(departureDateTime1, arrivalDateTime1);
                Duration duration2 = Duration.between(departureDateTime2, arrivalDateTime2);

                return Long.compare(duration1.getSeconds(), duration2.getSeconds());
            })
            .map(trip -> modelMapper.map(trip, TripDTO.class))
            .collect(Collectors.toList());

        return tripSort;
    }
}