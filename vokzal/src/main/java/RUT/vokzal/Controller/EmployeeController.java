package RUT.vokzal.Controller;

import RUT.vokzal.DTO.EmployeeInDTO;
import RUT.vokzal.DTO.View.EmployeeOutDTO;
import RUT.vokzal.Service.EmployeeService;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeService getEmployeeService() {
        return this.employeeService;
    }

    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public void createEmployee(@Valid @RequestBody EmployeeInDTO employeeInDTO) {
        employeeService.createEmployee(employeeInDTO);
    }

    @GetMapping("/{id}")
    public EmployeeOutDTO getEmployeeById(@PathVariable Integer id) {
        return employeeService.getEmployeeById(id);
    }

    @PutMapping("/{id}")
    public void updateEmployee(@Valid @PathVariable Integer id, @RequestBody EmployeeInDTO employeeInDTO) {
        employeeService.updateEmployee(id, employeeInDTO);
    }

    @GetMapping
    public List<EmployeeOutDTO> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
}