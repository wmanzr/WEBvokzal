package RUT.vokzal.Service;

import RUT.vokzal.DTO.RouteInDTO;
import RUT.vokzal.DTO.View.RouteOutDTO;
import java.util.List;

public interface RouteService {
    void createRoute(RouteInDTO routeInDTO);
    RouteOutDTO getRouteById(Integer id);
    void updateRoute(int id, RouteInDTO routeInDTO);
    List<RouteOutDTO> getAllRoutes();
}