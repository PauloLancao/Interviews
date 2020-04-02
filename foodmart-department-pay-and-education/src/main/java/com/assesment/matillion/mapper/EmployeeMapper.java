package com.assesment.matillion.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.assesment.matillion.dto.DepartmentDto;
import com.assesment.matillion.dto.EmployeeDepartmentPositionDto;
import com.assesment.matillion.dto.EmployeeDto;
import com.assesment.matillion.dto.PositionDto;
import com.assesment.matillion.entity.Employee;
import com.assesment.matillion.entity.EmployeeDepartmentPosition;

@Component
public final class EmployeeMapper {

	@Bean
	public ModelMapper employeeModelMapper() {
		return new ModelMapper();
	}

	@Autowired
	private ModelMapper modelMapper;
	
	public EmployeeDto convertToDto(Employee employee) {
		return modelMapper.map(employee, EmployeeDto.class);
	}
	
	public EmployeeDepartmentPositionDto convertToDto(EmployeeDepartmentPosition employeeDepartmentPosition) {
		EmployeeDepartmentPositionDto employeeDepartmentPositionDto = new EmployeeDepartmentPositionDto();
		
		employeeDepartmentPositionDto.setDepartmentDto(modelMapper.map(employeeDepartmentPosition.getDepartment(), DepartmentDto.class));
		employeeDepartmentPositionDto.setEmployeeDto(modelMapper.map(employeeDepartmentPosition.getEmployee(), EmployeeDto.class));
		employeeDepartmentPositionDto.setPositonDto(modelMapper.map(employeeDepartmentPosition.getPosition(), PositionDto.class));
		
		return employeeDepartmentPositionDto;
	}
}
