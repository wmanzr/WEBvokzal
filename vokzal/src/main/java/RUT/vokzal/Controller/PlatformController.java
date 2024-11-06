package RUT.vokzal.Controller;

import RUT.vokzal.Entity.Platform;
import RUT.vokzal.Service.PlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/platforms")
public class PlatformController {

    private PlatformService platformService;

    public PlatformService getPlatformService() {
        return this.platformService;
    }

    @Autowired
    public void setPlatformService(PlatformService platformService) {
        this.platformService = platformService;
    }

    @PostMapping
    public void createPlatform(@RequestBody Platform platform) {
        platformService.createPlatform(platform);
    }

    @GetMapping("/{id}")
    public Platform getPlatformById(@PathVariable Integer id) {
        return platformService.getPlatformById(id);
    }

    @PutMapping("/{id}")
    public Platform updatePlatform(@PathVariable Integer id, @RequestBody Platform platform) {
        platform.setId(id);
        return platformService.updatePlatform(platform);
    }

    @GetMapping
    public List<Platform> getAllPlatforms() {
        return platformService.getAllPlatforms();
    }
}
