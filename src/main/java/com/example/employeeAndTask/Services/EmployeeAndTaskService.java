package com.example.employeeAndTask.Services;

import com.example.employeeAndTask.Repository.DepRepo;
import com.example.employeeAndTask.Repository.EmployeeRepo;
import com.example.employeeAndTask.Repository.TaskRepo;
import com.example.employeeAndTask.model.Department;
import com.example.employeeAndTask.model.Employee;
import com.example.employeeAndTask.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeAndTaskService {
    private final EmployeeRepo employeeRepo;
    private final TaskRepo taskRepo;
    private final DepRepo depRepo;

    @Autowired
    public EmployeeAndTaskService(EmployeeRepo employeeRepo, TaskRepo taskRepo, DepRepo depRepo) {
        this.employeeRepo = employeeRepo;
        this.taskRepo = taskRepo;
        this.depRepo = depRepo;
    }

    public List<Employee> findAll(){
        return employeeRepo.findAll();
    }
    public Employee getOne(UUID id){
        return employeeRepo.getById(id);
    }

    public Employee save(Employee employee){
        return employeeRepo.save(employee);
    }

    public void deleteById(UUID id){
        employeeRepo.deleteById(id);
    }

    public List<Task> findAllTask(){
        return taskRepo.findAll();
    }
    public Optional<Employee> findById(UUID id){
        return employeeRepo.findById(id);
    }
    public Optional<Task> findByIdTask(UUID id){
        return taskRepo.findById(id);
    }
    public Task getOneTask(UUID id){
        return taskRepo.getById(id);
    }

    public Task saveTask(Task task){
        return taskRepo.save(task);
    }

    public void deleteByIdTask(UUID id){
        taskRepo.deleteById(id);
    }

    public List<String> findTopFive() {
        return  employeeRepo.findTopFive();
    }


    public List<Department> findAllD(){
        return depRepo.findAll();
    }

    public List<?> avgByDep(){
        return employeeRepo.averageByDep();
    }

}
