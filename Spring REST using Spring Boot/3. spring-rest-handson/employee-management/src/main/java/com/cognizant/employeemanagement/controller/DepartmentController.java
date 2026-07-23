package com.cognizant.employeemanagement.controller;

import com.cognizant.employeemanagement.model.Department;
import com.cognizant.employeemanagement.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DepartmentController {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/departments")
    public List<Department> getAllDepartments() {

        LOGGER.info("START");

        List<Department> departments =
                departmentService.getAllDepartments();

        LOGGER.debug("Departments : {}", departments);

        LOGGER.info("END");

        return departments;
    }
}