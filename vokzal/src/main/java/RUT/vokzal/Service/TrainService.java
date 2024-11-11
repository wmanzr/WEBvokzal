package RUT.vokzal.Service;

import RUT.vokzal.DTO.TrainInDTO;
import RUT.vokzal.DTO.View.TrainOutDTO;
import java.util.List;

public interface TrainService {
    void createTrain(TrainInDTO trainInDTO);
    TrainOutDTO getTrainById(Integer id);
    void updateTrain(int id, TrainInDTO trainInDTO);
    List<TrainOutDTO> getAllTrains();
}