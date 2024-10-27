package RUT.vokzal.Repository;

import java.util.List;
import RUT.vokzal.Entity.Route;

public interface RouteRepository {
    public void create(Route employee);
    public Route findById(Integer id);
    public Route update(Route employee);
    public List<Route> findAll();
}