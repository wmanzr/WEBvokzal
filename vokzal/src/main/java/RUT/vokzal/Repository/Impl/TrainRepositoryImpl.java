package RUT.vokzal.Repository.Impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import RUT.vokzal.Entity.Train;
import RUT.vokzal.Repository.BaseRepository;
import RUT.vokzal.Repository.TrainRepository;

@Repository
public class TrainRepositoryImpl extends BaseRepository<Train, Integer> implements TrainRepository {

    public TrainRepositoryImpl() {
        super(Train.class);
    }

    @Override
    public void create(Train train) {
        super.create(train);
    }

    @Override
    public Train findById(Integer id) {
        return super.findById(id);
    }

    @Override
    public Train update(Train train) {
        return super.update(train);
    }

    @Override
    public List<Train> findAll() {
        return super.findAll();
    }
}