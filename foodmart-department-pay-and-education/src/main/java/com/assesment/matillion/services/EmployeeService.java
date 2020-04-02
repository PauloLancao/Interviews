package com.assesment.matillion.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assesment.matillion.dto.EmployeeDepartmentPositionDto;
import com.assesment.matillion.dto.EmployeeDto;
import com.assesment.matillion.mapper.EmployeeMapper;
import com.assesment.matillion.repository.EmployeeRepository;

@Service
public class EmployeeService implements IEmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private EmployeeMapper employeeMapper;
	
	@Override
	public List<EmployeeDto> findAll() {
		return employeeRepository.findAll().stream()
		          .map(employeeMapper::convertToDto)
		          .collect(Collectors.toList());
	}

	@Override
	public List<EmployeeDepartmentPositionDto> findAllByEducationLevelPayTypeDepartment(
			String educationLevel, String payType, String department) {
		return employeeRepository.findAllByEducationLevelPayTypeDepartment(educationLevel, payType, department)
				.stream()
				.map(employeeMapper::convertToDto)
		        .collect(Collectors.toList());
	}
}
