package com.department.app.service.implementation;

import com.department.app.dto.DepartmentDTO;
import com.department.app.entity.Department;
import com.department.app.repository.DepartmentRepository;
import com.department.app.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@AllArgsConstructor
@Service
public class DepartmentServiceImpl implements DepartmentService {



    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDTO saveDepartment(DepartmentDTO departmentDto) {
        Department department =new
                Department(departmentDto.getId(),
                departmentDto.getDepartmentName(),
                departmentDto.getDepartmentDescription(),
                departmentDto.getDepartmentCode());
        Department dept =departmentRepository.save(department);
        DepartmentDTO savedData = new DepartmentDTO(dept.getId(),dept.getDepartmentName(), dept.getDepartmentDescription(),dept.getDepartmentCode() );
        return savedData;
    }

    @Override
    public DepartmentDTO getDepartmentByCode(String deptCode) {
        Department dept= departmentRepository.findByDepartmentCode(deptCode);
        DepartmentDTO dto = new DepartmentDTO(
                dept.getId(),
                dept.getDepartmentName(),
                dept.getDepartmentDescription(),
                dept.getDepartmentCode());
        return dto;
    }
}
