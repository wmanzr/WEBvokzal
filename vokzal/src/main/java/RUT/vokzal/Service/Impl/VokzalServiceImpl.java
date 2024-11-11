package RUT.vokzal.Service.Impl;

import RUT.vokzal.DTO.VokzalInDTO;
import RUT.vokzal.DTO.View.VokzalOutDTO;
import RUT.vokzal.Entity.Vokzal;
import RUT.vokzal.Repository.VokzalRepository;
import RUT.vokzal.Service.VokzalService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VokzalServiceImpl implements VokzalService {

    private VokzalRepository vokzalRepository;
    private ModelMapper modelMapper;

    @Autowired
    public void setVokzalRepository(VokzalRepository vokzalRepository) {
        this.vokzalRepository = vokzalRepository;
    }

    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public void createVokzal(VokzalInDTO vokzalInDTO) {
        Vokzal vokzal = modelMapper.map(vokzalInDTO, Vokzal.class);
        vokzalRepository.create(vokzal);
    }

    @Override
    public VokzalOutDTO getVokzalById(Integer id) {
        Vokzal vokzal = vokzalRepository.findById(id);
        return modelMapper.map(vokzal, VokzalOutDTO.class);
    }

    @Override
    public void updateVokzal(int id, VokzalInDTO vokzalInDTO) {
        Vokzal vokzal = modelMapper.map(vokzalInDTO, Vokzal.class);
        vokzal.setId(id);
        vokzalRepository.update(vokzal);
    }

    @Override
    public List<VokzalOutDTO> getAllVokzals() {
        List<Vokzal> vokzals = vokzalRepository.findAll();
        List<VokzalOutDTO> vokzalOutDTOs = new ArrayList<>();
        for (Vokzal vokzal : vokzals) {
            vokzalOutDTOs.add(modelMapper.map(vokzal, VokzalOutDTO.class));
        }
        return vokzalOutDTOs;
    }
}