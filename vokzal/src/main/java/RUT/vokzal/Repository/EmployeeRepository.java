package RUT.vokzal.Repository;

import RUT.vokzal.Entity.Employee;
import java.util.List;

public interface EmployeeRepository {
    public void create(Employee employee);
    public Employee findById(Integer id);
    public Employee update(Employee employee);
    public List<Employee> findAll();
}