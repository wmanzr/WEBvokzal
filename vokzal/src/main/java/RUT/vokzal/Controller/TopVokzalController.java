package RUT.vokzal.Controller;

import RUT.vokzal.Service.TopVokzalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import RUT.vokzal.DTO.VokzalDTO;
import java.util.List;

@RestController
@RequestMapping("")
public class TopVokzalController {

    @Autowired
    private TopVokzalService topVokzalService;

    @GetMapping("/top-vokzal")
    public List<VokzalDTO> getTop5VokzalsByDepartures() {
        return topVokzalService.getTop5VokzalsByDepartures();
    }
}