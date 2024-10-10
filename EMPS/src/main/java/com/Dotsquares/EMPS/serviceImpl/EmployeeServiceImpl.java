package com.Dotsquares.EMPS.serviceImpl;

import com.Dotsquares.EMPS.dto.EmployeeDTO;
import com.Dotsquares.EMPS.model.Employee;
import com.Dotsquares.EMPS.repository.EmployeeRepository;
import com.Dotsquares.EMPS.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
   @Autowired
   private EmployeeRepository employeeRepository;

    @Override
    public void createOrUpdateEmployee(EmployeeDTO empDTO) {
            Employee emp = convertDtoModel(empDTO);
            employeeRepository.save(emp);

    }

    @Override
    public List<EmployeeDTO> getAllEmployee() {
        List<Employee> list = employeeRepository.findAll();
        List<EmployeeDTO> employeeList = list.stream()
                .map(EmployeeDTO::new)
                .collect(Collectors.toCollection(ArrayList::new));
        return employeeList;
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }


    @Override
    public EmployeeDTO editEmployee(Long id) {
        Employee emp = employeeRepository.getOne(id);
        return convertModelToDTO(emp);
    }
    
    
    private Employee convertDtoModel(EmployeeDTO empDto)
    {
        Employee emp = new Employee();
        if (empDto.getId() != null) {
            emp.setId(empDto.getId());
        }
        emp.setAge(empDto.getAge());
        emp.setBloodGp(empDto.getBloodGp());
        emp.setEmailId(empDto.getEmailId());
        emp.setEmpId(empDto.getEmpId());
        emp.setFirstName(empDto.getFirstName());
        emp.setLastName(empDto.getLastName());
        emp.setMobileNo(empDto.getMobileNo());
        emp.setPersonalEmail(empDto.getPersonalEmail());
        emp.setUserName(empDto.getUserName());
        return emp;
    }
    private EmployeeDTO convertModelToDTO(Employee emp) {
        {
            EmployeeDTO empDTO = new EmployeeDTO();
            empDTO.setId(emp.getId());
            empDTO.setAge(emp.getAge());
            empDTO.setBloodGp(emp.getBloodGp());
            empDTO.setEmailId(emp.getEmailId());
            empDTO.setEmpId(emp.getEmpId());
            empDTO.setFirstName(emp.getFirstName());
            empDTO.setLastName(emp.getLastName());
            empDTO.setMobileNo(emp.getMobileNo());
            empDTO.setPersonalEmail(emp.getPersonalEmail());
            empDTO.setUserName(emp.getUserName());
            return empDTO;
        }
    }
}
