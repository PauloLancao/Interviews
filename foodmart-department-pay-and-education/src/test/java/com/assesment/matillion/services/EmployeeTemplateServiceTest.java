package com.assesment.matillion.services;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.NotImplementedException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import com.assesment.matillion.dto.EmployeeDto;
import com.assesment.matillion.entity.Employee;
import com.assesment.matillion.mapper.EmployeeMapper;
import com.assesment.matillion.repository.DatabaseConfig;
import com.assesment.matillion.repository.EmployeeTemplateRepository;

@ExtendWith(MockitoExtension.class)
public class EmployeeTemplateServiceTest {

	@InjectMocks
	private EmployeeTemplateService employeeTemplateService;
	
	@Spy
	private EmployeeTemplateRepository employeeTemplateRepository;
	
	@Spy
	private EmployeeMapper employeeMapper;
	
	@Mock
	private DatabaseConfig databaseConfig;
	
	@Test
	public void findAllTest() {
		// arrange
		EmployeeDto employeeDto = new EmployeeDto();
		employeeDto.setDepartmentId(888);
		employeeDto.setFirstName("firstName");
		
		List<Employee> mockEmployee = new ArrayList<>();
		Employee employee = new Employee();
		employee.setDepartmentId(888);
		employee.setFirstName("firstName");
		mockEmployee.add(employee);
		
		Mockito.doReturn(mockEmployee).when(employeeTemplateRepository).findAll();
		Mockito.doReturn(employeeDto).when(employeeMapper).convertToDto(employee);
		
		// act
		List<EmployeeDto> listEmployeeDto = employeeTemplateService.findAll();
		
		// assert
		assertNotNull(listEmployeeDto);
		assertThat(listEmployeeDto, containsInAnyOrder(employeeDto));
	}
	
	@Test
	public void findAllByEducationLevelPayTypeDepartmentTest() {
		String educationLevel = "Graduate Degree";
		String payType = "Monthly";
		String department = "Store Information Systems";
		
		// act
		Assertions.assertThrows(NotImplementedException.class, () -> {
			employeeTemplateService.findAllByEducationLevelPayTypeDepartment(educationLevel, payType, department);
		});
	}
}
