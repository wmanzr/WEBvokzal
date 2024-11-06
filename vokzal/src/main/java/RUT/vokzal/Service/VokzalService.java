package RUT.vokzal.Service;

import RUT.vokzal.Entity.Vokzal;
import java.util.List;

public interface VokzalService {
    void createVokzal(Vokzal vokzal);
    Vokzal getVokzalById(Integer id);
    Vokzal updateVokzal(Vokzal vokzal);
    List<Vokzal> getAllVokzals();
}
