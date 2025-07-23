package com.example.Dep.EmpMgtSystem.Repository;

import com.example.Dep.EmpMgtSystem.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByNameContainingIgnoreCase(String name);
    List<Employee> findByDepartment_Name(String departmentName);
    List<Employee> findByDepartment_NameContainingIgnoreCase(String departmentName);
    List<Employee> findAllByOrderByHireDateAsc();
}
