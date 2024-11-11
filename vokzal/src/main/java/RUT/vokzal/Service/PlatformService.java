package RUT.vokzal.Service;

import RUT.vokzal.DTO.PlatformInDTO;
import RUT.vokzal.DTO.View.PlatformOutDTO;
import java.util.List;

public interface PlatformService {
    void createPlatform(PlatformInDTO platformInDTO);
    PlatformOutDTO getPlatformById(Integer id);
    void updatePlatform(int id, PlatformInDTO platformInDTO);
    List<PlatformOutDTO> getAllPlatforms();
}
