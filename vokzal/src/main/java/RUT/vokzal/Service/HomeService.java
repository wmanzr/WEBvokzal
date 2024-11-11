package RUT.vokzal.Service;

import RUT.vokzal.DTO.TripInDTO;
import java.util.List;

public interface HomeService {
    List<TripInDTO> getUpcomingTripsWithTimeByStationName(String vokzalName);
    int getStationLoadByDayAndTime(String vokzalName);
    List<TripInDTO> getAlternativeTripsIfCanceled(); 
}