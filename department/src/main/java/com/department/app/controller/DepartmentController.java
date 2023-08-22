package com.department.app.controller;


import com.department.app.dto.DepartmentDTO;
import com.department.app.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/department")
@AllArgsConstructor
public class DepartmentController {
    DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<DepartmentDTO> saveDepartment(@RequestBody DepartmentDTO departmentDTO){
        DepartmentDTO dto =  departmentService.saveDepartment(departmentDTO);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    /*@GetMapping("/list")
    public ResponseEntity<DepartmentDTO> getAllDepartment(){
        List<DepartmentDTO> dto = departmentService.getAllDepartment();
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }*/
    @GetMapping("{department-code}")
    public ResponseEntity<DepartmentDTO> getDepartment(@PathVariable("department-code") String deptCode){
        DepartmentDTO dto = departmentService.getDepartmentByCode(deptCode);
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }
}
