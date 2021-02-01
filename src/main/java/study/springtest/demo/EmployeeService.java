package study.springtest.demo;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface EmployeeService {
    public Employee getEmployeeByName(String name);
    Optional<Employee> findById(Long id);
    List<Employee> findAll();
    Employee save(Employee employee);
    void deleteById(Long id);
}
