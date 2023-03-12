package com.example.employeeAndTask.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@NoArgsConstructor
@Entity
@Table(name = "department")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Department {
    @Id
    private UUID department_id;
    private String name;
    private String location;

    @ManyToOne
    @JoinColumn(name = "manager_employee_id")
    private Employee manager;

    @OneToMany(mappedBy = "department")
    private List<Employee> employees;







// constructors, getters, setters, etc.
}

