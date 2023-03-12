package com.example.employeeAndTask.model;

import com.example.employeeAndTask.model.Employee;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
@Table(name = "task2")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Task {
    @Id
    private UUID task_id;
    private String title;
    private String description;

    @ManyToOne
    @JoinColumn(name = "assignee_employee_id")
    private Employee assignee;
    private LocalDate deadline;
//    @ManyToOne
//    @JoinColumn(name = "department_id")
//    private Department department;

}
