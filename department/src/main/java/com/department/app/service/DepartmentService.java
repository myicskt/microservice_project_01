package com.department.app.service;

import com.department.app.dto.DepartmentDTO;

import java.util.List;

public interface DepartmentService {

    DepartmentDTO saveDepartment(DepartmentDTO departmentDto);
    DepartmentDTO getDepartmentByCode(String deptCode);

}
