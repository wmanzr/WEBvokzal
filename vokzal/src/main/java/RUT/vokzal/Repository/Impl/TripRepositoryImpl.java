package RUT.vokzal.Repository.Impl;

import java.time.LocalDate;
import java.time.LocalTime;
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
    public List<Trip> findUpcomingTripsWithTimeByStation(int stationId, LocalDate nowDate, LocalTime nowTime) {
    return entityManager.createQuery(
            "SELECT t " +
            "FROM Trip t JOIN t.route r " +
            "WHERE r.depPlId.vokzalId.id = :stationId " +
            "AND (t.dateDep > :nowDate OR (t.dateDep = :nowDate AND r.timeDep >= :nowTime)) " +
            "ORDER BY t.dateDep, r.timeDep", 
            Trip.class)
            .setParameter("stationId", stationId)
            .setParameter("nowDate", nowDate)
            .setParameter("nowTime", nowTime)
            .setMaxResults(5)
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
    public List<Trip> findAlternativeTrips(int routeId, LocalDate nowDate) {
    return entityManager.createQuery(
            "SELECT t FROM Trip t " +
            "WHERE t.route.id = :routeId " +
            "AND t.statusTrip <> :cancelled " +
            "AND t.dateDep > :nowDate " +
            "ORDER BY t.dateDep ASC", Trip.class)
            .setParameter("routeId", routeId)
            .setParameter("cancelled", StatusTrip.CANCELLED)
            .setParameter("nowDate", nowDate)
            .setMaxResults(1)
            .getResultList();
    }

@Override
public List<Trip> findTop5TripsWithMaxSpeedAndMinDuration() {
    List<Trip> trips = entityManager.createQuery(
        "SELECT t FROM Trip t " +
        "JOIN t.train tr " +
        "JOIN t.route r " +
        "WHERE t.dateDep IS NOT NULL AND t.dateArr IS NOT NULL " +
        "ORDER BY tr.maxSpeed DESC", 
        Trip.class)
        .setMaxResults(5)
        .getResultList();
    return trips;
    }
}