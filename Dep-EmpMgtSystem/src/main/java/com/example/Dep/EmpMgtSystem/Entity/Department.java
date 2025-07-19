package com.example.Dep.EmpMgtSystem.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity

@NoArgsConstructor
@AllArgsConstructor
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    private String name;

    private String description;

////    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
//    @JsonIgnoreProperties("department")
//    private List<Employee> employees;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

//    public List<Employee> getEmployees() {
//        return employees;
//    }
//    public void setEmployees(List<Employee> employees) {
//        this.employees = employees; }

}
