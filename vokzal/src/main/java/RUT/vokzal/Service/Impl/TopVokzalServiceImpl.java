package RUT.vokzal.Service.Impl;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import RUT.vokzal.Entity.Vokzal;
import RUT.vokzal.DTO.VokzalDTO;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import RUT.vokzal.Repository.VokzalRepository;
import RUT.vokzal.Service.TopVokzalService;

@Service
public class TopVokzalServiceImpl implements TopVokzalService{
    
    private ModelMapper modelMapper;
    private VokzalRepository vokzalRepository;

    public VokzalRepository getVokzalRepository() {
        return this.vokzalRepository;
    }

    @Autowired
    public void setVokzalRepository(VokzalRepository vokzalRepository) {
        this.vokzalRepository = vokzalRepository;
    }

    public ModelMapper getModelMapper() {
        return this.modelMapper;
    }

    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public List<VokzalDTO> getTop5VokzalsByDepartures() {
    LocalDate nowDate = LocalDate.now();
    List<Vokzal> topVokzals = vokzalRepository.findTop5VokzalsByDepartures(nowDate);
    return topVokzals.stream()
            .map(vokzal -> modelMapper.map(vokzal, VokzalDTO.class))
            .collect(Collectors.toList());
    }
}