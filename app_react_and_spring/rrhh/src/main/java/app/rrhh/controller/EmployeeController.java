package app.rrhh.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.rrhh.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import app.rrhh.exceptions.ResourceNotFound;
import app.rrhh.models.Employee;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
@RequestMapping("rh-app") //http://localhost:8080/rh-app/
@CrossOrigin(value ="http://localhost:3000")
public class EmployeeController {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        var employees = employeeService.listEmployees();
        employees.forEach((employee -> logger.info(employee.toString())));
        return employees;
    }
    
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        logger.info("Empleado para ser agregado: " + employee);
        return employeeService.saveEmployee(employee);
    }
    
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer id){ 
        Employee employee = employeeService.searchEmployeeById(id);
        if (employee  == null)
            throw new ResourceNotFound("No se encontro el empleado con id: " + id);
        return ResponseEntity.ok(employee);            
    }
    
    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Integer id, @RequestBody Employee employeeReceived) {
        Employee employee = employeeService.searchEmployeeById(id);
        if (employee  == null)
            throw new ResourceNotFound("No se encontro el empleado con id: " + id);
        
        employee.setName(employeeReceived.getName());
        employee.setDepartment(employeeReceived.getDepartment());
        employee.setSalary(employeeReceived.getSalary());
        employeeService.saveEmployee(employee);        

        return ResponseEntity.ok(employee); 
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteEmployee(@PathVariable Integer id) {
        Employee employee = employeeService.searchEmployeeById(id);
        if (employee  == null)
            throw new ResourceNotFound("No se encontro el empleado con id: " + id);

        employeeService.deleteEmployee(employee);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Empleado eliminado", Boolean.TRUE);
        return ResponseEntity.ok(response); 
    
    }
}
