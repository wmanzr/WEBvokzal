package RUT.vokzal.Repository.Impl;

import java.util.List;
import org.springframework.stereotype.Repository;
import RUT.vokzal.Entity.Vokzal;
import RUT.vokzal.Repository.BaseRepository;
import RUT.vokzal.Repository.VokzalRepository;
import jakarta.transaction.Transactional;

@Repository
public class VokzalRepositoryImpl extends BaseRepository<Vokzal, Integer> implements VokzalRepository {

    public VokzalRepositoryImpl() {
        super(Vokzal.class);
    }

    @Override
    @Transactional
    public void create(Vokzal vokzal) {
        super.create(vokzal);
    }

    @Override
    public Vokzal findById(Integer id) {
        return super.findById(id);
    }

    @Override
    public Vokzal update(Vokzal vokzal) {
        return super.update(vokzal);
    }

    @Override
    public List<Vokzal> findAll() {
        return super.findAll();
    }

    @Override
    public Vokzal findByName(String name) {
        return entityManager.createQuery(
                "SELECT v FROM Vokzal v WHERE v.name = :name", Vokzal.class)
                .setParameter("name", name)
                .getSingleResult();
    }
}