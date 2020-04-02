package com.assesment.matillion.repository;

import java.util.List;

import com.assesment.matillion.entity.Employee;
import com.assesment.matillion.entity.EmployeeDepartmentPosition;

public interface IEmployeeRepository {
	List<Employee> findAll();
	List<EmployeeDepartmentPosition> findAllByEducationLevelPayTypeDepartment(
			String educationLevel, String payType, String department);
}
