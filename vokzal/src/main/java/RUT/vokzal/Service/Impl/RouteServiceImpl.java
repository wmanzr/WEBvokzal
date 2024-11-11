package RUT.vokzal.Service.Impl;

import RUT.vokzal.DTO.RouteInDTO;
import RUT.vokzal.DTO.View.RouteOutDTO;
import RUT.vokzal.Entity.Route;
import RUT.vokzal.Repository.RouteRepository;
import RUT.vokzal.Service.RouteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RouteServiceImpl implements RouteService {

    private RouteRepository routeRepository;
    private ModelMapper modelMapper;

    @Autowired
    public void setRouteRepository(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public void createRoute(RouteInDTO routeInDTO) {
        Route route = modelMapper.map(routeInDTO, Route.class);
        routeRepository.create(route);
    }

    @Override
    public RouteOutDTO getRouteById(Integer id) {
        Route route = routeRepository.findById(id);
        return modelMapper.map(route, RouteOutDTO.class);
    }

    @Override
    public void updateRoute(int id, RouteInDTO routeInDTO) {
        Route route = modelMapper.map(routeInDTO, Route.class);
        route.setId(id);
        routeRepository.update(route);
    }

    @Override
    public List<RouteOutDTO> getAllRoutes() {
        List<RouteOutDTO> result = new ArrayList<>();
        List<Route> routes = routeRepository.findAll();
        for (Route route : routes) {
            result.add(modelMapper.map(route, RouteOutDTO.class));
        }
        return result;
    }
}