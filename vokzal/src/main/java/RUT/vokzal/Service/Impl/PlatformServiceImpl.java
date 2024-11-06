package RUT.vokzal.Service.Impl;

import RUT.vokzal.Entity.Platform;
import RUT.vokzal.Repository.PlatformRepository;
import RUT.vokzal.Service.PlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlatformServiceImpl implements PlatformService {

    private PlatformRepository platformRepository;

    public PlatformRepository getPlatformRepository() {
        return this.platformRepository;
    }

    @Autowired
    public void setPlatformRepository(PlatformRepository platformRepository) {
        this.platformRepository = platformRepository;
    }

    @Override
    public void createPlatform(Platform platform) {
        platformRepository.create(platform);
    }

    @Override
    public Platform getPlatformById(Integer id) {
        return platformRepository.findById(id);
    }

    @Override
    public Platform updatePlatform(Platform platform) {
        return platformRepository.update(platform);
    }

    @Override
    public List<Platform> getAllPlatforms() {
        return platformRepository.findAll();
    }
}
