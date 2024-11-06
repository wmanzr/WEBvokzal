package RUT.vokzal.Service.Impl;

import RUT.vokzal.Entity.Train;
import RUT.vokzal.Repository.TrainRepository;
import RUT.vokzal.Service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainServiceImpl implements TrainService {

    private TrainRepository trainRepository;

    public TrainRepository getTrainRepository() {
        return this.trainRepository;
    }

    @Autowired
    public void setTrainRepository(TrainRepository trainRepository) {
        this.trainRepository = trainRepository;
    }

    @Override
    public void createTrain(Train train) {
        trainRepository.create(train);
    }

    @Override
    public Train getTrainById(Integer id) {
        return trainRepository.findById(id);
    }

    @Override
    public Train updateTrain(Train train) {
        return trainRepository.update(train);
    }

    @Override
    public List<Train> getAllTrains() {
        return trainRepository.findAll();
    }
}