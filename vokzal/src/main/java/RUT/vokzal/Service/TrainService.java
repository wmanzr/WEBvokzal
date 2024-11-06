package RUT.vokzal.Service;

import RUT.vokzal.Entity.Train;
import java.util.List;

public interface TrainService {
    void createTrain(Train train);
    Train getTrainById(Integer id);
    Train updateTrain(Train train);
    List<Train> getAllTrains();
}
