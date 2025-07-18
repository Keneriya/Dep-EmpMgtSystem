package com.example.Dep.EmpMgtSystem.Controller;

import com.example.Dep.EmpMgtSystem.DTO.EmployeeDTO;
import com.example.Dep.EmpMgtSystem.Entity.Employee;
import com.example.Dep.EmpMgtSystem.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/create")
    public Employee createEmployee(@RequestBody EmployeeDTO dto) {
        return employeeService.createEmployee(dto);
    }

    @GetMapping("/all")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    @GetMapping("/search/name")
    public List<Employee> searchByName(@RequestParam String name) {
        return employeeService.searchByName(name);
    }


    @GetMapping("/search/department")
    public List<Employee> searchByDepartment(@RequestParam String department) {
        return employeeService.searchByDepartment(department);
    }

    @GetMapping("/sort/hiredate")
    public List<Employee> sortByHireDate() {
        return employeeService.sortByHireDate();
    }


    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody EmployeeDTO dto) {
        return employeeService.updateEmployee(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }
}
