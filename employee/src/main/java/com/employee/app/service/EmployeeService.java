package com.employee.app.service;

import com.employee.app.dto.APIResponseDTO;
import com.employee.app.dto.EmployeeDTO;

public interface EmployeeService {
    EmployeeDTO saveEmployee(EmployeeDTO employeeDto);
    APIResponseDTO getEmployeeById(long empId);
}
