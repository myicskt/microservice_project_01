package com.employee.app.service.imp;

import com.employee.app.dto.DepartmentDTO;
import com.employee.app.repository.EmployeeRepository;
import com.employee.app.service.EmployeeService;
import com.employee.app.dto.APIResponseDTO;
import com.employee.app.dto.EmployeeDTO;
import com.employee.app.entity.Employee;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;
    private RestTemplate restTemplate;
    //private WebClient webClient;
    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDto) {
        Employee employee =  new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail(),
                employeeDto.getDepartmentCode());
        Employee emp = employeeRepository.save(employee);
        EmployeeDTO dto = new EmployeeDTO(
                emp.getId(),
                emp.getFirstName(),
                emp.getLastName(),
                emp.getEmail(),
                emp.getDepartmentCode());
        return dto;
    }


    @Override
    public APIResponseDTO getEmployeeById(long empId) {
        Optional<Employee> employeeOptional = employeeRepository.findById(empId);
        Employee employee = employeeOptional.get();

        ResponseEntity<DepartmentDTO> forEntity = restTemplate.getForEntity("http://localhost:8085/api/department//" + employee.getDepartmentCode(), DepartmentDTO.class);
        DepartmentDTO departmentDto = forEntity.getBody();

        EmployeeDTO employeeDto =  new EmployeeDTO(employee.getId(),employee.getFirstName(),employee.getLastName(),employee.getEmail(),employee.getDepartmentCode());

        APIResponseDTO apiResponseDTO = new APIResponseDTO(employeeDto,departmentDto);

        return apiResponseDTO;
}
}
