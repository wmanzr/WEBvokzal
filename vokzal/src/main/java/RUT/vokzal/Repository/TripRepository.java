package RUT.vokzal.Repository;

import java.time.LocalDateTime;
import java.util.List;
import RUT.vokzal.Entity.Trip;

public interface TripRepository {
    public void create(Trip trip);
    public Trip findById(Integer id);
    public Trip update(Trip trip);
    public List<Trip> findAll();
    List<Object[]> findUpcomingTripsWithTimeByStation(int stationId, LocalDateTime dateTime);
    List<Trip> findCanceledTrips();
    List<Trip> findAlternativeTrips(int routeId);
    List<Object[]> findTop5VokzalsByDepartures();
}