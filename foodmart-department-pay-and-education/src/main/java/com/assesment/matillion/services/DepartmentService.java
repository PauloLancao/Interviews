package com.assesment.matillion.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assesment.matillion.dto.DepartmentDto;
import com.assesment.matillion.mapper.DepartmentMapper;
import com.assesment.matillion.repository.DepartmentRepository;

@Service
public class DepartmentService implements IDepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private DepartmentMapper departmentMapper;
	
	@Override
	public List<DepartmentDto> findAll() {
		return departmentRepository.findAll().stream()
		          .map(departmentMapper::convertToDto)
		          .collect(Collectors.toList());
	}
}
