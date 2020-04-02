package com.assesment.matillion.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assesment.matillion.dto.DepartmentDto;
import com.assesment.matillion.mapper.DepartmentMapper;
import com.assesment.matillion.repository.DepartmentTemplateRepository;

@Service
public class DepartmentTemplateService implements IDepartmentService {

	@Autowired
	private DepartmentTemplateRepository departmentTemplateRepository;
	
	@Autowired
	private DepartmentMapper departmentMapper;
	
	@Override
	public List<DepartmentDto> findAll() {
		return departmentTemplateRepository.findAll().stream()
		          .map(departmentMapper::convertToDto)
		          .collect(Collectors.toList());
	}
}
