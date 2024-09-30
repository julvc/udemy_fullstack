package app.rrhh.service;

import java.util.List;

import app.rrhh.models.Employee;

public interface IEmployeeService {

    public List<Employee> listEmployees();
    public Employee searchEmployeeById(Integer id);
    public Employee saveEmployee(Employee employee);
    public void deleteEmployee(Employee employee);
}
