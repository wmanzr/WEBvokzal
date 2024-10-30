package RUT.vokzal.Service.Impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import RUT.vokzal.Repository.TripRepository;
import RUT.vokzal.Service.TopVokzalService;

@Service
public class TopVokzalServiceImpl implements TopVokzalService{

    @Autowired
    private TripRepository tripRepository;

    @Override
    public List<Object[]> getTop5VokzalsByDepartures() {
        return tripRepository.findTop5VokzalsByDepartures();
    }
}
