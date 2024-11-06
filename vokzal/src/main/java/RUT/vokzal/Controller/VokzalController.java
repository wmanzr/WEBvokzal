package RUT.vokzal.Controller;

import RUT.vokzal.Entity.Vokzal;
import RUT.vokzal.Service.VokzalService;
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

    public VokzalService getVokzalService() {
        return vokzalService;
    }

    @PostMapping
    public void createVokzal(@RequestBody Vokzal vokzal) {
        vokzalService.createVokzal(vokzal);
    }

    @GetMapping("/{id}")
    public Vokzal getVokzalById(@PathVariable Integer id) {
        return vokzalService.getVokzalById(id);
    }

    @PutMapping("/{id}")
    public Vokzal updateVokzal(@PathVariable Integer id, @RequestBody Vokzal vokzal) {
        vokzal.setId(id);
        return vokzalService.updateVokzal(vokzal);
    }

    @GetMapping
    public List<Vokzal> getAllVokzals() {
        return vokzalService.getAllVokzals();
    }
}