package RUT.vokzal.Service;

import RUT.vokzal.DTO.VokzalInDTO;
import RUT.vokzal.DTO.View.VokzalOutDTO;
import java.util.List;

public interface VokzalService {
    void createVokzal(VokzalInDTO vokzalInDTO);
    VokzalOutDTO getVokzalById(Integer id);
    void updateVokzal(int id, VokzalInDTO vokzalInDTO);
    List<VokzalOutDTO> getAllVokzals();
}