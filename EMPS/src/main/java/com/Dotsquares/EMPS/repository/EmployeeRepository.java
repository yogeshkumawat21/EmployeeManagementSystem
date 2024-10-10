package com.Dotsquares.EMPS.repository;

import com.Dotsquares.EMPS.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
