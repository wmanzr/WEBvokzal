package RUT.vokzal.Service.Impl;

import RUT.vokzal.Entity.Trip;
import RUT.vokzal.Entity.Vokzal;
import RUT.vokzal.Repository.TripRepository;
import RUT.vokzal.Repository.VokzalRepository;
import RUT.vokzal.Service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.stream.Collectors;

@Service
public class HomeServiceImpl implements HomeService {

    @Autowired
    private TripRepository tripRepository;

    @Autowired
    private VokzalRepository vokzalRepository;

    @Override
    public List<Object[]> getUpcomingTripsWithTimeByStationName(String vokzalName) {
        Vokzal vokzal = vokzalRepository.findByName(vokzalName);
        LocalDateTime now = LocalDateTime.now();
        return tripRepository.findUpcomingTripsWithTimeByStation(vokzal.getId(), now);
    }

    @Override
public int getStationLoadByDayAndTime(String vokzalName) {
    // Находим вокзал по названию
    Vokzal vokzal = vokzalRepository.findByName(vokzalName);
    if (vokzal == null) {
        throw new IllegalArgumentException("Вокзал с таким названием не найден");
    }

    LocalTime currentTime = LocalTime.now();
    DayOfWeek currentDay = LocalDateTime.now().getDayOfWeek();
    int loadPercentage;

    if (currentDay != DayOfWeek.SATURDAY && currentDay != DayOfWeek.SUNDAY) {
        // Будние дни
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
            loadPercentage = 20; // с 22:00 до 0:00
        }
    } else {
        // Выходные дни
        if (currentTime.isAfter(LocalTime.of(0, 0)) && currentTime.isBefore(LocalTime.of(10, 0))) {
            loadPercentage = 25;
        } else if (currentTime.isAfter(LocalTime.of(10, 0)) && currentTime.isBefore(LocalTime.of(18, 0))) {
            loadPercentage = 65;
        } else if (currentTime.isAfter(LocalTime.of(18, 0)) && currentTime.isBefore(LocalTime.of(22, 0))) {
            loadPercentage = 50;
        } else {
            loadPercentage = 40; // с 22:00 до 0:00
        }
    }

    return loadPercentage;
}


    @Override
    public List<Trip> getAlternativeTripsIfCanceled() {
        List<Trip> canceledTrips = tripRepository.findCanceledTrips();
        return canceledTrips.stream()
                .flatMap(canceledTrip -> tripRepository.findAlternativeTrips(canceledTrip.getRoute().getId()).stream())
                .collect(Collectors.toList());
    }
}