package RUT.vokzal.Service.Impl;

import RUT.vokzal.Entity.Route;
import RUT.vokzal.Repository.RouteRepository;
import RUT.vokzal.Service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteServiceImpl implements RouteService {

    private RouteRepository routeRepository;

    public RouteRepository getRouteRepository() {
        return this.routeRepository;
    }
    
    @Autowired
    public void setRouteRepository(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    @Override
    public void createRoute(Route route) {
        routeRepository.create(route);
    }

    @Override
    public Route getRouteById(Integer id) {
        return routeRepository.findById(id);
    }

    @Override
    public Route updateRoute(Route route) {
        return routeRepository.update(route);
    }

    @Override
    public List<Route> getAllRoutes() {
        return routeRepository.findAll();
    }
}
