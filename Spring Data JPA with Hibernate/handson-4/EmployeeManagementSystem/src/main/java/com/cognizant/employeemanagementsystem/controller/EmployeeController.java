package com.cognizant.employeemanagementsystem.controller;

import com.cognizant.employeemanagementsystem.model.Employee;
import com.cognizant.employeemanagementsystem.projection.EmployeeDTO;
import com.cognizant.employeemanagementsystem.projection.EmployeeView;
import com.cognizant.employeemanagementsystem.service.EmployeeService;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable Long id) {
        return employeeService.getEmployee(id);
    }

    @PostMapping
    public Employee saveEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }

    @GetMapping("/page")
    public Page<Employee> getEmployees(Pageable pageable) {
        return employeeService.getEmployees(pageable);
    }

    @GetMapping("/sort")
    public List<Employee> getEmployeesSorted(
            @RequestParam String field) {

        return employeeService.getEmployeesSorted(field);
    }

    @GetMapping("/page-sort")
    public Page<Employee> getEmployeesPageAndSort(
            Pageable pageable,
            @RequestParam String field) {

        return employeeService.getEmployees(pageable, field);
    }

    @GetMapping("/projection")
    public List<EmployeeView> getEmployeeProjection() {
        return employeeService.getEmployeeProjection();
    }

    @GetMapping("/dto")
    public List<EmployeeDTO> getEmployeeDTO() {
        return employeeService.getEmployeeDTO();
    }
}