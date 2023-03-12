package com.example.employeeAndTask.Controller;

import com.example.employeeAndTask.Services.EmployeeAndTaskService;
import com.example.employeeAndTask.model.Department;
import com.example.employeeAndTask.model.Employee;
import com.example.employeeAndTask.model.Task;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class EmployeeTaskController {
    private final EmployeeAndTaskService employeeAndTaskService;


    public EmployeeTaskController(EmployeeAndTaskService employeeAndTaskService) {
        this.employeeAndTaskService = employeeAndTaskService;

    }

    @GetMapping("/api/allEmployee")
    public List<Employee> allEmployees(){
        return employeeAndTaskService.findAll();
    }

    @GetMapping("/api/employeeGet/{employee_id}")
    public Employee getOne(@PathVariable("employee_id") UUID id){
        return employeeAndTaskService.getOne(id);
    }
    @GetMapping("/api/employeeFind/{employee_id}")
    public ResponseEntity<Employee> findOne(@PathVariable("employee_id") UUID id) {
        Optional<Employee> optionalEmployee = employeeAndTaskService.findById(id);
        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            return ResponseEntity.ok(employee);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping("/api/employee/newOrUpadate")
    public Employee save(@RequestBody Employee employee){
        return employeeAndTaskService.save(employee);
    }

    @DeleteMapping("/api/employee/deleteById/{employee_id}")
    public void deleteById(@PathVariable("employee_id")UUID id){
        employeeAndTaskService.deleteById(id);
    }

    @GetMapping("/api/allTask")
    public List<Task> allTasks(){
        return employeeAndTaskService.findAllTask();
    }

    @GetMapping("/api/taskGet/{task_id}")
    public Task getOneTask(@PathVariable("task_id") UUID id){
        return employeeAndTaskService.getOneTask(id);
    }

    @GetMapping("/api/taskFind/{task_id}")
    public ResponseEntity<Task> findOneTask(@PathVariable("task_id") UUID id) {
        Optional<Task> optionalTask = employeeAndTaskService.findByIdTask(id);
        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
            return ResponseEntity.ok(task);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/api/task/newOrUpadate")
    public Task saveTask(@RequestBody Task task){
        return employeeAndTaskService.saveTask(task);
    }

    @DeleteMapping("/api/task/deleteById/{task_id}")
    public void deleteByIdTask(@PathVariable("task_id")UUID id){
        employeeAndTaskService.deleteByIdTask(id);
    }

    @GetMapping("/api/task/topFive")
    public List<Employee> getTopFiveEmployees() {
        List<Employee> topFive = new ArrayList<>();
        for(var ime : employeeAndTaskService.findTopFive()){
            for(var employee: employeeAndTaskService.findAll()){
                if(ime.equalsIgnoreCase(employee.getFullName())){
                    topFive.add(employee);
                }
            }
        }
        return topFive;

    }

    @GetMapping("/api/allDeps")
    public String allDep(){
        int count = 0;
        for(var dep:employeeAndTaskService.findAllD()){
            count++;
        }
        if (count>0){
            return "There are " + count + " departments";
        } else return "There isn't any department";
    }

    @GetMapping("/api/avgByDep")
    public List<?> avgByDep(){
        return employeeAndTaskService.avgByDep();
    }
}
