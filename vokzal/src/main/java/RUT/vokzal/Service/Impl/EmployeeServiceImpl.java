package RUT.vokzal.Service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import RUT.vokzal.DTO.EmployeeInDTO;
import RUT.vokzal.DTO.View.EmployeeOutDTO;
import RUT.vokzal.Entity.Employee;
import RUT.vokzal.Repository.EmployeeRepository;
import RUT.vokzal.Service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeRepository employeeRepository;
    private ModelMapper modelMapper;

    public ModelMapper getModelMapper() {
        return this.modelMapper;
    }

    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public EmployeeRepository getEmployeeRepository() {
        return this.employeeRepository;
    }

    @Autowired
    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void createEmployee(EmployeeInDTO employeeInDTO) {
        employeeRepository.create(modelMapper.map(employeeInDTO, Employee.class));
    }

    @Override
    public EmployeeOutDTO getEmployeeById(Integer id) {
        return modelMapper.map(employeeRepository.findById(id), EmployeeOutDTO.class);
    }

    @Override
    public void updateEmployee(int id, EmployeeInDTO employeeInDTO) {
        Employee employee = modelMapper.map(employeeInDTO, Employee.class);
        employee.setId(id);
        employeeRepository.update(employee);
    }
 
    @Override
    public List<EmployeeOutDTO> getAllEmployees() {
        List<EmployeeOutDTO> result = new ArrayList<>();
        List<Employee> employees = employeeRepository.findAll();
        for (Employee employee : employees) {
            result.add(modelMapper.map(employee, EmployeeOutDTO.class));
        }
        return result;
    }
}