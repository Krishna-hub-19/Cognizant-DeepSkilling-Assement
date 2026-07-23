package com.cognizant.employeemanagement;

import com.cognizant.employeemanagement.dao.EmployeeDao;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeeManagementApplication {

	public static void main(String[] args) {

        // temporary code to varify- EmployeeDao
//        EmployeeDao dao = new EmployeeDao();
//        System.out.println(dao.getAllEmployees());

		SpringApplication.run(EmployeeManagementApplication.class, args);
	}

}
