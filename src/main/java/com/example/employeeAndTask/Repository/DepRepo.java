package com.example.employeeAndTask.Repository;

import com.example.employeeAndTask.model.Department;
import com.example.employeeAndTask.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DepRepo extends JpaRepository<Department, UUID> {

    List<Department> findAll();

}
