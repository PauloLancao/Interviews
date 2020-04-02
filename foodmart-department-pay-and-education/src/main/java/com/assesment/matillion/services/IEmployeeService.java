package com.assesment.matillion.services;

import java.util.List;

import com.assesment.matillion.dto.EmployeeDepartmentPositionDto;
import com.assesment.matillion.dto.EmployeeDto;

public interface IEmployeeService {
	List<EmployeeDto> findAll();
	List<EmployeeDepartmentPositionDto> findAllByEducationLevelPayTypeDepartment(
			String educationLevel, String payType, String department);
}
