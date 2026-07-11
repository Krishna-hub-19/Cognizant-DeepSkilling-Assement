package com.cognizant.ormlearn;

import com.cognizant.ormlearn.model.*;
import com.cognizant.ormlearn.service.AttemptService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.cognizant.ormlearn.service.DepartmentService;
import com.cognizant.ormlearn.service.EmployeeService;
import com.cognizant.ormlearn.service.SkillService;
import org.springframework.context.ConfigurableApplicationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@SpringBootApplication
public class OrmLearnApplication implements CommandLineRunner {

    private static EmployeeService employeeService;
    private static DepartmentService departmentService;
    private static SkillService skillService;

    private static AttemptService attemptService;

    private static final Logger LOGGER =
            LoggerFactory.getLogger(OrmLearnApplication.class);



    public static void main(String[] args) {

        ConfigurableApplicationContext context =
                SpringApplication.run(OrmLearnApplication.class, args);

        employeeService = context.getBean(EmployeeService.class);
        departmentService = context.getBean(DepartmentService.class);
        skillService = context.getBean(SkillService.class);

        attemptService = context.getBean(AttemptService.class);

//      testGetEmployee();
//      testAddEmployee();
//      testUpdateEmployee();
//      testGetDepartment();
//      testAddSkillToEmployee();
//      testGetAllPermanentEmployees();
//      testGetQuizAttempt();

        testGetAverageSalary();



    }

    @Override
    public void run(String... args) {
        // Exercise 2 code commented out
    }

    private static void testGetAverageSalary() {

        LOGGER.info("Start");

        double averageSalary = employeeService.getAverageSalary(1);

        LOGGER.info("Average Salary: {}", averageSalary);

        LOGGER.info("End");
    }

    /*
    private static void testGetQuizAttempt() {

        LOGGER.info("Start");

        Attempt attempt = attemptService.getAttemptDetail(1);

        LOGGER.info("Attempt: {}", attempt);

        LOGGER.info("User: {}", attempt.getUser());

        for (AttemptQuestion aq : attempt.getAttemptQuestionList()) {

            LOGGER.info("Question : {}", aq.getQuestion());

            LOGGER.info("Selected Options : {}", aq.getAttemptOptionList());

        }

        LOGGER.info("End");
    }
     */


    /*
    private static void testGetAllPermanentEmployees() {

        LOGGER.info("Start");

        List<Employee> employees =
                employeeService.getAllPermanentEmployees();

        LOGGER.info("Permanent Employees: {}", employees);

        employees.forEach(employee ->
                LOGGER.info("Skills: {}", employee.getSkillList()));

        LOGGER.info("End");
    }
     */


    /*
    private static void testAddSkillToEmployee() {

        LOGGER.info("Start");

        Employee employee = employeeService.get(1);

        Skill skill = skillService.get(5);

        employee.getSkillList().add(skill);

        employeeService.save(employee);

        LOGGER.info("Employee: {}", employee);

        LOGGER.info("Skills: {}", employee.getSkillList());

        LOGGER.info("End");
    }
     */

    /*
    private static void testGetEmployee() {

        LOGGER.info("Start");

        Employee employee = employeeService.get(1);

        LOGGER.info("Employee: {}", employee);

        LOGGER.info("Department: {}", employee.getDepartment());

        LOGGER.info("Skills: {}", employee.getSkillList());

        LOGGER.info("End");
    }

     */


    /*
    private static void testGetDepartment() {

        LOGGER.info("Start");

        Department department = departmentService.get(1);

        LOGGER.info("Department: {}", department);

        LOGGER.info("Employees: {}", department.getEmployeeList());

        LOGGER.info("End");
    }
     */

    /*
    private static void testUpdateEmployee() {

        LOGGER.info("Start");

        Employee employee = employeeService.get(1);

        Department department = departmentService.get(2);

        employee.setDepartment(department);

        employeeService.save(employee);

        LOGGER.info("Employee: {}", employee);

        LOGGER.info("End");
    }
     */

    /*
    private static void testAddEmployee() {

        LOGGER.info("Start");

        Employee employee = new Employee();

        employee.setName("Krishna Garg");
        employee.setSalary(75000);
        employee.setPermanent(true);

        employee.setDateOfBirth(
                java.sql.Date.valueOf("2003-01-18"));

        Department department = departmentService.get(1);

        employee.setDepartment(department);

        employeeService.save(employee);

        LOGGER.info("Employee: {}", employee);

        LOGGER.info("End");
    }
     */
}