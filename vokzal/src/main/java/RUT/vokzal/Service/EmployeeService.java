package RUT.vokzal.Service;

import java.util.List;
import RUT.vokzal.Entity.Employee;

public interface EmployeeService {
    void createEmployee(Employee employee);
    Employee getEmployeeById(Integer id);
    Employee updateEmployee(Employee employee);
    List<Employee> getAllEmployees();
}
