package com.cognizant.employeemanagementsystem.repository;

import com.cognizant.employeemanagementsystem.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}