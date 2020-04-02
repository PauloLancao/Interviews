package com.assesment.matillion.services;

import java.util.List;

import com.assesment.matillion.dto.DepartmentDto;

public interface IDepartmentService {
	List<DepartmentDto> findAll();
}
