package RUT.vokzal.Service.Impl;

import RUT.vokzal.DTO.PlatformInDTO;
import RUT.vokzal.DTO.View.PlatformOutDTO;
import RUT.vokzal.Entity.Platform;
import RUT.vokzal.Repository.PlatformRepository;
import RUT.vokzal.Service.PlatformService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlatformServiceImpl implements PlatformService {

    private PlatformRepository platformRepository;
    private ModelMapper modelMapper;

    @Autowired
    public void setPlatformRepository(PlatformRepository platformRepository) {
        this.platformRepository = platformRepository;
    }

    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public void createPlatform(PlatformInDTO platformInDTO) {
        Platform platform = modelMapper.map(platformInDTO, Platform.class);
        platformRepository.create(platform);
    }

    @Override
    public PlatformOutDTO getPlatformById(Integer id) {
        Platform platform = platformRepository.findById(id);
        return modelMapper.map(platform, PlatformOutDTO.class);
    }

    @Override
    public void updatePlatform(int id, PlatformInDTO platformInDTO) {
        Platform platform = modelMapper.map(platformInDTO, Platform.class);
        platform.setId(id);
        platformRepository.update(platform);
    }

    @Override
    public List<PlatformOutDTO> getAllPlatforms() {
        List<PlatformOutDTO> result = new ArrayList<>();
        List<Platform> platforms = platformRepository.findAll();
        for (Platform platform : platforms) {
            result.add(modelMapper.map(platform, PlatformOutDTO.class));
        }
        return result;
    }
}
