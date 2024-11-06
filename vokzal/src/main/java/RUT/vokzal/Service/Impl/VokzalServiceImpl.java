package RUT.vokzal.Service.Impl;

import RUT.vokzal.Entity.Vokzal;
import RUT.vokzal.Repository.VokzalRepository;
import RUT.vokzal.Service.VokzalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VokzalServiceImpl implements VokzalService {

    private VokzalRepository vokzalRepository;

    public VokzalRepository getVokzalRepository() {
        return vokzalRepository;
    }

    @Autowired
    public void setVokzalRepository(VokzalRepository vokzalRepository) {
        this.vokzalRepository = vokzalRepository;
    }

    @Override
    public void createVokzal(Vokzal vokzal) {
        vokzalRepository.create(vokzal);
    }

    @Override
    public Vokzal getVokzalById(Integer id) {
        return vokzalRepository.findById(id);
    }

    @Override
    public Vokzal updateVokzal(Vokzal vokzal) {
        return vokzalRepository.update(vokzal);
    }

    @Override
    public List<Vokzal> getAllVokzals() {
        return vokzalRepository.findAll();
    }
}