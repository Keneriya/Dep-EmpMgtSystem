package com.example.Dep.EmpMgtSystem.Repository;

import com.example.Dep.EmpMgtSystem.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
