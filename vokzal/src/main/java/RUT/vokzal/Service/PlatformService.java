package RUT.vokzal.Service;

import RUT.vokzal.Entity.Platform;
import java.util.List;

public interface PlatformService {
    void createPlatform(Platform platform);
    Platform getPlatformById(Integer id);
    Platform updatePlatform(Platform platform);
    List<Platform> getAllPlatforms();
}
