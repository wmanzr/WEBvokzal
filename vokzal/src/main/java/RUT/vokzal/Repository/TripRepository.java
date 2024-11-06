package RUT.vokzal.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import RUT.vokzal.Entity.Trip;

public interface TripRepository {
    public void create(Trip trip);
    public Trip findById(Integer id);
    public Trip update(Trip trip);
    public List<Trip> findAll();
    List<Trip> findUpcomingTripsWithTimeByStation(int stationId, LocalDate nowDate, LocalTime nowTime);
    List<Trip> findCanceledTrips();
    List<Trip> findAlternativeTrips(int routeId, LocalDate nowDate);
    List<Trip> findTop5TripsWithMaxSpeedAndMinDuration();
}