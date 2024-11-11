package RUT.vokzal.Controller;

import RUT.vokzal.DTO.RouteInDTO;
import RUT.vokzal.DTO.View.RouteOutDTO;
import RUT.vokzal.Service.RouteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/routes")
public class RouteController {

    private RouteService routeService;

    @Autowired
    public void setRouteService(RouteService routeService) {
        this.routeService = routeService;
    }

    @PostMapping
    public void createRoute(@Valid @RequestBody RouteInDTO routeInDTO) {
        routeService.createRoute(routeInDTO);
    }

    @GetMapping("/{id}")
    public RouteOutDTO getRouteById(@PathVariable Integer id) {
        return routeService.getRouteById(id);
    }

    @PutMapping("/{id}")
    public void updateRoute(@Valid @PathVariable Integer id, @RequestBody RouteInDTO routeInDTO) {
        routeService.updateRoute(id, routeInDTO);
    }

    @GetMapping
    public List<RouteOutDTO> getAllRoutes() {
        return routeService.getAllRoutes();
    }
}