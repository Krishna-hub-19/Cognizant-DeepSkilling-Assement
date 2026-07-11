package com.cognizant.employeemanagementsystem.repository;

import com.cognizant.employeemanagementsystem.model.Employee;
import com.cognizant.employeemanagementsystem.projection.EmployeeDTO;
import com.cognizant.employeemanagementsystem.projection.EmployeeView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByNameContainingIgnoreCase(String name);

    Employee findByEmail(String email);

    List<Employee> findByDepartmentId(Long departmentId);

    @Query("SELECT e FROM Employee e WHERE e.email = :email")
    Employee getEmployeeByEmail(@Param("email") String email);

    Employee findByEmployeeName(@Param("name") String name);

    List<EmployeeView> findAllProjectedBy();

    @Query("""
       SELECT new com.cognizant.employeemanagementsystem.projection.EmployeeDTO(
           e.name,
           e.email
       )
       FROM Employee e
       """)
    List<EmployeeDTO> getEmployeeDTO();

}