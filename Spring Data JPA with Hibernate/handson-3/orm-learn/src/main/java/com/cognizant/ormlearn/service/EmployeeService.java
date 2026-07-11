package com.cognizant.ormlearn.service;

import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(EmployeeService.class);


    @Autowired
    private EmployeeRepository employeeRepository;

    @PersistenceContext
    private EntityManager entityManager;

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

    @Transactional
    public List<Employee> getPermanentEmployeesCriteria() {

        LOGGER.info("Start");

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Employee> query =
                builder.createQuery(Employee.class);

        Root<Employee> root = query.from(Employee.class);

        query.select(root)
                .where(builder.equal(root.get("permanent"), true));

        List<Employee> employees =
                entityManager.createQuery(query).getResultList();

        LOGGER.info("End");

        return employees;
    }
}