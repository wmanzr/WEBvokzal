package RUT.vokzal.Controller;

import RUT.vokzal.DTO.PlatformInDTO;
import RUT.vokzal.DTO.View.PlatformOutDTO;
import RUT.vokzal.Service.PlatformService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/platforms")
public class PlatformController {

    private PlatformService platformService;

    @Autowired
    public void setPlatformService(PlatformService platformService) {
        this.platformService = platformService;
    }

    @PostMapping
    public void createPlatform(@Valid @RequestBody PlatformInDTO platformInDTO) {
        platformService.createPlatform(platformInDTO);
    }

    @GetMapping("/{id}")
    public PlatformOutDTO getPlatformById(@PathVariable Integer id) {
        return platformService.getPlatformById(id);
    }

    @PutMapping("/{id}")
    public void updatePlatform(@Valid @PathVariable Integer id, @RequestBody PlatformInDTO platformInDTO) {
        platformService.updatePlatform(id, platformInDTO);
    }

    @GetMapping
    public List<PlatformOutDTO> getAllPlatforms() {
        return platformService.getAllPlatforms();
    }
}
