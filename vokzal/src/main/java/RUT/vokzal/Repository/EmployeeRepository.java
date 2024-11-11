package RUT.vokzal.Repository;

import RUT.vokzal.Entity.Employee;
import java.util.List;

public interface EmployeeRepository {
    void create(Employee employee);
    Employee findById(Integer id);
    Employee update(Employee employee);
    List<Employee> findAll();
}