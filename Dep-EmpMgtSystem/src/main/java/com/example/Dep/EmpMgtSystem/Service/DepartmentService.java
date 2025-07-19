package com.example.Dep.EmpMgtSystem.Service;

import com.example.Dep.EmpMgtSystem.Entity.Department;
import com.example.Dep.EmpMgtSystem.Repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;


    public Department createDepartment(Department department) {
        Department department1=new Department();

        department1.setName(department.getName());
        department1.setDescription(department.getDescription());

        return departmentRepository.save(department1);
    }

   public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Department updateDepartment(Long id, Department updated) {
        Department department = departmentRepository.findById(id).orElse(null);
        if (department != null) {
            department.setName(updated.getName());
            department.setDescription(updated.getDescription());
            return departmentRepository.save(department);
        }
        return null;
    }

    public void deleteDepartment(Long id) {
        Department department = departmentRepository.findById(id).orElse(null);
//        if (department != null && (department.getEmployees() == null || department.getEmployees().isEmpty())) {
            departmentRepository.delete(department);
        }
    }

