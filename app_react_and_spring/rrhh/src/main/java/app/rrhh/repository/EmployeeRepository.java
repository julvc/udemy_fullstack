package app.rrhh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import app.rrhh.models.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
