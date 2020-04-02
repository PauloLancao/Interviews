package com.assesment.matillion.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.util.Assert;

import com.assesment.matillion.dto.DepartmentDto;
import com.assesment.matillion.entity.Department;

@ExtendWith(MockitoExtension.class)
public class DepartmentMapperTest {

	@InjectMocks
    private DepartmentMapper departmentMapper = new DepartmentMapper();
	
	@Spy
	private ModelMapper modelMapper;
	
	@BeforeEach
	public void setup() {
        MockitoAnnotations.initMocks(this);
        modelMapper = new ModelMapper();
	}
	
	@Test
	public void convertToDtoTest() {
		// arrange
		Department department = new Department();
		department.setDepartmentDescription("departmentDescription");
		department.setDepartmentId(999);
						
		// act
		DepartmentDto departmentDto = modelMapper.map(department, DepartmentDto.class);
				
		// assert
		Assert.isInstanceOf(DepartmentDto.class, departmentDto);
		assertEquals("departmentDescription", departmentDto.getDepartmentDescription());
		assertEquals(999, departmentDto.getDepartmentId());
	}
	
	@Test
	public void convertToDtoCallTest() {
		// arrange
		Department department = new Department();
		department.setDepartmentDescription("departmentDescription");
		department.setDepartmentId(999);
		
		// act
		DepartmentDto departmentDto = departmentMapper.convertToDto(department);
		
		// assert
		Assert.isInstanceOf(DepartmentDto.class, departmentDto);
		assertEquals("departmentDescription", departmentDto.getDepartmentDescription());
		assertEquals(999, departmentDto.getDepartmentId());
	}
}
