package RUT.vokzal.Service;

import java.util.List;

import RUT.vokzal.DTO.TripInDTO;

public interface TopTripService {
    List<TripInDTO> getTop5Trips();
}