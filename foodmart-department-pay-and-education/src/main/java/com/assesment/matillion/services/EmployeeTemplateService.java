package com.assesment.matillion.services;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.NotImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assesment.matillion.dto.EmployeeDepartmentPositionDto;
import com.assesment.matillion.dto.EmployeeDto;
import com.assesment.matillion.mapper.EmployeeMapper;
import com.assesment.matillion.repository.EmployeeTemplateRepository;

@Service
public class EmployeeTemplateService implements IEmployeeService {

	@Autowired
	private EmployeeTemplateRepository employeeTemplateRepository;
	
	@Autowired
	private EmployeeMapper employeeMapper;
	
	@Override
	public List<EmployeeDto> findAll() {
		return employeeTemplateRepository.findAll().stream()
		          .map(employeeMapper::convertToDto)
		          .collect(Collectors.toList());
	}

	@Override
	public List<EmployeeDepartmentPositionDto> findAllByEducationLevelPayTypeDepartment(String educationLevel, String payType,
			String department) {
		throw new NotImplementedException("Not implemented exception");
	}
}
