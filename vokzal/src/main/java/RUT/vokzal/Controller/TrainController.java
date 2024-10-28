package RUT.vokzal.Controller;

import RUT.vokzal.Entity.Train;
import RUT.vokzal.Repository.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/train")
public class TrainController {

    private final TrainRepository trainRepository;

    @Autowired
    public TrainController(TrainRepository trainRepository) {
        this.trainRepository = trainRepository;
    }

    @GetMapping
    public List<Train> getAllTrains() {
        return trainRepository.findAll();
    }
}
