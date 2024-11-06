package RUT.vokzal.Controller;

import RUT.vokzal.Entity.Route;
import RUT.vokzal.Service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/routes")
public class RouteController {

    private RouteService routeService;

    public RouteService getRouteService() {
        return this.routeService;
    }

    @Autowired
    public void setRouteService(RouteService routeService) {
        this.routeService = routeService;
    }

    @PostMapping
    public void createRoute(@RequestBody Route route) {
        routeService.createRoute(route);
    }

    @GetMapping("/{id}")
    public Route getRouteById(@PathVariable Integer id) {
        return routeService.getRouteById(id);
    }

    @PutMapping("/{id}")
    public Route updateRoute(@PathVariable Integer id, @RequestBody Route route) {
        route.setId(id);
        return routeService.updateRoute(route);
    }

    @GetMapping
    public List<Route> getAllRoutes() {
        return routeService.getAllRoutes();
    }
}
