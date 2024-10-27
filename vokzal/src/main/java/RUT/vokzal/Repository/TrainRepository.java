package RUT.vokzal.Repository;

import java.util.List;
import RUT.vokzal.Entity.Train;

public interface TrainRepository {
    public void create(Train employee);
    public Train findById(Integer id);
    public Train update(Train employee);
    public List<Train> findAll();
}