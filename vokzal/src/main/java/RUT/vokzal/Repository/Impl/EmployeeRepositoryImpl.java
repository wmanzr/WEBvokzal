package RUT.vokzal.Repository.Impl;

import RUT.vokzal.Entity.Employee;
import RUT.vokzal.Repository.BaseRepository;
import RUT.vokzal.Repository.EmployeeRepository;
import jakarta.transaction.Transactional;

import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeRepositoryImpl extends BaseRepository<Employee, Integer> implements EmployeeRepository {

    public EmployeeRepositoryImpl() {
        super(Employee.class);
    }

    @Override
    @Transactional
    public void create(Employee employee) {
        super.create(employee);
    }

    @Override
    public Employee findById(Integer id) {
        return super.findById(id);
    }

    @Override
    public Employee update(Employee employee) {
        return super.update(employee);
    }

    @Override
    public List<Employee> findAll() {
        return super.findAll();
    }
}