package com.employee.app.controller;


import com.employee.app.dto.APIResponseDTO;
import com.employee.app.dto.EmployeeDTO;
import com.employee.app.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/employees")
@AllArgsConstructor

public class EmployeeController {

    private EmployeeService employeeService;

    @PostMapping()
    public ResponseEntity<EmployeeDTO> saveEmployee(@RequestBody EmployeeDTO employeeDTO){
        EmployeeDTO emp = employeeService.saveEmployee(employeeDTO);
        return new ResponseEntity<>(emp, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<APIResponseDTO> getEmployee(@PathVariable("id") long empDTO){
        APIResponseDTO apiResponseDTO = employeeService.getEmployeeById(empDTO);
        return new ResponseEntity<>(apiResponseDTO, HttpStatus.OK);
    }



}
