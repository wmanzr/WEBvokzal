package RUT.vokzal.Service;

import RUT.vokzal.Entity.Trip;
import java.util.List;

public interface HomeService {
    List<Object[]> getUpcomingTripsWithTimeByStationName(String vokzalName);
    int getStationLoadByDayAndTime(String vokzalName);
    List<Trip> getAlternativeTripsIfCanceled(); 
}