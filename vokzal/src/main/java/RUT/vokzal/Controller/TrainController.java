package RUT.vokzal.Controller;

import RUT.vokzal.DTO.TrainInDTO;
import RUT.vokzal.DTO.View.TrainOutDTO;
import RUT.vokzal.Service.TrainService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trains")
public class TrainController {

    private TrainService trainService;

    @Autowired
    public void setTrainService(TrainService trainService) {
        this.trainService = trainService;
    }

    @PostMapping
    public void createTrain(@Valid @RequestBody TrainInDTO trainInDTO) {
        trainService.createTrain(trainInDTO);
    }

    @GetMapping("/{id}")
    public TrainOutDTO getTrainById(@PathVariable Integer id) {
        return trainService.getTrainById(id);
    }

    @PutMapping("/{id}")
    public void updateTrain(@Valid @PathVariable Integer id, @RequestBody TrainInDTO trainInDTO) {
        trainService.updateTrain(id, trainInDTO);
    }

    @GetMapping
    public List<TrainOutDTO> getAllTrains() {
        return trainService.getAllTrains();
    }
}