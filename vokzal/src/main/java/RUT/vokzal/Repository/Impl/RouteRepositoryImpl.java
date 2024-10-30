package RUT.vokzal.Repository.Impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import RUT.vokzal.Entity.Route;
import RUT.vokzal.Repository.BaseRepository;
import RUT.vokzal.Repository.RouteRepository;
import jakarta.transaction.Transactional;

@Repository
public class RouteRepositoryImpl extends BaseRepository<Route, Integer> implements RouteRepository {

    public RouteRepositoryImpl() {
        super(Route.class);
    }

    @Override
    @Transactional
    public void create(Route route) {
        super.create(route);
    }

    @Override
    public Route findById(Integer id) {
        return super.findById(id);
    }

    @Override
    public Route update(Route route) {
        return super.update(route);
    }

    @Override
    public List<Route> findAll() {
        return super.findAll();
    }
}