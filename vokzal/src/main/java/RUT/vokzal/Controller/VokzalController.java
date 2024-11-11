package RUT.vokzal.Controller;

import RUT.vokzal.DTO.VokzalInDTO;
import RUT.vokzal.DTO.View.VokzalOutDTO;
import RUT.vokzal.Service.VokzalService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vokzals")
public class VokzalController {

    private VokzalService vokzalService;

    @Autowired
    public void setVokzalService(VokzalService vokzalService) {
        this.vokzalService = vokzalService;
    }

    @PostMapping
    public void createVokzal(@Valid @RequestBody VokzalInDTO vokzalInDTO) {
        vokzalService.createVokzal(vokzalInDTO);
    }

    @GetMapping("/{id}")
    public VokzalOutDTO getVokzalById(@PathVariable Integer id) {
        return vokzalService.getVokzalById(id);
    }

    @PutMapping("/{id}")
    public void updateVokzal(@Valid @PathVariable Integer id, @RequestBody VokzalInDTO vokzalInDTO) {
        vokzalService.updateVokzal(id, vokzalInDTO);
    }

    @GetMapping
    public List<VokzalOutDTO> getAllVokzals() {
        return vokzalService.getAllVokzals();
    }
}