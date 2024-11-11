package RUT.vokzal.Service;

import java.util.List;
import RUT.vokzal.DTO.VokzalInDTO;

public interface TopVokzalService {
    List<VokzalInDTO> getTop5VokzalsByDepartures();
}