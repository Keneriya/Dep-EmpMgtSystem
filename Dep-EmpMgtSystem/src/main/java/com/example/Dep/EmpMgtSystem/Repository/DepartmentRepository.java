package com.example.Dep.EmpMgtSystem.Repository;

import com.example.Dep.EmpMgtSystem.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
