package com.cognizant.employeemanagementsystem.service;

import com.cognizant.employeemanagementsystem.model.Employee;
import com.cognizant.employeemanagementsystem.projection.EmployeeDTO;
import com.cognizant.employeemanagementsystem.projection.EmployeeView;
import com.cognizant.employeemanagementsystem.repository.EmployeeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployee(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    public Employee getEmployeeByEmail(String email) {
        return employeeRepository.getEmployeeByEmail(email);
    }

    public Employee getEmployeeByName(String name) {
        return employeeRepository.findByEmployeeName(name);
    }

    public Page<Employee> getEmployees(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    public List<Employee> getEmployeesSorted(String field) {
        return employeeRepository.findAll(Sort.by(field));
    }

    public Page<Employee> getEmployees(Pageable pageable, String field) {
        Pageable sortedPage =
                PageRequest.of(
                        pageable.getPageNumber(),
                        pageable.getPageSize(),
                        Sort.by(field));

        return employeeRepository.findAll(sortedPage);
    }

    public List<EmployeeView> getEmployeeProjection() {
        return employeeRepository.findAllProjectedBy();
    }

    public List<EmployeeDTO> getEmployeeDTO() {
        return employeeRepository.getEmployeeDTO();
    }
}