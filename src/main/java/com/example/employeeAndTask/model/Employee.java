package com.example.employeeAndTask.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;


@Data
@NoArgsConstructor
@Entity
@Table(name = "employee2")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Employee {
    @Id
    private UUID employee_id;
    @JsonProperty("full_name")
    private String fullName;
    private String email;
    @JsonProperty("phone_number")
    private String phoneNumber;
    @JsonProperty("date_of_birth")
    private LocalDate dateOfBirth;
    private double salary;
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;


}
