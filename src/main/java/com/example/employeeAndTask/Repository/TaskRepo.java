package com.example.employeeAndTask.Repository;
import com.example.employeeAndTask.model.Employee;
import com.example.employeeAndTask.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface TaskRepo extends JpaRepository<Task, UUID> {
    List<Task> findAll();
    Task getById(UUID id);
    Optional<Task> findById(UUID id);

    Task save(Task task);
    void deleteById(UUID id);



}
