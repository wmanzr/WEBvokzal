package RUT.vokzal.Service.Impl;

import RUT.vokzal.DTO.TrainInDTO;
import RUT.vokzal.DTO.View.TrainOutDTO;
import RUT.vokzal.Entity.Train;
import RUT.vokzal.Repository.TrainRepository;
import RUT.vokzal.Service.TrainService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrainServiceImpl implements TrainService {

    private TrainRepository trainRepository;
    private ModelMapper modelMapper;

    @Autowired
    public void setTrainRepository(TrainRepository trainRepository) {
        this.trainRepository = trainRepository;
    }

    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public void createTrain(TrainInDTO trainInDTO) {
        Train train = modelMapper.map(trainInDTO, Train.class);
        trainRepository.create(train);
    }

    @Override
    public TrainOutDTO getTrainById(Integer id) {
        Train train = trainRepository.findById(id);
        return modelMapper.map(train, TrainOutDTO.class);
    }

    @Override
    public void updateTrain(int id, TrainInDTO trainInDTO) {
        Train train = modelMapper.map(trainInDTO, Train.class);
        train.setId(id);
        trainRepository.update(train);
    }

    @Override
    public List<TrainOutDTO> getAllTrains() {
        List<TrainOutDTO> result = new ArrayList<>();
        List<Train> trains = trainRepository.findAll();
        for (Train train : trains) {
            result.add(modelMapper.map(train, TrainOutDTO.class));
        }
        return result;
    }
}