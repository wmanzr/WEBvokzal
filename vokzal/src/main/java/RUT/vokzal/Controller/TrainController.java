package RUT.vokzal.Controller;

import RUT.vokzal.Entity.Train;
import RUT.vokzal.Service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trains")
public class TrainController {

    private TrainService trainService;

    public TrainService getTrainService() {
        return this.trainService;
    }

    @Autowired
    public void setTrainService(TrainService trainService) {
        this.trainService = trainService;
    }

    @PostMapping
    public void createTrain(@RequestBody Train train) {
        trainService.createTrain(train);
    }

    @GetMapping("/{id}")
    public Train getTrainById(@PathVariable Integer id) {
        return trainService.getTrainById(id);
    }

    @PutMapping("/{id}")
    public Train updateTrain(@PathVariable Integer id, @RequestBody Train train) {
        train.setId(id);
        return trainService.updateTrain(train);
    }

    @GetMapping
    public List<Train> getAllTrains() {
        return trainService.getAllTrains();
    }
}