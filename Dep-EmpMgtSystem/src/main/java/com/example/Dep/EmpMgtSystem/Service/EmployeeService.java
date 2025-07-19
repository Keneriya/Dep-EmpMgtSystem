package com.example.Dep.EmpMgtSystem.Service;

import com.example.Dep.EmpMgtSystem.DTO.EmployeeDTO;
import com.example.Dep.EmpMgtSystem.Entity.Department;
import com.example.Dep.EmpMgtSystem.Entity.Employee;
import com.example.Dep.EmpMgtSystem.Repository.DepartmentRepository;
import com.example.Dep.EmpMgtSystem.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    public Employee createEmployee(EmployeeDTO dto){
        Department department = departmentRepository.findById(dto.getDepartmentId()).orElse(null);
        if(department==null) return null;
        Employee employee= new Employee();

        employee.setName(dto.getName());
        employee.setEmail(dto.getEmail());
        employee.setPhone(dto.getPhone());
        employee.setPosition(dto.getPosition());
        // ← set hireDate to “today” on the server’s clock

        //new line for commmit
        employee.setHireDate(LocalDate.now());
        employee.setDepartment(department);

        return employeeRepository.save(employee);

    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }


    public List<Employee> searchByName(String deptName) {
        return employeeRepository.findByDepartment_NameContainingIgnoreCase(deptName);
    }

    public List<Employee> searchByDepartment(String deptName) {
        return employeeRepository.findByDepartment_Name(deptName);
    }

    public List<Employee> sortByHireDate() {
        return employeeRepository.findAllByOrderByHireDateAsc();
    }

    public Employee updateEmployee(Long id, EmployeeDTO dto) {
        Employee employee = employeeRepository.findById(id).orElse(null);
        Department department = departmentRepository.findById(dto.getDepartmentId()).orElse(null);
        if (employee != null && department != null) {
            employee.setName(dto.getName());
            employee.setEmail(dto.getEmail());
            employee.setPhone(dto.getPhone());
            employee.setPosition(dto.getPosition());
            employee.setHireDate(dto.getHireDate());
            employee.setDepartment(department);
            return employeeRepository.save(employee);
        }
        return null;
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
