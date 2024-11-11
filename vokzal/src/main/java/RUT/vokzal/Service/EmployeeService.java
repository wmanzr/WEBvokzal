package RUT.vokzal.Service;

import java.util.List;

import RUT.vokzal.DTO.EmployeeInDTO;
import RUT.vokzal.DTO.View.EmployeeOutDTO;

public interface EmployeeService {
    void createEmployee(EmployeeInDTO employeeInDTO);
    EmployeeOutDTO getEmployeeById(Integer id);
    void updateEmployee(int id,EmployeeInDTO employeeInDTO);
    List<EmployeeOutDTO> getAllEmployees();
}