package com.Dotsquares.EMPS.service;

import com.Dotsquares.EMPS.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    public void createOrUpdateEmployee(EmployeeDTO empDTO);

    public List<EmployeeDTO> getAllEmployee();

    public void deleteEmployee(Long id);

    public EmployeeDTO editEmployee(Long id);


}
