package RUT.vokzal.Repository;

import java.time.LocalDate;
import java.util.List;
import RUT.vokzal.Entity.Vokzal;

public interface VokzalRepository {
    public void create(Vokzal vokzal);
    public Vokzal findById(Integer id);
    public Vokzal update(Vokzal vokzal);
    public List<Vokzal> findAll();
    Vokzal findByName(String name);
    List<Vokzal> findTop5VokzalsByDepartures(LocalDate nowDate);
}