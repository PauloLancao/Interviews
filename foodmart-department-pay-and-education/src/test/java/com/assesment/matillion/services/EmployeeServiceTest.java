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

import com.assesment.matillion.dto.EmployeeDepartmentPositionDto;
import com.assesment.matillion.dto.EmployeeDto;
import com.assesment.matillion.entity.Employee;
import com.assesment.matillion.entity.EmployeeDepartmentPosition;
import com.assesment.matillion.mapper.EmployeeMapper;
import com.assesment.matillion.repository.DatabaseConfig;
import com.assesment.matillion.repository.EmployeeRepository;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

	@InjectMocks
	private EmployeeService employeeService;
	
	@Spy
	private EmployeeRepository employeeRepository;
	
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
		
		Mockito.doReturn(mockEmployee).when(employeeRepository).findAll();
		Mockito.doReturn(employeeDto).when(employeeMapper).convertToDto(employee);
		
		// act
		List<EmployeeDto> listEmployeeDto = employeeService.findAll();
		
		// assert
		assertNotNull(listEmployeeDto);
		assertThat(listEmployeeDto, containsInAnyOrder(employeeDto));
	}
	
	@Test
	public void findAllByEducationLevelPayTypeDepartmentTest() {
		// arrange
		String educationLevel = "Graduate Degree";
		String payType = "Monthly";
		String department = "Store Information Systems";
		
		List<EmployeeDepartmentPosition> mockEdp = new ArrayList<>();
		EmployeeDepartmentPosition edp = new EmployeeDepartmentPosition();
		Employee employee = new Employee();
		employee.setDepartmentId(888);
		employee.setFirstName("firstName");
		edp.setEmployee(employee);
		mockEdp.add(edp);
		
		EmployeeDepartmentPositionDto edpDto = new EmployeeDepartmentPositionDto();
		EmployeeDto employeeDto = new EmployeeDto();
		employeeDto.setDepartmentId(888);
		employeeDto.setFirstName("firstName");
		edpDto.setEmployeeDto(employeeDto);
		
		Mockito.doReturn(mockEdp).when(employeeRepository).findAllByEducationLevelPayTypeDepartment(educationLevel, payType, department);
		Mockito.doReturn(edpDto).when(employeeMapper).convertToDto(edp);
		
		// act
		List<EmployeeDepartmentPositionDto> listEmployee = 
				employeeService.findAllByEducationLevelPayTypeDepartment(educationLevel, payType, department);
		
		// assert
		assertNotNull(listEmployee);
		assertThat(listEmployee, containsInAnyOrder(edpDto));
	}
}
