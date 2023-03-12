package com.example.employeeAndTask.Repository;

import com.example.employeeAndTask.model.Employee;
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
public interface EmployeeRepo extends JpaRepository<Employee, UUID> {
    List<Employee> findAll();
    Employee getById(UUID id);

    Employee save(Employee employee);
    Optional<Employee> findById(UUID id);

    void deleteById(UUID id);

    @Query(value = "SELECT e.full_name\n" +
            "FROM employee2 e\n" +
            "LEFT JOIN task2 t ON e.employee_id = t.assignee_employee_id\n" +
            "WHERE t.deadline BETWEEN DATEADD('DAY', -30, NOW()) AND NOW()\n" +
            "GROUP BY e.full_name\n" +
            "ORDER BY COUNT(t.assignee_employee_id) DESC\n" +
            "LIMIT 5", nativeQuery = true)
    List<String> findTopFive();

    @Query(value = "SELECT d.name, ROUND(AVG(e.salary), 2) as avg_salary\n" +
            "FROM employee2 e\n" +
            "JOIN department d ON e.department_id = d.department_id\n" +
            "GROUP BY d.name", nativeQuery = true)
    
    List<?> averageByDep();

}
