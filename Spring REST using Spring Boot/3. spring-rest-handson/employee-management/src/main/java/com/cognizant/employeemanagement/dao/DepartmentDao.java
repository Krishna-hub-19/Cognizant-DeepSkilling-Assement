package com.cognizant.employeemanagement.dao;

import com.cognizant.employeemanagement.model.Department;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DepartmentDao {

    private static List<Department> DEPARTMENT_LIST;

    @SuppressWarnings("unchecked")
    public DepartmentDao() {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("employee.xml");

        DEPARTMENT_LIST =
                context.getBean("departmentList", ArrayList.class);
    }

    public List<Department> getAllDepartments() {
        return DEPARTMENT_LIST;
    }
}