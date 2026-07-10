package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.Employee;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.cognizant.ormlearn.service.DepartmentService;
import com.cognizant.ormlearn.service.EmployeeService;
import com.cognizant.ormlearn.service.SkillService;
import org.springframework.context.ConfigurableApplicationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class OrmLearnApplication implements CommandLineRunner {

    private static EmployeeService employeeService;
    private static DepartmentService departmentService;
    private static SkillService skillService;

    private static final Logger LOGGER =
            LoggerFactory.getLogger(OrmLearnApplication.class);



    public static void main(String[] args) {

        ConfigurableApplicationContext context =
                SpringApplication.run(OrmLearnApplication.class, args);

        employeeService = context.getBean(EmployeeService.class);
        departmentService = context.getBean(DepartmentService.class);
        skillService = context.getBean(SkillService.class);

        testGetEmployee();
    }

    @Override
    public void run(String... args) {
        // Exercise 2 code commented out
    }

    private static void testGetEmployee() {

        LOGGER.info("Start");

        Employee employee = employeeService.get(1);

        LOGGER.info("Employee: {}", employee);

        LOGGER.info("Department: {}", employee.getDepartment());

        LOGGER.info("End");
    }
}