package RUT.vokzal.Repository.Impl;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Repository;
import RUT.vokzal.Entity.StatusTrip;
import RUT.vokzal.Entity.Trip;
import RUT.vokzal.Repository.BaseRepository;
import RUT.vokzal.Repository.TripRepository;
import jakarta.transaction.Transactional;

@Repository
public class TripRepositoryImpl extends BaseRepository<Trip, Integer> implements TripRepository {

    public TripRepositoryImpl() {
        super(Trip.class);
    }

    @Override
    @Transactional
    public void create(Trip trip) {
        super.create(trip);
    }

    @Override
    public Trip findById(Integer id) {
        return super.findById(id);
    }

    @Override
    public Trip update(Trip trip) {
        return super.update(trip);
    }

    @Override
    public List<Trip> findAll() {
        return super.findAll();
    }

    @Override
    public List<Object[]> findUpcomingTripsWithTimeByStation(int stationId, LocalDateTime dateTime) {
        return entityManager.createQuery(
                "SELECT t.date, r.timeDep FROM Trip t JOIN t.route r WHERE r.depPlId.vokzalId.id = :stationId AND t.date >= :dateTime", Object[].class)
                .setParameter("stationId", stationId)
                .setParameter("dateTime", dateTime)
                .getResultList();
    }

    @Override
    public List<Trip> findCanceledTrips() {
        return entityManager.createQuery(
                "SELECT t FROM Trip t WHERE t.statusTrip = :cancelled", Trip.class)
                .setParameter("cancelled", StatusTrip.CANCELLED)
                .getResultList();
    }

    @Override
    public List<Trip> findAlternativeTrips(int routeId) {
        return entityManager.createQuery(
                "SELECT t FROM Trip t WHERE t.route.id = :routeId AND t.statusTrip <> :cancelled", Trip.class)
                .setParameter("routeId", routeId)
                .setParameter("cancelled", StatusTrip.CANCELLED)
                .getResultList();
    }

    @Override
    public List<Object[]> findTop5VokzalsByDepartures() {
        return entityManager.createQuery(
                "SELECT t.route.depPlId.vokzalId AS vokzal, COUNT(t) AS tripCount " +
                "FROM Trip t " +
                "WHERE t.date >= CURRENT_DATE - 7 " +
                "GROUP BY t.route.depPlId.vokzalId " +
                "ORDER BY tripCount DESC", Object[].class)
                .setMaxResults(5)
                .getResultList();
    }
}