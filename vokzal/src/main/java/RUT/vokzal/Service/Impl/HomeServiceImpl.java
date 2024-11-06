package RUT.vokzal.Service.Impl;

import RUT.vokzal.DTO.TripDTO;
import RUT.vokzal.Entity.Trip;
import RUT.vokzal.Entity.Vokzal;
import RUT.vokzal.Repository.TripRepository;
import RUT.vokzal.Repository.VokzalRepository;
import RUT.vokzal.Service.HomeService;
import jakarta.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.stream.Collectors;

@Service
public class HomeServiceImpl implements HomeService {

    @Autowired
    private TripRepository tripRepository;

    @Autowired
    private VokzalRepository vokzalRepository;

    private ModelMapper modelMapper;

    public ModelMapper getModelMapper() {
        return this.modelMapper;
    }

    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public List<TripDTO> getUpcomingTripsWithTimeByStationName(String vokzalName) {
    Vokzal vokzal = vokzalRepository.findByName(vokzalName);
    LocalDate nowDate = LocalDate.now();
    LocalTime nowTime = LocalTime.now();

    if (vokzal == null) {
        throw new EntityNotFoundException("Вокзал с именем " + vokzalName + " не найден.");
    }
    
    List<Trip> upcomingTrips = tripRepository.findUpcomingTripsWithTimeByStation(vokzal.getId(), nowDate, nowTime);

    return upcomingTrips.stream()
            .map(trip -> modelMapper.map(trip, TripDTO.class))
            .collect(Collectors.toList());
    }

    @Override
    public int getStationLoadByDayAndTime(String vokzalName) {
    Vokzal vokzal = vokzalRepository.findByName(vokzalName);
    if (vokzal == null) {
        throw new IllegalArgumentException("Вокзал с таким названием не найден");
    }

    LocalTime currentTime = LocalTime.now();
    DayOfWeek currentDay = LocalDate.now().getDayOfWeek();
    int loadPercentage;

    if (currentDay != DayOfWeek.SATURDAY && currentDay != DayOfWeek.SUNDAY) {
        if (currentTime.isAfter(LocalTime.of(0, 0)) && currentTime.isBefore(LocalTime.of(7, 0))) {
            loadPercentage = 10;
        } else if (currentTime.isAfter(LocalTime.of(7, 0)) && currentTime.isBefore(LocalTime.of(10, 0))) {
            loadPercentage = 90;
        } else if (currentTime.isAfter(LocalTime.of(10, 0)) && currentTime.isBefore(LocalTime.of(16, 0))) {
            loadPercentage = 45;
        } else if (currentTime.isAfter(LocalTime.of(16, 0)) && currentTime.isBefore(LocalTime.of(18, 0))) {
            loadPercentage = 85;
        } else if (currentTime.isAfter(LocalTime.of(18, 0)) && currentTime.isBefore(LocalTime.of(22, 0))) {
            loadPercentage = 50;
        } else {
            loadPercentage = 20;
        }
    } else {
        if (currentTime.isAfter(LocalTime.of(0, 0)) && currentTime.isBefore(LocalTime.of(10, 0))) {
            loadPercentage = 25;
        } else if (currentTime.isAfter(LocalTime.of(10, 0)) && currentTime.isBefore(LocalTime.of(18, 0))) {
            loadPercentage = 65;
        } else if (currentTime.isAfter(LocalTime.of(18, 0)) && currentTime.isBefore(LocalTime.of(22, 0))) {
            loadPercentage = 50;
        } else {
            loadPercentage = 40;
        }
    }

    return loadPercentage;
}

    @Override
    public List<TripDTO> getAlternativeTripsIfCanceled() {
    LocalDate nowDate = LocalDate.now();
    List<Trip> canceledTrips = tripRepository.findCanceledTrips();

    List<TripDTO> alternativeTrips = new ArrayList<>();
    
    for (Trip canceledTrip : canceledTrips) {

        List<Trip> alternatives = tripRepository.findAlternativeTrips(canceledTrip.getRoute().getId(), nowDate);
        
        if (alternatives.isEmpty()) {
            alternativeTrips.add(null);
        } else {
            alternatives.stream()
                .map(alternativeTrip -> modelMapper.map(alternativeTrip, TripDTO.class))
                .forEach(alternativeTrips::add);
        }
    }
    return alternativeTrips;
    }
}