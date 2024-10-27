package RUT.vokzal.Repository.Impl;

import java.util.List;
import RUT.vokzal.Entity.Trip;
import RUT.vokzal.Repository.BaseRepository;
import RUT.vokzal.Repository.TripRepository;

public class TripRepositoryImpl extends BaseRepository<Trip, Integer> implements TripRepository {

    public TripRepositoryImpl() {
        super(Trip.class);
    }

    @Override
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
}