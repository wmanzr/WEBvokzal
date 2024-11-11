package RUT.vokzal.Service;

import RUT.vokzal.DTO.TripInDTO;
import RUT.vokzal.DTO.View.TripOutDTO;
import java.util.List;

public interface TripService {
    void createTrip(TripInDTO tripInDTO);
    TripOutDTO getTripById(Integer id);
    void updateTrip(int id, TripInDTO tripInDTO);
    List<TripOutDTO> getAllTrips();
}