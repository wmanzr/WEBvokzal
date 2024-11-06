package RUT.vokzal.Service;

import RUT.vokzal.Entity.Route;
import java.util.List;

public interface RouteService {
    void createRoute(Route route);
    Route getRouteById(Integer id);
    Route updateRoute(Route route);
    List<Route> getAllRoutes();
}
