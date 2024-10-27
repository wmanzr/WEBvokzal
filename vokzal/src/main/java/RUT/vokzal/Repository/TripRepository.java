package RUT.vokzal.Repository;

import java.util.List;
import RUT.vokzal.Entity.Trip;

public interface TripRepository {
    public void create(Trip trip);
    public Trip findById(Integer id);
    public Trip update(Trip trip);
    public List<Trip> findAll();
}