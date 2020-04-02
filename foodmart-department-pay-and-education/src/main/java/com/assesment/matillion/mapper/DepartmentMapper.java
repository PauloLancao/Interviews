package com.assesment.matillion.mapper;

import org.springframework.stereotype.Component;

import com.assesment.matillion.dto.DepartmentDto;
import com.assesment.matillion.entity.Department;

@Component
public final class DepartmentMapper extends AbstractMapper {

	public DepartmentDto convertToDto(Department department) {
		return modelMapper.map(department, DepartmentDto.class);
	}
}
