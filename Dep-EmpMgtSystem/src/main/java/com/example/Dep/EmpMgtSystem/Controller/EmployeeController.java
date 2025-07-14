package com.example.Dep.EmpMgtSystem.Controller;

import com.example.Dep.EmpMgtSystem.DTO.EmployeeDTO;
import com.example.Dep.EmpMgtSystem.Entity.Employee;
import com.example.Dep.EmpMgtSystem.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/create")
    public Employee createEmployee(@RequestBody EmployeeDTO dto){
        return employeeService.createEmployee(dto);
    }
}
