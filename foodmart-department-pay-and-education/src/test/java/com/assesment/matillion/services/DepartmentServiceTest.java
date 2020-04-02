package com.assesment.matillion.services;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.assesment.matillion.dto.DepartmentDto;
import com.assesment.matillion.entity.Department;
import com.assesment.matillion.mapper.DepartmentMapper;
import com.assesment.matillion.repository.DatabaseConfig;
import com.assesment.matillion.repository.DepartmentRepository;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {

	@InjectMocks
	private DepartmentService departmentService;
	
	@Spy
	private DepartmentRepository departmentRepository;
	
	@Spy
	private DepartmentMapper departmentMapper;
	
	@Mock
	private DatabaseConfig databaseConfig;
	
	@Test
	public void findAllTest() {
		// arrange
		DepartmentDto departmentDto = new DepartmentDto();
		departmentDto.setDepartmentDescription("departmentDescription");
		departmentDto.setDepartmentId(2234);
		
		List<Department> mockDepartment = new ArrayList<>();
		Department department = new Department();
		department.setDepartmentDescription("departmentDescription");
		department.setDepartmentId(2234);
		mockDepartment.add(department);
		
		Mockito.doReturn(mockDepartment).when(departmentRepository).findAll();
		Mockito.doReturn(departmentDto).when(departmentMapper).convertToDto(department);
		
		// act
		List<DepartmentDto> listDepartmentDto = departmentService.findAll();
		
		// assert
		assertNotNull(listDepartmentDto);
		assertThat(listDepartmentDto, containsInAnyOrder(departmentDto));
	}
}
