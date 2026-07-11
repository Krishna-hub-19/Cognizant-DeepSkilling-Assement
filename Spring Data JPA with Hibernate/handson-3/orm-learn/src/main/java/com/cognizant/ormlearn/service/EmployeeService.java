package com.cognizant.ormlearn.service;

import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(EmployeeService.class);


    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional
    public Employee get(int id) {
        return employeeRepository.findById(id).get();
    }

    @Transactional
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }


    @Transactional
    public List<Employee> getAllPermanentEmployees() {

        LOGGER.info("Start");

        List<Employee> employees = employeeRepository.getAllPermanentEmployees();

        LOGGER.info("End");

        return employees;
    }

    @Transactional
    public double getAverageSalary(int id) {

        LOGGER.info("Start");

        double averageSalary = employeeRepository.getAverageSalary(id);

        LOGGER.info("End");

        return averageSalary;
    }

    @Transactional
    public List<Employee> getAllEmployeesNative() {

        LOGGER.info("Start");

        List<Employee> employees =
                employeeRepository.getAllEmployeesNative();

        LOGGER.info("End");

        return employees;
    }
}